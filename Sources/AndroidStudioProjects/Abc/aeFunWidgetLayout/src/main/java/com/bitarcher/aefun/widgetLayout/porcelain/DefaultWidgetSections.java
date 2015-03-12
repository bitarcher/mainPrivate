package com.bitarcher.aefun.widgetLayout.porcelain;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.theme.widgetSections.IImageButtonSection;
import com.bitarcher.aeFun.interfaces.gui.theme.widgetSections.ITextButtonSection;
import com.bitarcher.aeFun.interfaces.gui.theme.widgetSections.IWidgetSections;
import com.bitarcher.aefun.widgetLayout.porcelain.WidgetSections.DefaultImageButtonSections;
import com.bitarcher.aefun.widgetLayout.porcelain.WidgetSections.DefaultTextButtonSections;

/**
 * Created by michel on 10/03/15.
 */
public class DefaultWidgetSections implements IWidgetSections {
    ITheme theme;
    ITextButtonSection textButtonSection;
    IImageButtonSection imageButtonSection;


    public DefaultWidgetSections(ITheme theme) {
        this.theme = theme;
    }

    @Override
    public ITextButtonSection getTextButtonSection() {
        if(this.textButtonSection == null)
        {
            this.textButtonSection = new DefaultTextButtonSections(this.theme);
        }

        return this.textButtonSection;
    }

    @Override
    public IImageButtonSection getImageButtonSection() {
        if(this.imageButtonSection == null)
        {
            this.imageButtonSection = new DefaultImageButtonSections(this.theme);
        }

        return this.imageButtonSection;
    }
}

