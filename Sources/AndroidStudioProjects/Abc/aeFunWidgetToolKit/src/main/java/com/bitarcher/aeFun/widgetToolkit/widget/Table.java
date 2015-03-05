package com.bitarcher.aeFun.widgetToolkit.widget;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.ITable;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.ETableCellNotEmpty;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.ISpaceUsage;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.Container;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.PercentSpaceUsage;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.ScalarComputerBySpaceUsage;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.TableColumn;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.TableRow;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.TableCell;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement.WidgetTableCellConsumption;

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
        TableCell foundEmptyTableCell = null;

        for(SmartList<TableCell> rowTableCell : tableCells)
        {
            for(TableCell tc : rowTableCell)
            {
                if(tc.getWidgetTableCellsConsumption() == null)
                {
                    foundEmptyTableCell = tc;
                    break;
                }
            }

            if(foundEmptyTableCell != null)
            {
                break;
            }
        }

        if(foundEmptyTableCell != null)
        {
            WidgetTableCellConsumption widgetTableCellConsumption= new WidgetTableCellConsumption(widget, foundEmptyTableCell.getColumnNum(), foundEmptyTableCell.getRowNum(), 1, 1);
            foundEmptyTableCell.setWidgetTableCellsConsumption(widgetTableCellConsumption);
            this.widgetTableCellConsumptions.add(widgetTableCellConsumption);
            this.recomputeWidgetSizeAndPositionByWidgetTableCellConsumption(widgetTableCellConsumption);
        }
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

    TableCell findFirstCoveringTableCellByExistingWidget(int left, int top, int columnsSpan, int rowSpan)
    {
        TableCell retval = null;

        for(int i = left ; i < left + columnsSpan - 1 ; i++)
        {


            for(int j = top ; j < top + rowSpan - 1; j++)
            {

                TableCell tableCell = this.getTableCell(i, j);
                if(tableCell.getWidgetTableCellsConsumption() != null)
                {
                    retval = tableCell;
                    break;
                }
            }

            if(retval != null)
            {
                break;
            }
        }

        return retval;
    }

    @Override
    public void attachChild(IWidget widget, int left, int top, int columnsSpan, int rowSpan) {

        TableCell foundCoveredTableCell = this.findFirstCoveringTableCellByExistingWidget(left, top, columnsSpan, rowSpan);

        if(foundCoveredTableCell != null)
        {
            throw new ETableCellNotEmpty(this, widget, left, top, columnsSpan, rowSpan, foundCoveredTableCell.getColumnNum(), foundCoveredTableCell.getRowNum());
        }

        WidgetTableCellConsumption widgetTableCellConsumption = new WidgetTableCellConsumption(widget, left, top, columnsSpan, rowSpan);
        this.widgetTableCellConsumptions.add(widgetTableCellConsumption);

        this.entityAttachChild(widget);

        this.recomputeWidgetSizeAndPositionByWidgetTableCellConsumption(widgetTableCellConsumption);
    }

    @Override
    public void attachChild(IWidget widget, int left, int top) {
        this.attachChild(widget, left, top, 1, 1);
    }

    @Override
    public void doDetachChild(final IWidget widget)
    {
        this.widgetTableCellConsumptions.remove(new IMatcher<WidgetTableCellConsumption>() {
            @Override
            public boolean matches(WidgetTableCellConsumption pObject) {
                return pObject.getWidget() == widget;
            }
        });

        this.entityDetachChild(widget);
    }

    @Override
    public void resetOriginalWidthAndHeight(float originalWidth, float originalHeight) {
        this.setOriginalWidth(originalWidth);
        this.setOriginalHeight(originalHeight);
    }

    private void recomputeColumnsSizeAndPosition()
    {
        ScalarComputerBySpaceUsage scalarComputerBySpaceUsage = new ScalarComputerBySpaceUsage();

        scalarComputerBySpaceUsage.compute(this.tableColumns, this.getOriginalWidth(), this.getPadding(), this.isShouldFixedSpaceUsageBeResizedOnResize());
    }

    private void recomputeRowsSizeAndPosition()
    {
        ScalarComputerBySpaceUsage scalarComputerBySpaceUsage = new ScalarComputerBySpaceUsage();

        scalarComputerBySpaceUsage.compute(this.tableColumns, this.getOriginalHeight(), this.getPadding(), this.isShouldFixedSpaceUsageBeResizedOnResize());
    }

    private void recomputeCells()
    {
        this.tableCells.clear();

        int indexTableRow = 0;
        float startX = this.getPadding();
        float startY = this.getPadding();


        float currentY = startY;


        for(TableRow tableRow: this.tableRows)
        {
            float currentX = startX;
            int indexTableColumn = 0;
            SmartList<TableCell> currentRowTableCells = new SmartList<>();
            this.tableCells.add(currentRowTableCells);
            float ch = tableRow.getScalarWithoutTwoMargin();
            float cy = currentY + tableRow.getScalar() / 2;

            for(TableColumn tableColumn:this.tableColumns) {

                TableCell tableCell = new TableCell(indexTableColumn, indexTableRow, tableColumn, tableRow);

                currentRowTableCells.add(tableCell);

                float cw = tableColumn.getScalarWithoutTwoMargin();
                float cx = currentX + tableColumn.getScalar() / 2;

                tableCell.setPosition(cx, cy);
                tableCell.setSize(cw, ch);

                currentX += tableColumn.getScalar();
                indexTableColumn++;
            }

            currentY += tableRow.getScalar();
            indexTableRow++;
        }

        this.setTableCellsWidgetReference();
    }

    // precondition : all widget pointers of cells are set to empty
    void setTableCellsWidgetReference()
    {
        for(WidgetTableCellConsumption widgetTableCellConsumption:this.widgetTableCellConsumptions)
        {
            for(int i = 0 ; i < widgetTableCellConsumption.getColumnSpan() ; i++)
            {
                int column = widgetTableCellConsumption.getLeft() + i;

                for(int j = 0 ; j < widgetTableCellConsumption.getRowSpan(); j++)
                {
                    int row = widgetTableCellConsumption.getTop() + j;

                    TableCell tableCell = this.getTableCell(column, row);
                    tableCell.setWidgetTableCellsConsumption((widgetTableCellConsumption));
                }
            }
        }
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
        for(WidgetTableCellConsumption widgetTableCellConsumption : this.widgetTableCellConsumptions)
        {
            this.recomputeWidgetSizeAndPositionByWidgetTableCellConsumption(widgetTableCellConsumption);
        }

        this.raiseChildrenPositionRecomputed();
    }

    private void recomputeWidgetSizeAndPositionByWidgetTableCellConsumption(WidgetTableCellConsumption widgetTableCellConsumption)
    {
        TableCell leftTopCell = this.getTableCell(widgetTableCellConsumption.getLeft(), widgetTableCellConsumption.getTop());
        TableCell rightBottomCell = this.getTableCell(widgetTableCellConsumption.getLeft() + widgetTableCellConsumption.getColumnSpan() - 1, widgetTableCellConsumption.getTop() + widgetTableCellConsumption.getRowSpan() - 1);

        float startX = leftTopCell.getX();
        float startY = leftTopCell.getY();
        float endX = rightBottomCell.getX() + rightBottomCell.getWidth();
        float endY = rightBottomCell.getY() + rightBottomCell.getHeight();
        float width = endX - startX;
        float height = endY - startY;

        widgetTableCellConsumption.getWidget().setPosition(startX, startY);
        widgetTableCellConsumption.getWidget().setSize(width, height);

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

