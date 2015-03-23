package com.bitarcher.aeFun.examples;


import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.andEngine.IScene;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.sceneManagement.IMainMenu;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFunExamplesShowRoom.sceneManagement.ManagedMenuScene;
import com.bitarcher.aeFunExamplesShowRoom.widgetToolkit.widget.Table;
import com.bitarcher.aeFunExamplesShowRoom.widgetToolkit.widget.TextButton;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.background.Background;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

public class MainMenu extends ManagedMenuScene implements IMainMenu{
    Table table;
    TextButton widgetGalleryTextButton;
    TextButton resourceManagerTextButton;
    TextButton characterTextButton;



	public MainMenu(ITSceneManager sceneManager) {
        super(sceneManager);
		this.setOnSceneTouchListenerBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionMoveEnabled(true);



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
        this.table = new Table(theme, camera.getWidth() / 2,  camera.getHeight() / 3, camera.getWidth(), camera.getHeight() / 2);

        this.table.addHomogeneousColumnsAndRows(2, 2, 5);

        this.widgetGalleryTextButton = new TextButton(this.getSceneManager().getTheme(), 0, 0, 10, 10, "Widget gallery");
        this.table.attachChild(this.widgetGalleryTextButton);

        this.resourceManagerTextButton = new TextButton(this.getSceneManager().getTheme(), 0, 0, 10, 10, "Resource manager");
        this.table.attachChild(this.resourceManagerTextButton);


        this.attachChild(this.table);

    }




    @Override
    public void onUnloadScene() {
        this.mChildren.clear();
    }
}
