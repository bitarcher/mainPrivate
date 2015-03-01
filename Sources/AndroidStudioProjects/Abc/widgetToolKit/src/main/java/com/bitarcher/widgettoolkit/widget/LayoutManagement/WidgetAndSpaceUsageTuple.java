package com.bitarcher.widgettoolkit.widget.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.interfacesOpenSource.gui.widgets.IWidget;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.ISpaceUsage;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.IWidgetAndSpaceUsageTuple;

/**
 * Created by michel on 01/03/15.
 */
class WidgetAndSpaceUsageTuple implements IWidgetAndSpaceUsageTuple{
    IWidget widget;
    ISpaceUsage spaceUsage;

    @Override
    public IWidget getWidget() {
        return widget;
    }

    @Override
    public ISpaceUsage getSpaceUsage() {
        return spaceUsage;
    }

    WidgetAndSpaceUsageTuple(IWidget widget, ISpaceUsage spaceUsage) {
        this.widget = widget;
        this.spaceUsage = spaceUsage;
    }
}

