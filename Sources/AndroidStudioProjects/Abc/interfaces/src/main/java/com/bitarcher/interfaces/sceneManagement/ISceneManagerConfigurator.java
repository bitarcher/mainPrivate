/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.sceneManagement;

import android.content.Context;

import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.gui.theme.IThemeManager;
import com.bitarcher.interfaces.resourcemanagement.IResourceManager;

import org.andengine.engine.Engine;

/**
 * Created by michel on 02/02/15.
 */
public interface ISceneManagerConfigurator<TResourceManager extends IResourceManager, TTheme extends ITheme, TMainMenu extends IMainMenu,
        TOptionsLayer extends IOptionsLayer> {
    TResourceManager getNewResourceManager();
    Engine getEngine();
    Context getContext();
    int getCameraWidth();
    int getCameraHeight();
    float getCameraScaleFactorX();
    float  getCameraScaleFactorY();
    TTheme getNewTheme(IThemeManager themeManager);
    TMainMenu getNewMainMenu(ITSceneManager<TResourceManager, TTheme, TMainMenu, TOptionsLayer> sceneManager, TTheme theme, TResourceManager resourceManager);
    TOptionsLayer getNewOptionsLayer(ITSceneManager<TResourceManager, TTheme, TMainMenu, TOptionsLayer> sceneManager, TTheme theme, TResourceManager resourceManager, TMainMenu  mainMenu);
}
