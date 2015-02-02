package com.bitarcher.scenemanagement;


import com.bitarcher.interfaces.resourcemanagement.IResourceManager;

public abstract class ManagedMenuScene extends ManagedScene {
	public ManagedMenuScene(IResourceManager resourceManager, float pLoadingScreenMinimumSecondsShown) {
		super(resourceManager, pLoadingScreenMinimumSecondsShown);
	}
	public ManagedMenuScene(IResourceManager resourceManager) {
        super(resourceManager);
    }

	@Override
	public void onUnloadManagedScene() {
		if(isLoaded) {
			// For menus, we are disabling the reloading of resources.
			// isLoaded = false;
			onUnloadScene();
		}
	}


}