package com.bitarcher.interfaces.gui.theme;

import com.bitarcher.interfaces.basicioc.INamed;
import com.bitarcher.interfaces.basicioc.IService;
import com.bitarcher.interfaces.resourcemanagement.EResourceNotFound;

import org.andengine.opengl.font.Font;

/**
 * Created by michel on 21/01/15.
 */
public interface ITheme extends INamed, IService{
    IThemeManager getThemeManager();

    IFontThemeSection getFontThemeSection();
    ITextButtonSection getTextButtonSection();

}
