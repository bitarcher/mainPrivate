package com.bitarcher.scenemanagement;


import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.gui.theme.IThemeManager;
import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.interfaces.sceneManagement.ISceneManagerConfigurator;
import com.bitarcher.widgettoolkit.theme.ThemeManager;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.Scene;

public class SceneManager<TResourceManager extends IResourceManager, TTheme extends ITheme> implements ITSceneManager<TResourceManager, TTheme>
{
    TResourceManager resourceManager;
    TTheme theme;
    IThemeManager themeManager;

    public SceneManager(ISceneManagerConfigurator<TResourceManager, TTheme> sceneManagerConfigurator) {
        this.resourceManager = sceneManagerConfigurator.getNewResourceManager();

        this.themeManager = new ThemeManager(this.resourceManager);
        this.resourceManager.setup(sceneManagerConfigurator.getEngine(), sceneManagerConfigurator.getContext(), sceneManagerConfigurator.getCameraWidth(),
                sceneManagerConfigurator.getCameraHeight(), sceneManagerConfigurator.getCameraScaleFactorX(), sceneManagerConfigurator.getCameraScaleFactorY(), this.themeManager);

        this.theme = sceneManagerConfigurator.getNewTheme(this.themeManager);
        this.themeManager.setCurrentTheme(theme);



        this.mLoadingScreenHandler = new IUpdateHandler() {
            @Override
            public void onUpdate(float pSecondsElapsed) {
                // Increment the mNumFamesPassed
                mNumFramesPassed++;
                // And increment the amount of time that the loading screen has been visible.
                mNextScene.setElapsedLoadingScreenTime(mNextScene.getElapsedLoadingScreenTime() + pSecondsElapsed);
                // On the first frame AFTER the loading screen has been shown.
                if(mNumFramesPassed==1) {
                    // Hide and unload the previous scene if it exists.
                    if(mCurrentScene!=null) {
                        mCurrentScene.onHideManagedScene();
                        mCurrentScene.onUnloadManagedScene();
                    }
                    // Load the new scene.
                    mNextScene.onLoadManagedScene();
                }
                // On the first frame AFTER the scene has been completely loaded and the loading screen has been shown for its minimum limit.
                if(mNumFramesPassed>1 && mNextScene.getElapsedLoadingScreenTime() >= mNextScene.getMinLoadingScreenTime()) {
                    // Remove the loading screen that was set as a child in the showScene() method.
                    mNextScene.clearChildScene();
                    // Tell the new scene to unload its loading screen.
                    mNextScene.onLoadingScreenUnloadAndHidden();
                    // Tell the new scene that it is shown.
                    mNextScene.onShowManagedScene();
                    // Set the new scene to the current scene.
                    mCurrentScene = mNextScene;
                    // Reset the handler & loading screen variables to be ready for another use.
                    mNextScene.setElapsedLoadingScreenTime(0f);
                    mNumFramesPassed = -1;
                    resourceManager.getEngine().unregisterUpdateHandler(this);
                    mLoadingScreenHandlerRegistered = false;
                }
            }
            @Override public void reset() {}
        };
    }

    public TResourceManager getResourceManager()
    {
        return this.resourceManager;
    }

    public TTheme getTheme()
    {
        return this.theme;
    }

    public IThemeManager getThemeManager()
    {
        return this.themeManager;
    }

    // ====================================================
	// VARIABLES
	// ====================================================
	// These variables reference the current scene and next scene when switching scenes.
	public ManagedScene mCurrentScene;
	private ManagedScene mNextScene;
	// Keep a reference to the engine.




	// Used by the mLoadingScreenHandler, this variable ensures that the loading screen is shown for one frame prior to loading resources.
	private int mNumFramesPassed = -1;
	// Keeps the mLoadingScreenHandler from being registered with the engine if it has already been registered.
	private boolean mLoadingScreenHandlerRegistered = false;
	// An update handler that shows the loading screen of mNextScene before calling it to load.
	private IUpdateHandler mLoadingScreenHandler;
	// Set to TRUE in the showLayer() method if the camera had a HUD before the layer was shown.
	private boolean mCameraHadHud = false;
	// Boolean to reflect whether there is a layer currently shown on the screen.
	public boolean isLayerShown = false;
	// An empty place-holder scene that we use to apply the modal properties of the layer to the currently shown scene.
	private Scene mPlaceholderModalScene;
	// Hold a reference to the current managed layer (if one exists).
	public ManagedLayer currentLayer;

