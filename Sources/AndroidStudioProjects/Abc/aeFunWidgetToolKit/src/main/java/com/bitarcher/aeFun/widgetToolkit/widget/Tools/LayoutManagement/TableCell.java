package com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 04/03/15.
 */
public class TableCell implements ITableCell{
    int row;
    int column;
    float x, y, width, height;
    IWidgetTableCellsConsumption widgetTableCellsConsumption = null;

    @Override
    public IWidgetTableCellsConsumption getWidgetTableCellsConsumption() {
        return widgetTableCellsConsumption;
    }

    @Override
    public void setWidgetTableCellsConsumption(IWidgetTableCellsConsumption widgetTableCellsConsumption) {
        this.widgetTableCellsConsumption = widgetTableCellsConsumption;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }


    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public TableCell(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
