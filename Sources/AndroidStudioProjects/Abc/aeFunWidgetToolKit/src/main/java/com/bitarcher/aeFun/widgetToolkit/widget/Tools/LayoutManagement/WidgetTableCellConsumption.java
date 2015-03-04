package com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;

/**
 * Created by michel on 04/03/15.
 */
public class WidgetTableCellConsumption  implements IWidgetTableCellsConsumption{

    private IWidget widget;
    private int left;
    private int top;
    private int columnSpan;
    private int rowSpan;

    @Override
    public IWidget getWidget() {
        return widget;
    }

    @Override
    public int getLeft() {
        return left;
    }

    @Override
    public int getTop() {
        return top;
    }

    @Override
    public int getColumnSpan() {
        return columnSpan;
    }

    @Override
    public int getRowSpan() {
        return rowSpan;
    }

    public WidgetTableCellConsumption(IWidget widget, int left, int top, int columnSpan, int rowSpan) {

        this.widget = widget;
        this.left = left;
        this.top = top;
        this.columnSpan = columnSpan;
        this.rowSpan = rowSpan;
    }
}
