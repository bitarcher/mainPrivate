package com.bitarcher.interfacesOpenSource.gui.theme;

import com.bitarcher.interfacesOpenSource.basicioc.INamed;
import com.bitarcher.interfacesOpenSource.basicioc.IService;

/**
 * Created by michel on 21/01/15.
 */
public interface ITheme extends INamed, IService{
    IThemeManager getThemeManager();

    IFontThemeSection getFontThemeSection();
    ITextButtonSection getTextButtonSection();
    IArrows getArrows();
}
