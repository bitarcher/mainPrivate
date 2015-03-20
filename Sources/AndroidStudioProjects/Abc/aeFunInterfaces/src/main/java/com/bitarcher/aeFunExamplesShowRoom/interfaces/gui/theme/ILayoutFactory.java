package com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.context.IContext;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.IWidget;

/**
 * Created by michel on 09/03/15.
 */
public interface ILayoutFactory {
    <TContext  extends IContext> ILayout<TContext> make(IWidget<TContext> key);
}
