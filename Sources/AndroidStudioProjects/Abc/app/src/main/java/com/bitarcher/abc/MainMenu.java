package com.bitarcher.abc;


import com.bitarcher.abc.gameLevels.common.GameLevelCommonResourceInfos;
import com.bitarcher.abc.selectPlayer.ChoosePlayerMenu;
import com.bitarcher.abc.animals.AnimalResourceInfos;
import com.bitarcher.abcbllorm.BLL.Player;
import com.bitarcher.abcbllorm.DAL.DatabaseHelper;
import com.bitarcher.aeFun.drawables.animatedMeshed.nature.clouds.CloudSprite;
import com.bitarcher.aeFun.interfaces.gui.andEngine.IScene;
import com.bitarcher.aeFun.interfaces.gui.theme.EnumFontSize;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButtonListener;
import com.bitarcher.aeFun.interfaces.sceneManagement.IMainMenu;
import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.MusicResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneAssetBitmapTexture;

import com.bitarcher.aeFun.sceneManagement.ManagedMenuScene;
import com.bitarcher.aeFun.widgetToolkit.widget.TextButton;
import com.bitarcher.interfaces.speaker.ISpeaker;
import com.bitarcher.speaker.AlternativeSpeeches;
import com.bitarcher.speaker.Speaker;
import com.j256.ormlite.dao.Dao;

import org.andengine.audio.music.Music;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;
import org.andengine.opengl.texture.region.ITextureRegion;

import java.sql.SQLException;
import java.util.Locale;

public class MainMenu extends ManagedMenuScene implements IMainMenu{

    MainActivity mainActivity;
    ISpeaker speaker;
    BitmapTexturesSetFromAssetResourceInfo bitmapTexturesSetFromAssetResourceInfo;
    MusicResourceInfo musicResourceInfo;
    AnimalResourceInfos animalResourceInfos;
    GameLevelCommonResourceInfos gameLevelCommonResourceInfos;
    Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public AnimalResourceInfos getAnimalResourceInfos() {
        return animalResourceInfos;
    }

    public GameLevelCommonResourceInfos getGameLevelCommonResourceInfos() {
        return gameLevelCommonResourceInfos;
    }

    public MainMenu(MainActivity mainActivity, ITSceneManager sceneManager) {
        super(sceneManager);


        this.gameLevelCommonResourceInfos = new GameLevelCommonResourceInfos();

        this.mainActivity = mainActivity;

		this.setOnSceneTouchListenerBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionMoveEnabled(true);


        this.bitmapTexturesSetFromAssetResourceInfo = new BitmapTexturesSetFromAssetResourceInfo("mainMenu3", 1024, 512, BitmapTextureFormat.RGBA_4444, null, "gfx/MainMenu/");

        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture((new OneAssetBitmapTexture("prairie", "prairie.gif")));
        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture((new OneAssetBitmapTexture("cloud", "cloud.png")));


        this.musicResourceInfo = new MusicResourceInfo("tryad_listen", "audio/tryad_listen.ogg");

        AlternativeSpeeches alternativeSpeeches = new AlternativeSpeeches();
        alternativeSpeeches.addAlternativeSpeech("Salut mon ami !");

        try {
            Dao<Player, Integer> dao = this.getDatabaseHelper().getDao(Player.class);

            int num = (int)dao.countOf();

            if(num > 0)
            {
                alternativeSpeeches.addAlternativeSpeech("Tu es de retour, tu m'as manqué !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        alternativeSpeeches.addAlternativeSpeech("Salut, on va jouer ?");
        this.speaker = new Speaker(sceneManager.getResourceManager().getContext(), Locale.FRENCH, alternativeSpeeches);

        this.animalResourceInfos = new AnimalResourceInfos(this);
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
			curCloudSprite = new CloudSprite(this, this.getSceneManager().getResourceManager(), cloudTextureRegion);

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
                getSceneManager().showScene(new ChoosePlayerMenu(getSceneManager()));
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

    public ISpeaker getSpeaker()
    {
        return  this.speaker;
    }


    public DatabaseHelper getDatabaseHelper()
    {
        return this.mainActivity.getDatabaseHelper();
    }
}
