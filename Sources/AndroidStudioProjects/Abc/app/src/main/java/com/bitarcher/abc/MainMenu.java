package com.bitarcher.abc;


import com.bitarcher.interfaces.gui.andEngine.IScene;
import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.ITexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.interfaces.sceneManagement.IMainMenu;
import com.bitarcher.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.scenemanagement.ManagedMenuScene;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.math.MathUtils;

public class MainMenu extends ManagedMenuScene implements IMainMenu{
	
	/*private static final MainMenu INSTANCE = new MainMenu();
	public static MainMenu getInstance(){
		return INSTANCE;
	}
	*/
	public MainMenu(ITSceneManager sceneManager) {
        super(sceneManager);
		this.setOnSceneTouchListenerBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionMoveEnabled(true);
	}


    // No loading screen means no reason to use the following methods.
	@Override
	public IScene onLoadingScreenLoadAndShown() {
		return null;
	}
	@Override
	public void onLoadingScreenUnloadAndHidden() {
	}
	
	// The objects that will make up our Main Menu
	private Sprite BackgroundSprite;
	private ButtonSprite PlayButton;
	private Text PlayButtonText;
	private ButtonSprite OptionsButton;
	private Text OptionsButtonText;
	private Sprite[] CloudSprites;
	private Text TitleText;

