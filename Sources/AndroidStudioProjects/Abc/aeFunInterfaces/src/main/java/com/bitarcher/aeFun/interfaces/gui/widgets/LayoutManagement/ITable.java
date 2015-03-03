package com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.IOriginalWidthAndHeightResetable;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.ISpaceUsage;

/**
 * Created by michel on 03/03/15.
 */
public interface ITable extends IContainer, IOriginalWidthAndHeightResetable {
    void addColumn(ISpaceUsage spaceUsage);
    void addRow(ISpaceUsage spaceUsage);

    // see https://developer.gnome.org/gtk3/stable/GtkTable.html#gtk-table-attach
    void attach(IWidget widget, int leftAttach, int rightAttach, int topAttach, int bottomAttach);
}
