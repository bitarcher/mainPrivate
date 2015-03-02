/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 *//*


package com.bitarcher.abc.tests;

import com.bitarcher.abc.ResourceManagerSingleton;
import com.bitarcher.aeFun.gui.theme.ITheme;
import ResourceManager;
import com.bitarcher.scenemanagement.ApplyingSceneManager;
import DefaultTheme;
import ThemeManager;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.util.FPSLogger;


public class TextButtonActivityBackup extends ApplyingSceneManager {
    // ===========================================================
    // Constants
    // ===========================================================

    private static final int CAMERA_WIDTH = 720;
    private static final int CAMERA_HEIGHT = 480;
    ITheme theme;

    // ===========================================================

    @Override
    public EngineOptions onCreateEngineOptions() {
        final Camera camera = new Camera(0, 0, TextButtonActivityBackup.CAMERA_WIDTH, TextButtonActivityBackup.CAMERA_HEIGHT);

        return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(TextButtonActivityBackup.CAMERA_WIDTH, TextButtonActivityBackup.CAMERA_HEIGHT), camera);
    }

    @Override
    public void onCreateResources() {
        ResourceManager resourceManager = ResourceManagerSingleton.getInstance();
        resourceManager.setup(this.mEngine, this.getApplicationContext(), CAMERA_WIDTH, CAMERA_HEIGHT, 1f, 1f);

        ThemeManager themeManager = new ThemeManager(resourceManager);

        this.theme = new DefaultTheme(themeManager, "raw/theme/default");
        themeManager.setCurrentTheme(theme);
    }

    @Override
    public Scene onCreateScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());

        final Scene scene = new Scene();

        return scene;
    }




}
*/
