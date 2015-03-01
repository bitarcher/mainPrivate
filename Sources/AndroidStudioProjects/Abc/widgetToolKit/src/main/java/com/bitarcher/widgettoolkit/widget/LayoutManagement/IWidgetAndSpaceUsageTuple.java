package com.bitarcher.widgettoolkit.widget.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.interfacesOpenSource.gui.widgets.IWidget;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.ISpaceUsage;

public interface IWidgetAndSpaceUsageTuple {
    IWidget getWidget();
    ISpaceUsage getSpaceUsage();
}
