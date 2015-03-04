package com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.IOriginalWidthAndHeightResetable;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.IShouldFixedSpaceUsageBeResizedOnResize;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.ISpaceUsage;

/**
 * Created by michel on 03/03/15.
 */
public interface ITable extends IContainer, IOriginalWidthAndHeightResetable, IShouldFixedSpaceUsageBeResizedOnResize {

    void addHomogeneousColumnsAndRows(int numOfColumns, int numOfRows);
    void addHomogeneousColumnsAndRows(int numOfColumns, int numOfRows, float margin);

    void addColumn(ISpaceUsage spaceUsage);
    void addRow(ISpaceUsage spaceUsage);

    int getNumOfColumns();
    int getNumOfRows();

    // https://developer.gnome.org/gtk3/stable/GtkGrid.html#gtk-grid-attachChild
    void attachChild(IWidget widget, int left, int right, int columnsSpan, int rowSpan);
    void attachChild(IWidget widget, int left, int right);

    void detachChild(IWidget widget);

    // may return null if none
    // https://developer.gnome.org/gtk3/stable/GtkGrid.html#gtk-grid-get-child-at
    IWidget getChildAt(int column, int row);
}
