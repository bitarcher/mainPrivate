package com.bitarcher.aeFun.examples;


import android.widget.RadioButton;

import com.bitarcher.aeFun.interfaces.gui.andEngine.IScene;
import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.sceneManagement.IManagedMenuScene;
import com.bitarcher.aeFun.interfaces.sceneManagement.IManagedScene;
import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFun.sceneManagement.ManagedMenuScene;
import com.bitarcher.aeFun.sceneManagement.ManagedScene;
import com.bitarcher.aeFun.widgetToolkit.widget.CheckButton;
import com.bitarcher.aeFun.widgetToolkit.widget.Table;
import com.bitarcher.aeFun.widgetToolkit.widget.TextButton;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.background.Background;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

public class CheckAndRadioButtonScene extends ManagedScene implements IManagedScene {
    Table table;
    BannerCtrl bannerCtrl;

    CheckButton checkButton1;
    CheckButton checkButton2;
    CheckButton checkButton3;
    RadioButton radioButton1a;
    RadioButton radioButton1b;
    RadioButton radioButton1c;
    RadioButton radioButton2a;
    RadioButton radioButton2b;



	public CheckAndRadioButtonScene(ITSceneManager sceneManager) {
        super(sceneManager);
	}

    @Override
    public void onShowScene() {

    }

    @Override
    public void onHideScene() {

    }

    // No loading screen means no reason to use the following methods.
	@Override
	public IScene onLoadingScreenLoadAndShown() {
		return null;
	}
	@Override
	public void onLoadingScreenUnloadAndHidden() {
	}

	@Override
    public void onLoadScene() {
        this.setBackgroundEnabled(true);
        this.setBackground(new Background(1, 1, 1));

        ITheme theme = this.getSceneManager().getTheme();
        Camera camera = theme.getThemeManager().getResourceManager().getEngine().getCamera();
        this.table = new Table(theme, camera.getWidth() / 2,  camera.getHeight() / 2, camera.getWidth(), camera.getHeight());
        //this.table = new Table(theme, camera.getWidth() / 2,  camera.getHeight() / 3 * 2, camera.getWidth(), camera.getHeight() / 3 * 2);

        this.table.addHomogeneousColumnsAndRows(2, 3, 5);
        //this.table.addHomogeneousColumnsAndRows(2, 2, 5);

        this.bannerCtrl = new BannerCtrl(theme, camera.getWidth() / 2,  camera.getHeight() / 6, camera.getWidth(), camera.getHeight() / 3, "Check and radio buttons");
        this.table.attachChild(this.bannerCtrl, 0, 0, 2, 1); // two columns span

        this.checkButton1 = new CheckButton(theme, 0, 0, 10, 10);
        this.checkButton1.setTranslatedLabel("Check button 1");
        this.table.attachChild(this.checkButton1, 0, 0);

        this.checkButton2 = new CheckButton(theme, 0, 0, 10, 10);
        this.checkButton2.setTranslatedLabel("Check button 2");
        this.table.attachChild(this.checkButton2, 0, 1);

        this.checkButton3 = new CheckButton(theme, 0, 0, 10, 10);
        this.checkButton3.setTranslatedLabel("Check button 3");
        this.table.attachChild(this.checkButton3, 0, 2);

        this.attachChild(this.table);
    }

    @Override
    public void onUnloadScene() {
        this.mChildren.clear();
    }
}
