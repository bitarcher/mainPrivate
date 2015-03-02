package com.bitarcher.interfaces.interfaces.gui.theme;

import com.bitarcher.interfaces.interfaces.basicioc.INamed;
import com.bitarcher.interfaces.interfaces.basicioc.IService;

/**
 * Created by michel on 21/01/15.
 */
public interface ITheme extends INamed, IService{
    IThemeManager getThemeManager();

    IFontThemeSection getFontThemeSection();
    ITextButtonSection getTextButtonSection();
    IArrows getArrows();
}
