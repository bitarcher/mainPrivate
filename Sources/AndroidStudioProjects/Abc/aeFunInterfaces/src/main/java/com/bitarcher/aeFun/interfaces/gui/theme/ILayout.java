package com.bitarcher.aeFun.interfaces.gui.theme;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.context.IContext;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceRequirementsStackUser;

/**
 * Created by michel on 09/03/15.
 */
public interface ILayout<TContext extends IContext> extends IResourceRequirementsStackUser {

    IWidget<TContext> getWidget();

    // create the sub entity and attach the to the widget
    void onPopulate();

    // all the field of the context are not null
    void onInit(TContext context);

    // only the field that have changed are not null
    void onContextChanged(TContext context);
}
