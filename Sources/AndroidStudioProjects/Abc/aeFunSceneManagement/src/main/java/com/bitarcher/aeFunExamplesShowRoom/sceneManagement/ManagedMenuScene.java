package com.bitarcher.aeFunExamplesShowRoom.sceneManagement;


import com.bitarcher.aeFunExamplesShowRoom.interfaces.sceneManagement.IManagedMenuScene;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.sceneManagement.ITSceneManager;

public abstract class ManagedMenuScene extends ManagedScene implements IManagedMenuScene {
	public ManagedMenuScene(ITSceneManager sceneManager, float pLoadingScreenMinimumSecondsShown) {
		super(sceneManager, pLoadingScreenMinimumSecondsShown);
	}
	public ManagedMenuScene(ITSceneManager sceneManager) {
        super(sceneManager);
    }

	@Override
	public void onUnloadManagedScene() {
		if(isLoaded()) {
			// For menus, we are disabling the reloading of resources. not isLoaded = false; nor  onUnloadScene();
		}
	}


}