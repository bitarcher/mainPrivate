package com.bitarcher.interfacesProtected.gui.theme;

import com.bitarcher.interfacesProtected.basicioc.INamed;
import com.bitarcher.interfacesProtected.basicioc.IService;

/**
 * Created by michel on 21/01/15.
 */
public interface ITheme extends INamed, IService{
    IThemeManager getThemeManager();

    IFontThemeSection getFontThemeSection();
    ITextButtonSection getTextButtonSection();
    IArrows getArrows();
}
