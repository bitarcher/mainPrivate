package com.bitarcher.widgettoolkit.widget.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.interfacesOpenSource.gui.theme.ITheme;
import com.bitarcher.interfacesOpenSource.gui.widgets.IWidget;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.EnumOrientation;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.IBox;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.IBoxListener;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.IFixedSpaceUsage;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.IPercentSpaceUsage;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.ISpaceUsage;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.IVBox;
import com.bitarcher.widgettoolkit.widget.Widget;

import org.andengine.util.IMatcher;
import org.andengine.util.adt.list.SmartList;

import java.util.ArrayList;

/**
 * Created by michel on 28/02/15.
 */
public class Box extends Widget implements IBox {

    ArrayList<IBoxListener> boxListenerArrayList = new ArrayList<>();
    SmartList<WidgetAndSpaceUsageTupleForBox> widgetAndSpaceUsageTupleForBoxes = new SmartList<>();

    protected Box(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(theme, pX, pY, pWidth, pHeight);
    }


    @Override
    public EnumOrientation getOrientation() {
        EnumOrientation retval = EnumOrientation.Horizontal;

        if(this instanceof IVBox)
        {
            retval = EnumOrientation.Vertical;
        }

        return retval;
    }

    @Override
    public void packStart(IWidget widget, ISpaceUsage spaceUsage) {
        this.widgetAndSpaceUsageTupleForBoxes.addFirst(new WidgetAndSpaceUsageTupleForBox(widget, spaceUsage));

        this.recomputeWidgetsSizeAndPositions();
    }

    @Override
    public void packEnd(IWidget widget, ISpaceUsage spaceUsage) {
        this.widgetAndSpaceUsageTupleForBoxes.addLast(new WidgetAndSpaceUsageTupleForBox(widget, spaceUsage));

        this.recomputeWidgetsSizeAndPositions();
    }

    @Override
    public void removeWidget(IWidget widget) {
        WidgetAndSpaceUsageTupleForBox foundTuple = null;
        final IWidget widget2 = widget;
        foundTuple = this.widgetAndSpaceUsageTupleForBoxes.get(new IMatcher<WidgetAndSpaceUsageTupleForBox>() {
            @Override
            public boolean matches(WidgetAndSpaceUsageTupleForBox pObject) {
                return pObject.getWidget() == widget2;
            }
        });


        if(foundTuple != null)
        {
            this.widgetAndSpaceUsageTupleForBoxes.remove(foundTuple);
            this.recomputeWidgetsSizeAndPositions();
        }
    }

    public void resetOriginalWidthAndHeight(float originalWidth, float originalHeight)
    {
        this.setOriginalWidth(originalWidth);
        this.setOriginalHeight(originalHeight);
    }

    void recomputeWidgetsSizeAndPositions()
    {
        ArrayList< WidgetAndSpaceUsageTupleForBox> fixedList = new ArrayList<>();
        ArrayList<WidgetAndSpaceUsageTuple> percentList = new ArrayList<>();
        float percentListTotal = 0;
        float fixedListTotal = 0;

        for(WidgetAndSpaceUsageTupleForBox widgetAndSpaceUsageTupleForBox: this.widgetAndSpaceUsageTupleForBoxes)
        {
            ISpaceUsage spaceUsage = widgetAndSpaceUsageTupleForBox.getSpaceUsage();

            if(spaceUsage instanceof IPercentSpaceUsage)
            {
                IPercentSpaceUsage percentSpaceUsage = (IPercentSpaceUsage) spaceUsage;
                percentList.add(widgetAndSpaceUsageTupleForBox);
                percentListTotal+= percentSpaceUsage.getPercentSpaceUsage();
            }
            else if(spaceUsage instanceof IFixedSpaceUsage)
            {
                IFixedSpaceUsage fixedSpaceUsage = (IFixedSpaceUsage)spaceUsage;
                fixedList.add(widgetAndSpaceUsageTupleForBox);
                fixedListTotal+=fixedSpaceUsage.getFixedSpaceUsage();
            }
            else
            {
                throw new RuntimeException("unsupported spaceUsage");
            }
        }

        boolean needsPercentWidgetToBeConsidered = true;

        if(this.getOrientation() == EnumOrientation.Horizontal)
        {
            needsPercentWidgetToBeConsidered = fixedListTotal < (this.getOriginalWidth() - 2 * this.getPadding());
        }
        else
        {
            needsPercentWidgetToBeConsidered = fixedListTotal < (this.getOriginalHeight() - 2 * this.getPadding());
        }

        // TODO, continue here

        for(IBoxListener boxListener : this.boxListenerArrayList)
        {
            boxListener.onBoxChildrenPositionRecomputed(this);
        }


    }

    @Override
    protected void onSizeChanged() {
        super.onSizeChanged();

        this.recomputeWidgetsSizeAndPositions();
    }

    @Override
    protected void onPaddingChanged() {
        super.onPaddingChanged();

        this.recomputeWidgetsSizeAndPositions();
    }


    @Override
    public void addBoxListener(IBoxListener boxListener) {
        this.boxListenerArrayList.add(boxListener);
    }

    @Override
    public void removeBoxListener(IBoxListener boxListener) {
        this.boxListenerArrayList.remove(boxListener);
    }
}

