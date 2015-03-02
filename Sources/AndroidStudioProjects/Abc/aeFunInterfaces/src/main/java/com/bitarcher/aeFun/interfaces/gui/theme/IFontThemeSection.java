package com.bitarcher.aeFun.interfaces.gui.theme;

import com.bitarcher.aeFun.interfaces.resourcemanagement.EResourceNotFound;

import org.andengine.opengl.font.Font;

/**
 * Created by michel on 22/01/15.
 */
public interface IFontThemeSection {

    Font getFont(EnumFontSize eFontSize) throws EResourceNotFound;

    Font getTextButtonFont();
}
