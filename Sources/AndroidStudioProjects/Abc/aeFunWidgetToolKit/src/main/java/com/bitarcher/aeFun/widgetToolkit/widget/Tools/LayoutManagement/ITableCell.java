package com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 04/03/15.
 */
public interface ITableCell extends IPosition, ISize{
    int getColumn();
    int getRow();

    // returns null if there is none actually
    IWidgetTableCellsConsumption getWidgetTableCellsConsumption();
    void setWidgetTableCellsConsumption(IWidgetTableCellsConsumption widgetTableCellsConsumption);
}
