package com.bitarcher.scenemanagement;


import com.bitarcher.interfacesProtected.sceneManagement.IManagedMenuScene;
import com.bitarcher.interfacesProtected.sceneManagement.ITSceneManager;

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