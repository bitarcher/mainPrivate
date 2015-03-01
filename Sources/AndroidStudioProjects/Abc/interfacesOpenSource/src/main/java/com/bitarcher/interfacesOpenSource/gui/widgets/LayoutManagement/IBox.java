package com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.interfacesOpenSource.gui.widgets.IWidget;

import java.util.List;

/**
 * Created by michel on 28/02/15.
 */
public interface IBox extends IWidget {

    void addBoxListener(IBoxListener boxListener);
    void removeBoxListener(IBoxListener boxListener);

    EnumOrientation getOrientation();

    void packStart(IWidget widget, ISpaceUsage spaceUsage);
    void packEnd(IWidget widget, ISpaceUsage spaceUsage);
    void removeWidget(IWidget widget);

}
