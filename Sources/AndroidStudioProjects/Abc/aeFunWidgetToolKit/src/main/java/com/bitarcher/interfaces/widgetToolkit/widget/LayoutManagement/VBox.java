package com.bitarcher.interfaces.widgetToolkit.widget.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.interfaces.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.interfaces.gui.widgets.LayoutManagement.IVBox;

/**
 * Created by michel on 01/03/15.
 */
public class VBox extends Box implements IVBox {
    public VBox(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(theme, pX, pY, pWidth, pHeight);
    }
}
