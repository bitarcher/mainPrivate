package com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.context.IContext;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.IResourceRequirementsStackUser;

/**
 * Created by michel on 09/03/15.
 */
public interface ILayout<TContext extends IContext> extends IResourceRequirementsStackUser {

    IWidget<TContext> getWidget();

    // create the sub entity and attach the to the widget, called by Widget ctor
    void onPopulate();

    // should be called by widget sub class ctor
    void onInit();

    TContext getContext();
}
