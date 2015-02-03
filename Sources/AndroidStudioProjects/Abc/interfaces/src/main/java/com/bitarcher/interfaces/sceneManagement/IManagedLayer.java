/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.sceneManagement;

import com.bitarcher.interfaces.gui.andEngine.IHUD;

/**
 * Created by michel on 03/02/15.
 */
public interface IManagedLayer extends IHUD{

    void onLoadLayer();
    void onShowLayer();
    void onHideLayer();
    void onUnloadLayer();

    boolean getHasLoaded();

    void setHasLoaded(boolean hasLoaded);

    boolean isUnloadOnHidden();

    void setUnloadOnHidden(boolean unloadOnHidden);
}
