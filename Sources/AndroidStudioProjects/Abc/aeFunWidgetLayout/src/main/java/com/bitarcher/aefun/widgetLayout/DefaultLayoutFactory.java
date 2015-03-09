package com.bitarcher.aefun.widgetLayout;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.ILayout;
import com.bitarcher.aeFun.interfaces.gui.theme.ILayoutFactory;
import com.bitarcher.aeFun.interfaces.gui.theme.context.IContext;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;

/**
 * Created by michel on 09/03/15.
 */
public class DefaultLayoutFactory implements ILayoutFactory {
    @Override
    public <TContext extends IContext> ILayout<TContext> make(IWidget<TContext> key) {
        ILayout<TContext> retval = null;

        // TODO

        return retval;
    }


}

