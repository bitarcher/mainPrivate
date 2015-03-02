package com.bitarcher.aeFun.widgetToolkit.widget.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.EnumOrientation;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.IBox;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.IBoxListener;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.IFixedSpaceUsage;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.IPercentSpaceUsage;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.ISpaceUsage;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.IVBox;
import com.bitarcher.aeFun.widgetToolkit.widget.Widget;

import org.andengine.util.IMatcher;
import org.andengine.util.adt.list.SmartList;

import java.util.ArrayList;

/**
 * Created by michel on 28/02/15.
 */
public class Box extends Widget implements IBox {

    boolean shouldFixedSpaceUsageBeResizedOnResize;
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
    public boolean isShouldFixedSpaceUsageBeResizedOnResize() {
        return shouldFixedSpaceUsageBeResizedOnResize;
    }

    @Override
    public void setShouldFixedSpaceUsageBeResizedOnResize(boolean shouldFixedSpaceUsageBeResizedOnResize) {
        this.shouldFixedSpaceUsageBeResizedOnResize = shouldFixedSpaceUsageBeResizedOnResize;
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
        ArrayList<WidgetAndSpaceUsageTupleForBox> percentList = new ArrayList<>();
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

        float variableScalarMinusTwoPadding = 0;
        float variableScalar = 0;




        if(this.getOrientation() == EnumOrientation.Horizontal)
        {
            variableScalar = this.getOriginalWidth();
        }
        else
        {
            variableScalar =  this.getOriginalHeight();
        }

        variableScalarMinusTwoPadding = variableScalar - 2 * this.getPadding();
        float scalarThatCanBeSharedByPercents = variableScalarMinusTwoPadding - fixedListTotal;

        if(scalarThatCanBeSharedByPercents < 0)
            scalarThatCanBeSharedByPercents = 0;

        boolean needsPercentWidgetToBeConsidered = true;
        needsPercentWidgetToBeConsidered = fixedListTotal < variableScalarMinusTwoPadding;



        for(WidgetAndSpaceUsageTupleForBox tuple : percentList)
        {
            IPercentSpaceUsage percentSpaceUsage = (IPercentSpaceUsage) tuple.getSpaceUsage();
            float scalar = scalarThatCanBeSharedByPercents * (percentSpaceUsage.getPercentSpaceUsage() / percentListTotal);

            tuple.setScalar(scalar);
        }

        if(this.isShouldFixedSpaceUsageBeResizedOnResize())
        {

        }
        else {
            float consumedScalar = 0;

            for (WidgetAndSpaceUsageTupleForBox tuple : fixedList) {
                IPercentSpaceUsage percentSpaceUsage = (IPercentSpaceUsage) tuple.getSpaceUsage();
                float scalar = scalarThatCanBeSharedByPercents * (percentSpaceUsage.getPercentSpaceUsage() / percentListTotal);

                tuple.setScalar(scalar);
            }
        }


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

        this.recomputeWidgetsSizeAndPositions();
    }
}

