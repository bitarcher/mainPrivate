package com.bitarcher.aeFun.interfaces.gui.theme;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.context.IContext;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceRequirementsStackUser;

/**
 * Created by michel on 09/03/15.
 */
public interface ILayout<TContext extends IContext> extends IResourceRequirementsStackUser {
    void onPopulate();
    void onContextChanged(TContext context);
}
