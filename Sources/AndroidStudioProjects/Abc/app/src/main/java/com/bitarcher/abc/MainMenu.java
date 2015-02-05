package com.bitarcher.abc;


import com.bitarcher.interfaces.gui.andEngine.IScene;
import com.bitarcher.interfaces.gui.theme.EnumFontSize;
import com.bitarcher.interfaces.gui.widgets.IButton;
import com.bitarcher.interfaces.gui.widgets.IButtonListener;
import com.bitarcher.interfaces.sceneManagement.IMainMenu;
import com.bitarcher.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.resourcemanagement.ResourcesInfos.SubInfos.OneResSvgTexture;
import com.bitarcher.resourcemanagement.ResourcesInfos.SvgTexturesSetFromResIdsResourceInfo;
import com.bitarcher.scenemanagement.ManagedMenuScene;
import com.bitarcher.widgettoolkit.widget.TextButton;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.math.MathUtils;

public class MainMenu extends ManagedMenuScene implements IMainMenu{

    SvgTexturesSetFromResIdsResourceInfo texturesSetResourceInfo;


	public MainMenu(ITSceneManager sceneManager) {
        super(sceneManager);
		this.setOnSceneTouchListenerBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionMoveEnabled(true);

        this.texturesSetResourceInfo = new SvgTexturesSetFromResIdsResourceInfo("mainMenu", sceneManager.getResourceManager().getContext(), 1024, 512);

        this.texturesSetResourceInfo.addOneTexture(new OneResSvgTexture("sunset", R.raw.sunset, 780, 480));
        this.texturesSetResourceInfo.addOneTexture(new OneResSvgTexture("cloud", R.raw.cloud, 150, 150));

        this.getSceneManager().getResourceManager().pushRequirement(this.texturesSetResourceInfo);
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
	private Sprite backgroundSprite;

    /*
	private ButtonSprite playButton;
	private Text playButtonText;
	private ButtonSprite optionsButton;
	private Text optionsButtonText;
    */

    TextButton playButton;
    TextButton optionsButton;

	private Sprite[] cloudSprites;
	private Text titleText;



	@Override
    public void onLoadScene() {
		// Load the menu resources
		//this.resourceManager.loadMenuResources();
		
		// Create the background


        ITextureRegion cloudTextureRegion = this.getSceneManager().getResourceManager().getTextureRegionFromTextureSetByName(this.texturesSetResourceInfo, "cloud");
        ITextureRegion backgroundTextureRegion = this.getSceneManager().getResourceManager().getTextureRegionFromTextureSetByName(this.texturesSetResourceInfo, "sunset");

        backgroundSprite = new Sprite(this.getSceneManager().getResourceManager().getCameraWidth()/2f, this.getSceneManager().getResourceManager().getCameraHeight()/2f, backgroundTextureRegion, this.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());
		backgroundSprite.setScaleX(this.getSceneManager().getResourceManager().getCameraScaleX());
		backgroundSprite.setScaleY(this.getSceneManager().getResourceManager().getCameraHeight() / 480f);
		backgroundSprite.setZIndex(-5000);
		this.attachChild(backgroundSprite);

		
		// Create clouds that move from one side of the screen to the other, and repeat.
		cloudSprites = new Sprite[20];
        final MainMenu mainMenu = this;

		for(Sprite curCloudSprite: cloudSprites){
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

        int buttonWidth = 400;
        int buttonHeight = 60;
/*
		playButton = new ButtonSprite(
				(this.getSceneManager().getResourceManager().getCameraWidth()- OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(0).getWidth())/2f,
				(OriginalOldResourceManager.getInstance().cameraHeight- OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(0).getHeight())*(1f/3f),
				OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(0),
				OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(1),
				OriginalOldResourceManager.getInstance().engine.getVertexBufferObjectManager());
		playButtonText = new Text(0, 0, OriginalOldResourceManager.fontDefault32Bold, "PLAY", OriginalOldResourceManager.getInstance().engine.getVertexBufferObjectManager());
		playButtonText.setPosition((playButton.getWidth()) / 2, (playButton.getHeight()) / 2);
		playButton.attachChild(playButtonText);
		this.attachChild(playButton);
		playButton.setOnClickListener(new ButtonSprite.OnClickListener() {
            @Override
            public void onClick(ButtonSprite pButtonSprite,
                                float pTouchAreaLocalX, float pTouchAreaLocalY) {
                // Create a new GameLevel and show it using the SceneManager. And play a click.
                SceneManager.getInstance().showScene(new GameLevel(getSceneManager()));
                OriginalOldResourceManager.clickSound.play();
            }
        });
		this.registerTouchArea(playButton);
  */
        this.playButton = new TextButton(this.getSceneManager().getTheme(),
                (this.getSceneManager().getResourceManager().getCameraWidth()- buttonWidth)/2f,
                (this.getSceneManager().getResourceManager().getCameraWidth()- buttonWidth)*(1f/3f), buttonWidth, buttonHeight, "Jouer");

        this.attachChild(playButton);
        this.playButton.addButtonListener(new IButtonListener() {
            @Override
            public void onClicked(IButton button) {
                getSceneManager().showScene(new GameLevel(getSceneManager()));
            }
        });
        //this.registerTouchArea(playButton);


        /*
		// Create an Option button. Notice that the SceneManager is being told to not pause the scene while the OptionsLayer is open.
		optionsButton = new ButtonSprite(
				playButton.getX()+ playButton.getWidth(),
				playButton.getY(),
				OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(0),
				OriginalOldResourceManager.buttonTiledTextureRegion.getTextureRegion(1),
				OriginalOldResourceManager.getInstance().engine.getVertexBufferObjectManager());
		optionsButtonText = new Text(0,0, OriginalOldResourceManager.fontDefault32Bold,"OPTIONS", OriginalOldResourceManager.getInstance().engine.getVertexBufferObjectManager());
		optionsButtonText.setPosition((optionsButton.getWidth()) / 2, (optionsButton.getHeight()) / 2);
		optionsButton.attachChild(optionsButtonText);
		this.attachChild(optionsButton);
		optionsButton.setOnClickListener(new ButtonSprite.OnClickListener() {
            @Override
            public void onClick(ButtonSprite pButtonSprite,
                                float pTouchAreaLocalX, float pTouchAreaLocalY) {
                // Show the OptionsLayer and play a click.
                SceneManager.getInstance().showOptionsLayer(false);
                OriginalOldResourceManager.clickSound.play();
            }
        });
		this.registerTouchArea(optionsButton);
		*/

        this.optionsButton = new TextButton(this.getSceneManager().getTheme(),
                playButton.getX()+ playButton.getWidth(),
                playButton.getY(), buttonWidth, buttonHeight, "Options");

        this.attachChild(optionsButton);
        this.optionsButton.addButtonListener(new IButtonListener() {
            @Override
            public void onClicked(IButton button) {
                getSceneManager().showOptionsLayer(false);
            }
        });
        //this.registerTouchArea(optionsButton);


        // Create a title
		titleText = new Text(0, 0, this.getSceneManager().getTheme().getFontThemeSection().getFont(EnumFontSize.Big), "ABC ", this.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());
		titleText.setPosition((this.getSceneManager().getResourceManager().getCameraWidth()) / 2, (this.getSceneManager().getResourceManager().getCameraHeight() * 2) / 3f);
		titleText.setColor(0.153f, 0.290f, 0.455f);
		this.attachChild(titleText);

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