	// ====================================================
	// PUBLIC METHODS
	// ====================================================
	// Initiates the process of switching the current managed scene for a new managed scene.
	public void showScene(final ManagedScene pManagedScene) {
		// Reset the camera. This is automatically overridden by any calls to alter the camera from within a managed scene's onShowScene() method.
        this.resourceManager.getEngine().getCamera().set(0f, 0f, this.resourceManager.getCameraWidth(), this.resourceManager.getCameraHeight());
		// If the new managed scene has a loading screen.
		if(pManagedScene.getHasLoadingScreen()) {
			// Set the loading screen as a modal child to the new managed scene.
			pManagedScene.setChildScene(pManagedScene.onLoadingScreenLoadAndShown(),true,true,true);
			// This if/else block assures that the LoadingScreen Update Handler is only registered if necessary.
			if(mLoadingScreenHandlerRegistered){
				mNumFramesPassed = -1;
				mNextScene.clearChildScene();
				mNextScene.onLoadingScreenUnloadAndHidden();
			} else {
                this.resourceManager.getEngine().registerUpdateHandler(mLoadingScreenHandler);
				mLoadingScreenHandlerRegistered = true;
			}
			// Set pManagedScene to mNextScene which is used by the loading screen update handler.
			mNextScene = pManagedScene;
			// Set the new scene as the engine's scene.
            this.resourceManager.getEngine().setScene(pManagedScene);
			// Exit the method and let the LoadingScreen Update Handler finish the switching.
			return;
		}
		// If the new managed scene does not have a loading screen.
		// Set pManagedScene to mNextScene and apply the new scene to the engine.
		mNextScene = pManagedScene;
        this.resourceManager.getEngine().setScene(mNextScene);
		// If a previous managed scene exists, hide and unload it.
		if(mCurrentScene!=null)
		{
			mCurrentScene.onHideManagedScene();
			mCurrentScene.onUnloadManagedScene();
		}
		// Load and show the new managed scene, and set it as the current scene.
		mNextScene.onLoadManagedScene();
		mNextScene.onShowManagedScene();
		mCurrentScene = mNextScene;
	}
	
	// Convenience method to quickly show the Main Menu.
	public void showMainMenu() {
        // TODO
		//showScene(MainMenu.getInstance());
	}

	// Convenience method to quickly show the Options Layer.
	public void showOptionsLayer(final boolean pSuspendCurrentSceneUpdates) {
        // TODO
		//showLayer(OptionsLayer.getInstance(),false,pSuspendCurrentSceneUpdates,true);
	}

	// Shows a layer by placing it as a child to the Camera's HUD.
	public void showLayer(final ManagedLayer pLayer, final boolean pSuspendSceneDrawing, final boolean pSuspendSceneUpdates, final boolean pSuspendSceneTouchEvents) {
		// If the camera already has a HUD, we will use it.
		if(this.resourceManager.getEngine().getCamera().hasHUD()){
			mCameraHadHud = true;
		} else {
			// Otherwise, we will create one to use.
			mCameraHadHud = false;
			HUD placeholderHud = new HUD();
            this.resourceManager.getEngine().getCamera().setHUD(placeholderHud);
		}
		// If the managed layer needs modal properties, set them.
		if(pSuspendSceneDrawing || pSuspendSceneUpdates || pSuspendSceneTouchEvents) {
			// Apply the managed layer directly to the Camera's HUD
            this.resourceManager.getEngine().getCamera().getHUD().setChildScene(pLayer, pSuspendSceneDrawing, pSuspendSceneUpdates, pSuspendSceneTouchEvents);
			// Create the place-holder scene if it needs to be created.
			if(mPlaceholderModalScene==null) {
				mPlaceholderModalScene = new Scene();
				mPlaceholderModalScene.setBackgroundEnabled(false);
			}
			// Apply the place-holder to the current scene.
			mCurrentScene.setChildScene(mPlaceholderModalScene, pSuspendSceneDrawing, pSuspendSceneUpdates, pSuspendSceneTouchEvents);
		} else {
			// If the managed layer does not need to be modal, simply set it to the HUD.
            this.resourceManager.getEngine().getCamera().getHUD().setChildScene(pLayer);
		}
		// Set the camera for the managed layer so that it binds to the camera if the camera is moved/scaled/rotated.
		pLayer.setCamera(this.resourceManager.getEngine().getCamera());
		// Scale the layer according to screen size.
		pLayer.setScale(this.resourceManager.getCameraScaleX(), this.resourceManager.getCameraScaleY());
		// Let the layer know that it is being shown.
		pLayer.onShowManagedLayer();
		// Reflect that a layer is shown.
		isLayerShown = true;
		// Set the current layer to pLayer.
		currentLayer = pLayer;
	}

	// Hides the open layer if one is open.
	public void hideLayer() {
		if(isLayerShown) {
			// Clear the HUD's child scene to remove modal properties.
            this.resourceManager.getEngine().getCamera().getHUD().clearChildScene();
			// If we had to use a place-holder scene, clear it.
			if(mCurrentScene.hasChildScene())
				if(mCurrentScene.getChildScene()==mPlaceholderModalScene)
					mCurrentScene.clearChildScene();
			// If the camera did not have a HUD before we showed the layer, remove the place-holder HUD.
			if(!mCameraHadHud)
                this.resourceManager.getEngine().getCamera().setHUD(null);
			// Reflect that a layer is no longer shown.
			isLayerShown = false;
			// Remove the reference to the layer.
			currentLayer = null;
		}
	}
}