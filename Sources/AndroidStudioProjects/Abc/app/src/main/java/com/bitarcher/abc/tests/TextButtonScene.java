/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abc.tests;

import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.scenemanagement.ManagedGameScene;
import com.bitarcher.scenemanagement.ManagedScene;
import com.bitarcher.widgettoolkit.widget.TextButton;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;

/**
 * Created by michel on 01/02/15.
 */
public class TextButtonScene extends ManagedGameScene {

    ITheme theme;

    public TextButtonScene(ITSceneManager sceneManager) {
        super(sceneManager);
        this.theme = theme;
    }

    @Override
    public void onLoadManagedScene() {
        super.onLoadManagedScene();

        this.setBackground(new Background(0.5f, 0.5f, 1f));

        TextButton textButton = new TextButton(this.theme, 200, 40, 350, 80, "Salut");

        this.attachChild(textButton);

        TextButton textButton2 = new TextButton(this.theme, 200, 130, 350, 80, "Salut 2");


        this.attachChild(textButton2);

    }
}
