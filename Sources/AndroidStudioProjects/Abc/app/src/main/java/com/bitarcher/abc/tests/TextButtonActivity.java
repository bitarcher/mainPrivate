/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abc.tests;


import android.content.Context;

import com.bitarcher.abc.MainMenu;
import com.bitarcher.interfaces.gui.theme.IThemeManager;
import com.bitarcher.interfaces.sceneManagement.ISceneManagerConfigurator;
import com.bitarcher.resourcemanagement.ResourceManager;
import com.bitarcher.scenemanagement.SceneManagedActivity;
import com.bitarcher.scenemanagement.SceneManager;
import com.bitarcher.widgettoolkit.theme.DefaultTheme;

import org.andengine.engine.Engine;


public class TextButtonActivity extends SceneManagedActivity<ResourceManager, DefaultTheme, MainMenu> {

    // ===========================================================
    // Constants
    // ===========================================================


    @Override
    protected ISceneManagerConfigurator<ResourceManager, DefaultTheme, MainMenu> getSceneManagerConfigurator() {
        return new ISceneManagerConfigurator<ResourceManager, DefaultTheme, MainMenu>() {
            @Override
            public ResourceManager getNewResourceManager() {
                return new ResourceManager();
            }

            @Override
            public Engine getEngine() {
                return mEngine;
            }

            @Override
            public Context getContext() {
                return getApplicationContext();
            }

            @Override
            public int getCameraWidth() {
                return 800;
            }

            @Override
            public int getCameraHeight() {
                return 480;
            }

            @Override
            public float getCameraScaleFactorX() {
                return 1.0f;
            }

            @Override
            public float getCameraScaleFactorY() {
                return 1.0f;
            }

            @Override
            public DefaultTheme getNewTheme(IThemeManager themeManager) {
                return new DefaultTheme(themeManager, "@Default");
            }

            @Override
            public MainMenu getNewMainMenu(DefaultTheme theme, ResourceManager resourceManager) {
                return new MainMenu(resourceManager);
            }
        };
    }


    // ===========================================================


    @Override
    public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) {


        //this.themeManager = new ThemeManager(resourceManager);
        //resourceManager.setup(this.mEngine, this.getApplicationContext(), CAMERA_WIDTH, CAMERA_HEIGHT, 1f, 1f, this.themeManager);

        //SceneManager.getInstance().setup(resourceManager);

        //this.theme = new DefaultTheme(themeManager, "raw/theme/default");
        //themeManager.setCurrentTheme(theme);

        super.onCreateResources(pOnCreateResourcesCallback);
    }

    @Override
    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) {
        super.onCreateScene(pOnCreateSceneCallback);

        TextButtonScene textButtonScene = new TextButtonScene(this.getSceneManager().getTheme());
        this.getSceneManager().showScene(textButtonScene);
    }

}
