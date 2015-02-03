/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.sceneManagement;

import com.bitarcher.interfaces.gui.andEngine.IScene;

/**
 * Created by michel on 03/02/15.
 */
public interface IManagedScene extends IScene {
    boolean getHasLoadingScreen();

    float getMinLoadingScreenTime();

    float getElapsedLoadingScreenTime();

    void setElapsedLoadingScreenTime(float elapsedLoadingScreenTime);

    boolean isLoaded();

    void setLoaded(boolean isLoaded);
}
