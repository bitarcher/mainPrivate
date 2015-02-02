/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.sceneManagement;

import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.gui.theme.IThemeManager;
import com.bitarcher.interfaces.resourcemanagement.IResourceManager;

/**
 * Created by michel on 02/02/15.
 */
public interface ISceneManager<TResourceManager extends IResourceManager, TTheme extends ITheme> {

    TResourceManager getResourceManager();
    TTheme getTheme();
    IThemeManager getThemeManager();

}
