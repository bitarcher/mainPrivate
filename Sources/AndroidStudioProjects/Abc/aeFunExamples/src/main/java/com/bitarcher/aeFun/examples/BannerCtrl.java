package com.bitarcher.aeFun.examples;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.widgetToolkit.widget.Table;

/**
 * Created by michel on 23/03/15.
 */
public class BannerCtrl extends Table {
    String sectionLabel;

    public String getSectionLabel() {
        return sectionLabel;
    }

    public BannerCtrl(ITheme theme, float pX, float pY, float pWidth, float pHeight, String sectionLabel) {
        super(theme, pX, pY, pWidth, pHeight);

        this.sectionLabel = sectionLabel;
    }
}
