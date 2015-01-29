/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abc.tests;

import com.bitarcher.abc.ResourceManagerSingleton;
import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.resourcemanagement.ResourceManager;
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
import org.andengine.ui.activity.SimpleBaseGameActivity;


public class TextButtonActivity extends SimpleBaseGameActivity {
    // ===========================================================
    // Constants
    // ===========================================================

    private static final int CAMERA_WIDTH = 720;
    private static final int CAMERA_HEIGHT = 480;
    ITheme theme;

    // ===========================================================

    @Override
    public EngineOptions onCreateEngineOptions() {
        final Camera camera = new Camera(0, 0, TextButtonActivity.CAMERA_WIDTH, TextButtonActivity.CAMERA_HEIGHT);

        return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(TextButtonActivity.CAMERA_WIDTH, TextButtonActivity.CAMERA_HEIGHT), camera);
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
        scene.setBackground(new Background(0.5f, 0.5f, 1f));

        TextButton textButton = new TextButton(this.theme, 200, 40, 350, 80, "Salut");

        scene.attachChild(textButton);

        TextButton textButton2 = new TextButton(this.theme, 200, 130, 350, 80, "Salut 2");

        scene.attachChild(textButton2);

        return scene;
    }
}
