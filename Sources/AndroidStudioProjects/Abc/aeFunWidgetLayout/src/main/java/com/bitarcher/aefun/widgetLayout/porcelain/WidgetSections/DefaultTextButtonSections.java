package com.bitarcher.aefun.widgetLayout.porcelain.WidgetSections;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.EnumFontSize;
import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.theme.widgetSections.ITextButtonSection;

import org.andengine.opengl.font.Font;

/**
 * Created by michel on 10/03/15.
 */
public class DefaultTextButtonSections implements ITextButtonSection{
    ITheme theme;

    public DefaultTextButtonSections(ITheme theme) {
        this.theme = theme;
    }

    @Override
    public Font getTextButtonFont() {
        return this.theme.getFontThemeSection().getFont(EnumFontSize.Medium);
    }
}
