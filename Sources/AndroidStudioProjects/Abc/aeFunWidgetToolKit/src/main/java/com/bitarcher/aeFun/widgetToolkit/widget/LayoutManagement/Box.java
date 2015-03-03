package com.bitarcher.aeFun.widgetToolkit.widget.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.EnumOrientation;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.IBox;

import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.IFixedSpaceUsage;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.IPercentSpaceUsage;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.ISpaceUsage;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.IVBox;


import org.andengine.util.IMatcher;
import org.andengine.util.adt.list.SmartList;

import java.util.ArrayList;

/**
 * Created by michel on 28/02/15.
 */
public class Box extends Container implements IBox {

    boolean shouldFixedSpaceUsageBeResizedOnResize;

    SmartList<WidgetAndSpaceUsageTupleForBox> widgetAndSpaceUsageTupleForBoxes = new SmartList<>();

    protected Box(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(theme, pX, pY, pWidth, pHeight);
    }

    @Override
    protected void doAddWidget(IWidget widget) {
        this.packStart(widget, new PercentSpaceUsage(0, 100f));
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
        if(this.getOrientation() == EnumOrientation.Horizontal) {
            this.widgetAndSpaceUsageTupleForBoxes.addLast(new WidgetAndSpaceUsageTupleForBox(widget, spaceUsage));
        }
        else
        {
            this.widgetAndSpaceUsageTupleForBoxes.addFirst(new WidgetAndSpaceUsageTupleForBox(widget, spaceUsage));
        }
        this.attachChild(widget);

        this.recomputeWidgetsSizeAndPositions();
    }

    @Override
    public void packEnd(IWidget widget, ISpaceUsage spaceUsage) {
        if(this.getOrientation() == EnumOrientation.Horizontal) {
            this.widgetAndSpaceUsageTupleForBoxes.addFirst(new WidgetAndSpaceUsageTupleForBox(widget, spaceUsage));
        }
        else {
            this.widgetAndSpaceUsageTupleForBoxes.addLast(new WidgetAndSpaceUsageTupleForBox(widget, spaceUsage));
        }
        this.attachChild(widget);

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
            this.detachChild(foundTuple.getWidget());
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


        // set scalar (with margin)

        for(WidgetAndSpaceUsageTupleForBox tuple : percentList)
        {
            IPercentSpaceUsage percentSpaceUsage = (IPercentSpaceUsage) tuple.getSpaceUsage();
            float scalar = scalarThatCanBeSharedByPercents * (percentSpaceUsage.getPercentSpaceUsage() / percentListTotal);

            tuple.setScalar(scalar);
        }


        float consumedScalar = 0;

        for (WidgetAndSpaceUsageTupleForBox tuple : fixedList) {
            IFixedSpaceUsage fixedSpaceUsage = (IFixedSpaceUsage) tuple.getSpaceUsage();
            float scalar = 0;
            boolean shouldScalarBeSetToZero = false;

            if(this.isShouldFixedSpaceUsageBeResizedOnResize())
            {
                if(needsPercentWidgetToBeConsidered)
                {
                    // we have enough space for fixed AND percent, so we use the fixed size

                    scalar = fixedSpaceUsage.getFixedSpaceUsage();
                }
                else
                {
                    // we don't have enough space for fixed AND percent, so percent's scalars will be zero
                    scalar = scalarThatCanBeSharedByPercents * (fixedSpaceUsage.getFixedSpaceUsage() / fixedListTotal);
                }
            }
            else {
                if(shouldScalarBeSetToZero)
                {
                    scalar = 0;
                }
                else {
                    scalar = scalarThatCanBeSharedByPercents * (fixedSpaceUsage.getFixedSpaceUsage() / percentListTotal);

                    if ((consumedScalar + scalar) > variableScalarMinusTwoPadding) {
                        // this one will be reduced and consecutive will be set to zero
                        scalar = consumedScalar + scalar - variableScalarMinusTwoPadding;
                        shouldScalarBeSetToZero = true;
                    }
                }
            }

            consumedScalar += scalar;
            tuple.setScalar(scalar);
        }

        // set position and size

        float startX = this.getPadding();
        float startY = this.getPadding();

        float currentX = startX;
        float currentY = startY;

        if(this.getOrientation() == EnumOrientation.Horizontal)
        {
            float ch = this.getHeight() - 2 * this.getPadding();
            float cy = this.getHeight() / 2;

            for (WidgetAndSpaceUsageTupleForBox tuple:this.widgetAndSpaceUsageTupleForBoxes) {
                float cw = tuple.getScalarWithoutTwoMargin();
                float cx = currentX + tuple.getScalar()/2;


                tuple.getWidget().setPosition(cx, cy);
                tuple.getWidget().setSize(cw, ch);


                currentX += tuple.getScalar();
            }
        }
        else
        {
            // vertical

            float cw = this.getWidth() - 2 * this.getPadding();
            float cx = this.getWidth() / 2;

            for (WidgetAndSpaceUsageTupleForBox tuple:this.widgetAndSpaceUsageTupleForBoxes) {
                float ch = tuple.getScalarWithoutTwoMargin();
                float cy = currentY + tuple.getScalar() /2;


                tuple.getWidget().setPosition(cx, cy);
                tuple.getWidget().setSize(cw, ch);

                currentY += tuple.getScalar();
            }
        }

        // raise recomputed

        this.raiseChildrenPositionRecomputed();
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



}

