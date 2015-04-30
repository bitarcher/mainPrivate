package com.bitarcher.abc;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFun.sceneManagement.ManagedMenuScene;

/**
 * Created by michel on 30/04/15.
 */
public abstract class AbcManagedMenuScene extends ManagedMenuScene {

    protected AbcManagedMenuScene(ITSceneManager sceneManager, float pLoadingScreenMinimumSecondsShown) {
        super(sceneManager, pLoadingScreenMinimumSecondsShown);
    }

    protected AbcManagedMenuScene(ITSceneManager sceneManager) {
        super(sceneManager);
    }

    public  MainMenu getMainMenu()
    {
        MainMenu retval = (MainMenu)this.getSceneManager().getMainMenu();

        return retval;
    }
}
