package com.bitarcher.scenemanagement;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.sceneManagement.IManagedScene;

import org.andengine.entity.scene.Scene;

public abstract class ManagedScene extends Scene implements IManagedScene {

    IResourceManager resourceManager;

	// Tells the Scene Manager that the managed scene either has or doesn't have a loading screen.
	private final boolean hasLoadingScreen;
	// The minimum length of time (in seconds) that the loading screen should be displayed.
	private final float minLoadingScreenTime;
	// Keeps track of how long the loading screen has been visible. Set by the SceneManager.
    private float elapsedLoadingScreenTime = 0f;
	// Is set TRUE if the scene is loaded.
    private boolean isLoaded = false;
	// Convenience constructor that disables the loading screen.
	public ManagedScene(IResourceManager resourceManager) {
		this(resourceManager, 0f);
	}
	// Constructor that sets the minimum length of the loading screen and sets hasLoadingScreen accordingly.
	public ManagedScene(IResourceManager resourceManager, final float pLoadingScreenMinimumSecondsShown) {
        this.resourceManager = resourceManager;
		minLoadingScreenTime = pLoadingScreenMinimumSecondsShown;
		hasLoadingScreen = (getMinLoadingScreenTime() > 0f);
	}
	// Called by the Scene Manager. It calls onLoadScene if loading is needed, sets the isLoaded status, and pauses the scene while it's not shown.
	public void onLoadManagedScene() {
		if(!isLoaded()) {
			onLoadScene();
			setLoaded(true);
			this.setIgnoreUpdate(true);
		}
	}
	// Called by the Scene Manager. It calls onUnloadScene if the scene has been previously loaded and sets the isLoaded status.
	public void onUnloadManagedScene() {
		if(isLoaded()) {
			setLoaded(false);
			onUnloadScene();
		}
	}
	// Called by the Scene Manager. It unpauses the scene before showing it.
	public void onShowManagedScene() {
		this.setIgnoreUpdate(false);
		onShowScene();
	}
	// Called by the Scene Manager. It pauses the scene before hiding it.
	public void onHideManagedScene() {
		this.setIgnoreUpdate(true);
		onHideScene();
	}
	// Methods to Override in the subclasses.
	public abstract Scene onLoadingScreenLoadAndShown();
	public abstract void onLoadingScreenUnloadAndHidden();
	public abstract void onLoadScene();
	public abstract void onShowScene();
	public abstract void onHideScene();
	public abstract void onUnloadScene();

    public boolean getHasLoadingScreen() {
        return hasLoadingScreen;
    }

    public float getMinLoadingScreenTime() {
        return minLoadingScreenTime;
    }

    public float getElapsedLoadingScreenTime() {
        return elapsedLoadingScreenTime;
    }

    public void setElapsedLoadingScreenTime(float elapsedLoadingScreenTime) {
        this.elapsedLoadingScreenTime = elapsedLoadingScreenTime;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean isLoaded) {
        this.isLoaded = isLoaded;
    }
}