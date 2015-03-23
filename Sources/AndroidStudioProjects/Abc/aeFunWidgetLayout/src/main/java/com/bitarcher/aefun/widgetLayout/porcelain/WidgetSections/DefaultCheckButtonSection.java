package com.bitarcher.aefun.widgetLayout.porcelain.WidgetSections;

import com.bitarcher.aeFun.interfaces.gui.theme.EnumFontSize;
import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.theme.widgetSections.ICheckButtonSection;


import org.andengine.opengl.font.Font;
import org.andengine.util.adt.color.Color;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 20/03/15.
 */
public class DefaultCheckButtonSection implements ICheckButtonSection {
    ITheme theme;

    public DefaultCheckButtonSection(ITheme theme) {
        this.theme = theme;
    }

    @Override
    public Font getCheckButtonFont() {
        return this.theme.getFontThemeSection().getFont(EnumFontSize.Medium);
    }

    @Override
    public Color getNormalColor1() {
        return this.theme.getColorsSection().getNormalColor1();
    }

    @Override
    public Color getActivatedColor1() {
        return this.theme.getColorsSection().getActivatedColor1();
    }

    @Override
    public Color getActivatedColor2() {
        return this.theme.getColorsSection().getActivatedColor2();
    }
}

