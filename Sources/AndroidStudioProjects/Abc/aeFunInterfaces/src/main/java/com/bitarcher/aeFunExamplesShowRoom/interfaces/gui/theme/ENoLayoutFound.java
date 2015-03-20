package com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.IWidget;

/**
 * Created by michel on 09/03/15.
 */
public class ENoLayoutFound extends RuntimeException {
    IWidget widget;

    public ENoLayoutFound(IWidget widget) {
        super("No layout found");
        this.widget = widget;
    }
}
