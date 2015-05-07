package com.bitarcher.abc.gameLevels.common;

import com.bitarcher.abc.MainMenu;
import com.bitarcher.abc.R;
import com.bitarcher.aeFun.interfaces.gui.andEngine.IScene;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButtonListener;
import com.bitarcher.aeFun.interfaces.mvc.IImage;
import com.bitarcher.aeFun.interfaces.mvc.MvcImageTuple;
import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneAssetBitmapTexture;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneResBitmapTexture;
import com.bitarcher.aeFun.sceneManagement.ManagedGameScene;
import com.bitarcher.aeFun.widgetToolkit.widget.ImageButton;
import com.bitarcher.aeFun.widgetToolkit.widget.Table;
import com.bitarcher.aeFun.widgetToolkit.widget.TextButton;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.Containers.PercentSpaceUsage;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

public class GameLevelBase extends ManagedGameScene {
    MainMenu mainMenu;
    DiamondZoneEntity diamondZoneEntity;
    GameLevelMenuEntity gameLevelMenuEntity;

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public DiamondZoneEntity getDiamondZoneEntity() {
        return diamondZoneEntity;
    }

    public GameLevelMenuEntity getGameLevelMenuEntity() {
        return gameLevelMenuEntity;
    }

    public GameLevelBase(MainMenu mainMenu, float loadingScreenMinimumSecondsShown)
    {
        super(mainMenu.getSceneManager(), loadingScreenMinimumSecondsShown);

        this.mainMenu = mainMenu;
        this.diamondZoneEntity = new DiamondZoneEntity(mainMenu.getSceneManager().getResourceManager(), mainMenu.getGameLevelCommonResourceInfos());
        this.gameLevelMenuEntity = new GameLevelMenuEntity(mainMenu.getSceneManager().getTheme(), mainMenu.getGameLevelCommonResourceInfos());
    }


    @Override
    public IScene onLoadingScreenLoadAndShown() {

        if(this.getHasLoadingScreen()) {
            this.attachChild(this.diamondZoneEntity);
            this.attachChild(this.gameLevelMenuEntity);

        }
        return super.onLoadingScreenLoadAndShown();
    }

    @Override
    public void onLoadingScreenUnloadAndHidden() {
        if(this.getHasLoadingScreen()) {
            this.detachChild(this.diamondZoneEntity);
            this.detachChild(this.gameLevelMenuEntity);
        }

        super.onLoadingScreenUnloadAndHidden();
    }

    @Override
    public void onLoadScene() {
        super.onLoadScene();

        if(!this.getHasLoadingScreen()) {
            this.attachChild(this.diamondZoneEntity);
            this.attachChild(this.gameLevelMenuEntity);
        }
    }

    @Override
    public void onUnloadScene() {
        super.onUnloadScene();

        if(!this.getHasLoadingScreen()) {
            this.detachChild(this.diamondZoneEntity);
            this.detachChild(this.gameLevelMenuEntity);
        }
    }
}

