package com.bitarcher.interfaces.widgetToolkit.widget.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.interfaces.interfaces.gui.widgets.IWidget;
import com.bitarcher.interfaces.interfaces.gui.widgets.LayoutManagement.ISpaceUsage;

public interface IWidgetAndSpaceUsageTuple {
    IWidget getWidget();
    ISpaceUsage getSpaceUsage();
}
