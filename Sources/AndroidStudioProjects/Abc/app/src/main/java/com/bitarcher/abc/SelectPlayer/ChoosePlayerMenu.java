package com.bitarcher.abc.SelectPlayer;


import com.bitarcher.abc.AbcManagedMenuScene;
import com.bitarcher.abc.GameLevel;
import com.bitarcher.abc.MainMenu;
import com.bitarcher.aeFun.drawables.animatedMeshed.nature.clouds.CloudSprite;
import com.bitarcher.aeFun.interfaces.gui.andEngine.IScene;
import com.bitarcher.aeFun.interfaces.gui.theme.EnumFontSize;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButtonListener;
import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.MusicResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneAssetBitmapTexture;
import com.bitarcher.aeFun.sceneManagement.ManagedMenuScene;
import com.bitarcher.aeFun.widgetToolkit.widget.Table;
import com.bitarcher.aeFun.widgetToolkit.widget.TextButton;
import com.bitarcher.speaker.AlternativeSpeeches;

import org.andengine.audio.music.Music;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;
import org.andengine.opengl.texture.region.ITextureRegion;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

public class ChoosePlayerMenu extends AbcManagedMenuScene {

    Table table;
    TextButton newPlayerTextButton;
    BitmapTexturesSetFromAssetResourceInfo bitmapTexturesSetFromAssetResourceInfo;
    MusicResourceInfo musicResourceInfo;



	public ChoosePlayerMenu(ITSceneManager sceneManager) {
        super(sceneManager);
		this.setOnSceneTouchListenerBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionMoveEnabled(true);


        this.bitmapTexturesSetFromAssetResourceInfo = new BitmapTexturesSetFromAssetResourceInfo("mainMenu3", 1024, 512, BitmapTextureFormat.RGBA_4444, null, "gfx/MainMenu/");

        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture((new OneAssetBitmapTexture("prairie", "prairie.gif")));
        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture((new OneAssetBitmapTexture("cloud", "cloud.png")));


        this.musicResourceInfo = new MusicResourceInfo("tryad_listen_2", "audio/tryad_listen_2.ogg");
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
        final ChoosePlayerMenu mainMenu = this;

		for(Sprite curCloudSprite: cloudSprites){
			curCloudSprite = new CloudSprite(this, this.getSceneManager().getResourceManager(), cloudTextureRegion);

			this.attachChild(curCloudSprite);
		}

        float w = 800;
        float h = 400;

        this.table = new Table(this.getSceneManager().getTheme(), w/2, 200, w, 400);
        this.table.addHomogeneousColumnsAndRows(2, 2, 10);
        this.table.setPadding(20);
        this.attachChild(this.table);

        this.newPlayerTextButton = new TextButton(this.getSceneManager().getTheme(), 0, 0, 10, 10, "Nouveau joueur");
        this.table.attachChild(this.newPlayerTextButton, 1, 1);


        // Create a title
        titleText = new Text(0, 0, this.getSceneManager().getTheme().getFontThemeSection().getFont(EnumFontSize.Big), "Choisis le joueur", this.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        titleText.setPosition((this.getSceneManager().getResourceManager().getCameraWidth()) / 2, 400);
        titleText.setColor(0.153f, 0.290f, 0.455f);
        this.attachChild(titleText);

        AlternativeSpeeches alternativeSpeeches = new AlternativeSpeeches();
        alternativeSpeeches.addAlternativeSpeech("Choisis ton joueur ou appuie sur le bouton en bas à droite pour en créer un nouveau");
        alternativeSpeeches.addAlternativeSpeech("Appuie sur ton animal préféré ou bien appuie sur le bouton en bas à droite s'il n'est pas là");
        this.getMainMenu().getSpeaker().say(alternativeSpeeches);

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
