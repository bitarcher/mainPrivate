package com.bitarcher.aefun.widgetLayout;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.ILayout;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.ILayoutFactory;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.context.IContext;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.IImageButton;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.ITextButton;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.IWidget;
import com.bitarcher.aefun.widgetLayout.layouts.ImageButtonLayout;
import com.bitarcher.aefun.widgetLayout.layouts.TextButtonLayout;

/**
 * Created by michel on 09/03/15.
 */
public class DefaultLayoutFactory implements ILayoutFactory {
    @Override
    public <TContext extends IContext> ILayout<TContext> make(IWidget<TContext> key) {
        ILayout<TContext> retval = null;

        if(key instanceof ITextButton)
        {
            ITextButton keyS = (ITextButton)key;
            TextButtonLayout retS = new TextButtonLayout(keyS);
            retval = (ILayout<TContext>)retS;
        }
        else if (key instanceof IImageButton)
        {
            IImageButton keyS = (IImageButton)key;
            ImageButtonLayout retS = new ImageButtonLayout(keyS);
            retval = (ILayout<TContext>)retS;
        }

        return retval;
    }
}