	@Override
    public void onLoadScene() {
		// Load the menu resources
		//this.resourceManager.loadMenuResources();
		
		// Create the background

		BackgroundSprite = new Sprite(this.getSceneManager().getResourceManager().getCameraWidth()/2f, this.getSceneManager().getResourceManager().getCameraHeight()/2f, OriginalOldResourceManager.menuBackgroundTextureRegion, OriginalOldResourceManager.getInstance().engine.getVertexBufferObjectManager());
		BackgroundSprite.setScaleX(this.getSceneManager().getResourceManager().getCameraScaleX());
		BackgroundSprite.setScaleY(this.getSceneManager().getResourceManager().getCameraHeight()/480f);
		BackgroundSprite.setZIndex(-5000);
		this.attachChild(BackgroundSprite);


        // TODO
        ITexturesSetResourceInfo texturesSetResourceInfo = this.getSceneManager().getTheme().getTextButtonSection().getTexturesSetResourceInfo();
        this.getSceneManager().getResourceManager().pushRequirement(texturesSetResourceInfo);
        ITextureRegion cloudTextureRegion = this.getSceneManager().getResourceManager().getTextureRegionFromTextureSetByName(texturesSetResourceInfo, "normal")


		
		// Create clouds that move from one side of the screen to the other, and repeat.
		CloudSprites = new Sprite[20];
        final MainMenu mainMenu = this;

		for(Sprite curCloudSprite: CloudSprites){
			curCloudSprite = new Sprite(
					MathUtils.random(-(this.getWidth() * this.getScaleX()) / 2, this.getSceneManager().getResourceManager().getCameraWidth() + (this.getWidth() * this.getScaleX()) / 2),
					MathUtils.random(-(this.getHeight()*this.getScaleY())/2, this.getSceneManager().getResourceManager().getCameraHeight() + (this.getHeight()*this.getScaleY())/2),
                    cloudTextureRegion,
                    this.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager()) {
				private float XSpeed = MathUtils.random(0.2f, 2f);
				private boolean initialized = false;
				@Override
				protected void onManagedUpdate(final float pSecondsElapsed) {
					super.onManagedUpdate(pSecondsElapsed);
					if(!initialized) {
						initialized = true;
						this.setScale(XSpeed/2);
						this.setZIndex(-4000+Math.round(XSpeed*1000f));
						mainMenu.sortChildren();
					}
					if(this.getX()<-(this.getWidth()*this.getScaleX())/2) {
						XSpeed = MathUtils.random(0.2f, 2f);
						this.setScale(XSpeed/2);
						this.setPosition(mainMenu.getSceneManager().getResourceManager().getCameraWidth()+(this.getWidth()*this.getScaleX())/2,
                                MathUtils.random(-(this.getHeight()*this.getScaleY())/2, mainMenu.getSceneManager().getResourceManager().getCameraHeight() + (this.getHeight()*this.getScaleY())/2));
						
						this.setZIndex(-4000+Math.round(XSpeed*1000f));
						mainMenu.sortChildren();
					}
					this.setPosition(this.getX()-(XSpeed*(pSecondsElapsed/0.016666f)), this.getY());
				}
			};
			this.attachChild(curCloudSprite);
		}


		// Create a Play button. Notice that the Game scenes, unlike menus, are not referred to in a static way.

		PlayButton = new ButtonSprite(
				(this.getSceneManager().getResourceManager().getCameraWidth()- OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(0).getWidth())/2f,
				(OriginalOldResourceManager.getInstance().cameraHeight- OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(0).getHeight())*(1f/3f),
				OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(0),
				OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(1),
				OriginalOldResourceManager.getInstance().engine.getVertexBufferObjectManager());
		PlayButtonText = new Text(0, 0, OriginalOldResourceManager.fontDefault32Bold, "PLAY", OriginalOldResourceManager.getInstance().engine.getVertexBufferObjectManager());
		PlayButtonText.setPosition((PlayButton.getWidth())/2, (PlayButton.getHeight())/2);
		PlayButton.attachChild(PlayButtonText);
		this.attachChild(PlayButton);
		PlayButton.setOnClickListener(new ButtonSprite.OnClickListener() {
			@Override
			public void onClick(ButtonSprite pButtonSprite,
					float pTouchAreaLocalX, float pTouchAreaLocalY) {
				// Create a new GameLevel and show it using the SceneManager. And play a click.
				SceneManager.getInstance().showScene(new GameLevel(getSceneManager()));
				OriginalOldResourceManager.clickSound.play();
			}});
		this.registerTouchArea(PlayButton);
		
		// Create an Option button. Notice that the SceneManager is being told to not pause the scene while the OptionsLayer is open.
		OptionsButton = new ButtonSprite(
				PlayButton.getX()+PlayButton.getWidth(), 
				PlayButton.getY(),
				OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(0),
				OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(1),
				OriginalOldResourceManager.getInstance().engine.getVertexBufferObjectManager());
		OptionsButtonText = new Text(0,0, OriginalOldResourceManager.fontDefault32Bold,"OPTIONS", OriginalOldResourceManager.getInstance().engine.getVertexBufferObjectManager());
		OptionsButtonText.setPosition((OptionsButton.getWidth())/2, (OptionsButton.getHeight())/2);
		OptionsButton.attachChild(OptionsButtonText);
		this.attachChild(OptionsButton);
		OptionsButton.setOnClickListener(new ButtonSprite.OnClickListener() {
			@Override
			public void onClick(ButtonSprite pButtonSprite,
					float pTouchAreaLocalX, float pTouchAreaLocalY) {
				// Show the OptionsLayer and play a click.
				SceneManager.getInstance().showOptionsLayer(false);
				OriginalOldResourceManager.clickSound.play();
			}});
		this.registerTouchArea(OptionsButton);
		
		// Create a title
		TitleText = new Text(0, 0, OriginalOldResourceManager.fontDefault72Bold, "HAPPY BIRDS", OriginalOldResourceManager.getInstance().engine.getVertexBufferObjectManager());
		TitleText.setPosition((OriginalOldResourceManager.getInstance().cameraWidth)/2, (OriginalOldResourceManager.getInstance().cameraHeight*2)/3f);
		TitleText.setColor(0.153f, 0.290f, 0.455f);
		this.attachChild(TitleText);

	}
	
	@Override
	public void onShowScene() {
	}
	@Override
	public void onHideScene() {
	}
	@Override
	public void onUnloadScene() {
	}
}