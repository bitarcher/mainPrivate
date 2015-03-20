package com.bitarcher.aeFunExamples;


import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.andEngine.IScene;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.sceneManagement.IMainMenu;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFunExamplesShowRoom.sceneManagement.ManagedMenuScene;
import com.bitarcher.aeFunExamplesShowRoom.widgetToolkit.widget.Table;
import com.bitarcher.aeFunExamplesShowRoom.widgetToolkit.widget.TextButton;

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
        this.table = new Table(this.getSceneManager().getTheme(), this.getWidth() / 2, this.getHeight() / 2, 600, 400);

        this.table.addHomogeneousColumnsAndRows(2, 2);

        this.widgetGalleryTextButton = new TextButton(this.getSceneManager().getTheme(), 0, 0, 0, 0, "Widget gallery");
        this.table.attachChild(this.widgetGalleryTextButton);

        this.resourceManagerTextButton = new TextButton(this.getSceneManager().getTheme(), 0, 0, 0, 0, "Resource manager");
        this.table.attachChild(this.resourceManagerTextButton);


        this.attachChild(this.table);

    }




    @Override
    public void onUnloadScene() {
        this.mChildren.clear();
    }
}
