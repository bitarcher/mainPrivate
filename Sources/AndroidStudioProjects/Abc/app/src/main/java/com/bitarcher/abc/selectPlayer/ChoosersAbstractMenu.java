package com.bitarcher.abc.selectPlayer;


import com.bitarcher.abc.AbcManagedMenuScene;
import com.bitarcher.abc.animals.EnumAnimal;
import com.bitarcher.aeFun.drawables.animatedMeshed.nature.clouds.CloudSprite;
import com.bitarcher.aeFun.interfaces.gui.andEngine.IScene;
import com.bitarcher.aeFun.interfaces.gui.theme.EnumFontSize;
import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceInfoListGotter;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.MusicResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneAssetBitmapTexture;
import com.bitarcher.aeFun.widgetToolkit.widget.ImageButton;
import com.bitarcher.aeFun.widgetToolkit.widget.Table;
import com.bitarcher.speaker.AlternativeSpeeches;

import org.andengine.audio.music.Music;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;
import org.andengine.opengl.texture.region.ITextureRegion;

import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

public abstract class ChoosersAbstractMenu extends AbcManagedMenuScene implements IResourceInfoListGotter {

    protected Table table;
    protected ImageButton[] imageButtons;
    protected BitmapTexturesSetFromAssetResourceInfo bitmapTexturesSetFromAssetResourceInfo;
    protected MusicResourceInfo musicResourceInfo;




	public ChoosersAbstractMenu(ITSceneManager sceneManager) {
        super(sceneManager);
		this.setOnSceneTouchListenerBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionMoveEnabled(true);


        this.imageButtons = new ImageButton[4];
        this.bitmapTexturesSetFromAssetResourceInfo = new BitmapTexturesSetFromAssetResourceInfo("mainMenu3", 1024, 512, BitmapTextureFormat.RGBA_4444, null, "gfx/MainMenu/");

        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture((new OneAssetBitmapTexture("prairie", "prairie.gif")));
        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture((new OneAssetBitmapTexture("cloud", "cloud.png")));


        this.musicResourceInfo = new MusicResourceInfo("tryad_listen_2", "audio/tryad_listen_2.ogg");
	}

    @Override
    public List<IResourceInfo> getResourceInfoList() {
        ArrayList<IResourceInfo> retval = new ArrayList<>();

        retval.add(this.bitmapTexturesSetFromAssetResourceInfo);

        retval.add(this.musicResourceInfo);

        for(EnumAnimal animal : this.getProposedAnimals()) {
            retval.add(this.getMainMenu().getAnimalResourceInfos().make(animal).getTextureSetResourceInfo());
        }

        return retval;
    }

    protected EnumAnimal[] getProposedAnimals()
    {
        EnumAnimal[] retval = new EnumAnimal[]
                {
                    EnumAnimal.chien,
                    EnumAnimal.lapin,
                    EnumAnimal.tigre,
                    EnumAnimal.koala
                };

        return retval;
    }

    void pushRequirements()
    {
        this.getSceneManager().getResourceManager().pushRequirement(this);
    }

    void popRequirements()
    {
        this.getSceneManager().getResourceManager().popRequirement(this);
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

        ITheme theme = this.getSceneManager().getTheme();
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
        final ChoosersAbstractMenu mainMenu = this;

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






        // Create a title
        titleText = new Text(0, 0, this.getSceneManager().getTheme().getFontThemeSection().getFont(EnumFontSize.Big), this.getTranslatedTitle(), this.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        titleText.setPosition((this.getSceneManager().getResourceManager().getCameraWidth()) / 2, 400);
        titleText.setColor(0.153f, 0.290f, 0.455f);
        this.attachChild(titleText);

        AlternativeSpeeches alternativeSpeeches = new AlternativeSpeeches();
        alternativeSpeeches.addAlternativeSpeech("Choisis ton animal préféré");
        alternativeSpeeches.addAlternativeSpeech("Choisis l'animal qui doit te représenter");
        this.getMainMenu().getSpeaker().say(alternativeSpeeches);
    }

    protected abstract String getTranslatedTitle();
	
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
