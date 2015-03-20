package com.bitarcher.abc;


import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.andEngine.IScene;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.EnumFontSize;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.IButton;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.IButtonListener;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.sceneManagement.IMainMenu;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.ResourcesInfos.BitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.ResourcesInfos.MusicResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.ResourcesInfos.SubInfos.OneAssetBitmapTexture;

import com.bitarcher.aeFunExamplesShowRoom.sceneManagement.ManagedMenuScene;
import com.bitarcher.aeFunExamplesShowRoom.widgetToolkit.widget.TextButton;

import org.andengine.audio.music.Music;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;
import org.andengine.opengl.texture.region.ITextureRegion;

public class MainMenu extends ManagedMenuScene implements IMainMenu{

    BitmapTexturesSetFromAssetResourceInfo bitmapTexturesSetFromAssetResourceInfo;
    MusicResourceInfo musicResourceInfo;


	public MainMenu(ITSceneManager sceneManager) {
        super(sceneManager);
		this.setOnSceneTouchListenerBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionMoveEnabled(true);


        this.bitmapTexturesSetFromAssetResourceInfo = new BitmapTexturesSetFromAssetResourceInfo("mainMenu3", 1024, 512, BitmapTextureFormat.RGBA_4444, null, "gfx/MainMenu/");

        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture((new OneAssetBitmapTexture("prairie", "prairie.gif")));
        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture((new OneAssetBitmapTexture("cloud", "cloud.png")));


        this.musicResourceInfo = new MusicResourceInfo("tryad_listen", "audio/tryad_listen.ogg");
	}

    void pushRequirements()
    {
        this.getSceneManager().getResourceManager().pushRequirement(this.bitmapTexturesSetFromAssetResourceInfo);
        this.getSceneManager().getResourceManager().pushRequirement(this.musicResourceInfo);
    }

    void popRequirements()
    {
        this.getSceneManager().getResourceManager().popRequirement(this.bitmapTexturesSetFromAssetResourceInfo);
        this.getSceneManager().getResourceManager().popRequirement(this.musicResourceInfo);
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


    TextButton playButton;
    TextButton optionsButton;


    //private Sprite[] cloudSprites;
    private CloudSprite[] cloudSprites;
	private Text titleText;



	@Override
    public void onLoadScene() {

        this.pushRequirements();

        this.getSceneManager().getResourceManager().getMusic(this.musicResourceInfo).setLooping(true);

        ITextureRegion cloudTextureRegion = this.getSceneManager().getResourceManager().getTextureRegionFromTextureSetByName(this.bitmapTexturesSetFromAssetResourceInfo, "cloud");

        ITextureRegion backgroundTextureRegion = this.getSceneManager().getResourceManager().getTextureRegionFromTextureSetByName(this.bitmapTexturesSetFromAssetResourceInfo, "prairie");

        backgroundSprite = new Sprite(
                this.getSceneManager().getResourceManager().getCameraWidth() / 2,
                this.getSceneManager().getResourceManager().getCameraHeight() / 2,
                this.getSceneManager().getResourceManager().getCameraWidth(),
                this.getSceneManager().getResourceManager().getCameraHeight(),
                backgroundTextureRegion, this.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());
		backgroundSprite.setZIndex(-5000);
		this.attachChild(backgroundSprite);
		
		// Create clouds that move from one side of the screen to the other, and repeat.
		cloudSprites = new CloudSprite[35];
        final MainMenu mainMenu = this;

		for(Sprite curCloudSprite: cloudSprites){
			curCloudSprite = new CloudSprite(this, cloudTextureRegion);

			this.attachChild(curCloudSprite);
		}

		// Create a Play button. Notice that the Game scenes, unlike menus, are not referred to in a static way.

        int buttonWidth = 300;
        int buttonHeight = 60;

        this.playButton = new TextButton(this.getSceneManager().getTheme(),
                (this.getSceneManager().getResourceManager().getCameraWidth()- buttonWidth)/2f,
                (this.getSceneManager().getResourceManager().getCameraWidth()- buttonWidth)*(1f/3f), buttonWidth, buttonHeight, "Jouer");

        this.attachChild(playButton);

        int buttonPadding = 5;

        this.playButton.addButtonListener(new IButtonListener() {
            @Override
            public void onClicked(IButton button) {
                getSceneManager().showScene(new GameLevel(getSceneManager()));
            }
        });

        this.playButton.setPadding(buttonPadding);

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
        this.optionsButton.setPadding(buttonPadding);

        // Create a title
		titleText = new Text(0, 0, this.getSceneManager().getTheme().getFontThemeSection().getFont(EnumFontSize.Big), "ABC ", this.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());
		titleText.setPosition((this.getSceneManager().getResourceManager().getCameraWidth()) / 2, (this.getSceneManager().getResourceManager().getCameraHeight() * 2) / 3f);
		titleText.setColor(0.153f, 0.290f, 0.455f);
		this.attachChild(titleText);


    }


	
	@Override
	public void onShowScene() {
        Music music =this.getSceneManager().getResourceManager().getMusic(this.musicResourceInfo);

        music.play();
	}

	@Override
	public void onHideScene() {

        Music music =this.getSceneManager().getResourceManager().getMusic(this.musicResourceInfo);
        music.pause();
        music.seekTo(0);
	}


    @Override
    public void onUnloadScene() {
        this.mChildren.clear();
        this.popRequirements();
    }
}
