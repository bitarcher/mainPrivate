package com.bitarcher.interfaces.gui;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;

/**
 * Created by michel on 21/01/15.
 */
public interface IThemeManager {
    IResourceManager getResourceManager();

    ITheme getCurrentTheme();
    void setCurrentTheme(ITheme theme);
}
