package com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.Containers;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.context.IContext;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.IWidget;

/**
 * Created by michel on 03/03/15.
 */
public interface IContainer<TContext extends IContext> extends IWidget<TContext> {
    void attachChild(IWidget widget);
    void detachChild(IWidget widget);

    void addContainerListener(IContainerListener containerListener);
    void removeContainerListener(IContainerListener containerListener);
}

