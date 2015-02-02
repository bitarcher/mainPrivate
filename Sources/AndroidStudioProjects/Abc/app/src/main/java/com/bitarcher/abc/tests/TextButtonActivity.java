/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abc.tests;

import com.bitarcher.abc.ResourceManagerSingleton;
import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.resourcemanagement.ResourceManager;
import com.bitarcher.scenemanagement.ApplyingSceneManager;
import com.bitarcher.scenemanagement.SceneManager;
import com.bitarcher.widgettoolkit.theme.DefaultTheme;
import com.bitarcher.widgettoolkit.theme.ThemeManager;
import com.bitarcher.widgettoolkit.widget.TextButton;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.util.FPSLogger;
import org.andengine.ui.IGameInterface;
import org.andengine.ui.activity.SimpleBaseGameActivity;


public class TextButtonActivity extends ApplyingSceneManager {
    // ===========================================================
    // Constants
    // ===========================================================





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

        TextButtonScene textButtonScene = new TextButtonScene(this.theme);
        SceneManager.getInstance().showScene(textButtonScene);
    }

}
