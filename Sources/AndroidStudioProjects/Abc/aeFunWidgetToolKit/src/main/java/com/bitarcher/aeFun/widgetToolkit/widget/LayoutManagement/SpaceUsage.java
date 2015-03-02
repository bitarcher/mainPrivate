package com.bitarcher.aeFun.widgetToolkit.widget.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.ISpaceUsage;

/**
 * Created by michel on 02/03/15.
 */
public abstract class SpaceUsage implements ISpaceUsage{
    float margin;

    @Override
    public float getMargin() {
        return this.margin;
    }

    protected SpaceUsage(float margin) {
        this.margin = margin;
    }
}
