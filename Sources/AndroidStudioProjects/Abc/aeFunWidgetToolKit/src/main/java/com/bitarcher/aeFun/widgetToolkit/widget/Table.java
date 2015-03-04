package com.bitarcher.aeFun.widgetToolkit.widget;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.ITable;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.ISpaceUsage;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.Container;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.PercentSpaceUsage;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.ScalarComputer;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.TableColumn;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.TableRow;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.TableCell;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.WidgetTableCellConsumption;

import org.andengine.entity.IEntity;
import org.andengine.util.IMatcher;
import org.andengine.util.adt.list.SmartList;

/**
 * Created by michel on 04/03/15.
 */
public class Table extends Container implements ITable {

    boolean shouldFixedSpaceUsageBeResizedOnResize = false;
    SmartList<TableColumn> tableColumns = new SmartList<>();
    SmartList<TableRow> tableRows = new SmartList<>();

    // outer list contains rows, inner list contains cell for current row
    SmartList<SmartList<TableCell>> tableCells = new SmartList<>();
    SmartList<WidgetTableCellConsumption> widgetTableCellConsumptions = new SmartList<>();

    public Table(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(theme, pX, pY, pWidth, pHeight);
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
    protected void doAddWidget(IWidget widget) {
        // TODO
    }

    void _addColumn(ISpaceUsage spaceUsage) {
        this.tableColumns.addFirst(new TableColumn(spaceUsage));
    }

    @Override
    public void addColumn(ISpaceUsage spaceUsage) {
        this._addColumn(spaceUsage);

        this.recomputeColumnsSizeAndPosition();
        this.recomputeCells();
        this.recomputeChildrenWidgetsSizeAndPosition();
    }

    void _addRow(ISpaceUsage spaceUsage) {
        this.tableRows.addLast(new TableRow(spaceUsage));
    }

    @Override
    public void addRow(ISpaceUsage spaceUsage) {
        this._addRow(spaceUsage);

        this.recomputeRowsSizeAndPosition();
        this.recomputeCells();
        this.recomputeChildrenWidgetsSizeAndPosition();
    }

    @Override
    public void addHomogeneousColumnsAndRows(int numOfColumns, int numOfRows) {
        this.addHomogeneousColumnsAndRows(numOfColumns, numOfRows, 0);
    }

    @Override
    public void addHomogeneousColumnsAndRows(int numOfColumns, int numOfRows, float margin) {
        for(int i= 0 ; i < numOfColumns ; i++)
        {
            this.addColumn(new PercentSpaceUsage(0, margin));
        }

        this.recomputeColumnsSizeAndPosition();

        for(int i= 0 ; i < numOfRows ; i++)
        {
            this.addRow(new PercentSpaceUsage(0, margin));
        }

        this.recomputeRowsSizeAndPosition();

        this.recomputeCells();
        this.recomputeChildrenWidgetsSizeAndPosition();
    }

    @Override
    public void attachChild(IWidget widget, int left, int right, int columnsSpan, int rowSpan) {
        // TODO, check that the cells are not already covered

        WidgetTableCellConsumption widgetTableCellConsumption = new WidgetTableCellConsumption(widget, left, right, columnsSpan, rowSpan);
        this.widgetTableCellConsumptions.add(widgetTableCellConsumption);

        super.attachChild(widget);
    }

    @Override
    public void attachChild(IWidget widget, int left, int right) {
        this.attachChild(widget, left, right, 1, 1);
    }

    @Override
    public void detachChild(final IWidget widget)
    {
        this.widgetTableCellConsumptions.remove(new IMatcher<WidgetTableCellConsumption>() {
            @Override
            public boolean matches(WidgetTableCellConsumption pObject) {
                return pObject.getWidget() == widget;
            }
        });

        super.detachChild(widget);
    }

    @Override
    public void resetOriginalWidthAndHeight(float originalWidth, float originalHeight) {
        this.setOriginalWidth(originalWidth);
        this.setOriginalHeight(originalHeight);
    }

    private void recomputeColumnsSizeAndPosition()
    {
        ScalarComputer scalarComputer = new ScalarComputer();

        scalarComputer.compute(this.tableColumns, this.getOriginalWidth(), this.getPadding(), this.isShouldFixedSpaceUsageBeResizedOnResize());
    }

    private void recomputeRowsSizeAndPosition()
    {
        ScalarComputer scalarComputer = new ScalarComputer();

        scalarComputer.compute(this.tableColumns, this.getOriginalHeight(), this.getPadding(), this.isShouldFixedSpaceUsageBeResizedOnResize());
    }

    private void recomputeCells()
    {
        this.tableCells.clear();

        int indexTableRow = 0;

        for(TableRow tableRow:this.tableRows)
        {
            int indexTableColumn = 0;
            SmartList<TableCell> currentRowTableCells = new SmartList<>();
            this.tableCells.add(currentRowTableCells);

            for(TableColumn tableColumn:this.tableColumns) {

                TableCell tableCell = new TableCell(indexTableRow, indexTableColumn);

                // TODO


                indexTableColumn++;
            }

            indexTableRow++;
        }

        this.setTableCellsWidgetReference();
    }

    void setTableCellsWidgetReference()
    {
        for(WidgetTableCellConsumption widgetTableCellConsumption:this.widgetTableCellConsumptions)
        {

        }
    }

    @Override
    public void attachChild(IEntity pEntity) {

        super.attachChild(pEntity);
    }

    @Override
    public boolean detachChild(IEntity pEntity) {
        return super.detachChild(pEntity);
    }

    @Override
    public IWidget getChildAt(int column, int row)
    {
        IWidget retval = null;

        TableCell cell = this.getTableCell(column, row);

        retval = cell.getWidgetTableCellsConsumption().getWidget();

        return retval;
    }

    protected TableCell getTableCell(int column, int row)
    {
        TableCell retval = null;

        retval = this.tableCells.get(row).get(column);

        return retval;
    }

    private void recomputeChildrenWidgetsSizeAndPosition()
    {
        // TODO

        this.raiseChildrenPositionRecomputed();
    }

    @Override
    public int getNumOfColumns() {
        return this.tableColumns.size();
    }

    @Override
    public int getNumOfRows() {
        return this.tableRows.size();
    }
}

