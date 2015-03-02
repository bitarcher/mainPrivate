package com.bitarcher.interfaces.interfaces.gui.theme;

import com.bitarcher.interfaces.interfaces.resourcemanagement.IResourceManager;

/**
 * Created by michel on 21/01/15.
 */
public interface IThemeManager {
    IResourceManager getResourceManager();

    ITheme getCurrentTheme();
    void setCurrentTheme(ITheme theme);
}
