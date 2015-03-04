package com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;

/**
 * Created by michel on 03/03/15.
 */
public interface IContainer extends IWidget {
    void attachChild(IWidget widget);

    void addContainerListener(IContainerListener containerListener);
    void removeContainerListener(IContainerListener containerListener);
}

