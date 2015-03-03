package com.bitarcher.aeFun.widgetToolkit.widget.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.ISpaceUsage;

/**
 * Created by michel on 01/03/15.
 */
class WidgetAndSpaceUsageTupleForBox extends WidgetAndSpaceUsageTuple {
    float scalar;

    public WidgetAndSpaceUsageTupleForBox(IWidget widget, ISpaceUsage spaceUsage) {
        super(widget, spaceUsage);
    }

    public float getScalar() {
        return scalar;
    }

    public void setScalar(float scalar) {
        this.scalar = scalar;
    }

    public float getScalarWithoutTwoMargin()
    {
        float retval = this.scalar - (this.getSpaceUsage().getMargin() * 2);

        if(retval < 0)
        {
            retval = 0;
        }

        return retval;
    }
}
