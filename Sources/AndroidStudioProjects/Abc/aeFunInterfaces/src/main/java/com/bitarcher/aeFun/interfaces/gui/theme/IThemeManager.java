package com.bitarcher.aeFun.interfaces.gui.theme;

import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;

/**
 * Created by michel on 21/01/15.
 */
public interface IThemeManager {
    IResourceManager getResourceManager();

    ITheme getCurrentTheme();
    void setCurrentTheme(ITheme theme);
}
