package com.bitarcher.abc.gameLevels.common;

import com.bitarcher.abc.GameLevel;
import com.bitarcher.abc.MainMenu;
import com.bitarcher.aeFun.interfaces.sceneManagement.IGoBackSceneCapable;
import com.bitarcher.aeFun.sceneManagement.ManagedGameScene;

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
        this.gameLevelMenuEntity = new GameLevelMenuEntity(this, mainMenu.getSceneManager().getTheme(), mainMenu.getGameLevelCommonResourceInfos());

        final GameLevelBase gameLevelBase = this;

        this.gameLevelMenuEntity.addGameLevelMenuEntityListener(new IGameLevelMenuEntityListener() {
            @Override
            public void onGoBackToMenuClicked(GameLevelMenuEntity gameLevelMenuEntity) {
                if(gameLevelBase instanceof IGoBackSceneCapable)
                {
                    IGoBackSceneCapable goBackSceneCapable = (IGoBackSceneCapable)gameLevelBase;

                    goBackSceneCapable.goBackToPreviousScene();
                }
                else
                {
                    gameLevelBase.getSceneManager().showMainMenu();
                }
            }

            @Override
            public void onRepeatInstructionClicked(GameLevelMenuEntity gameLevelMenuEntity) {
                // TODO
            }
        });
    }

    @Override
    public void onLoadManagedScene() {
        super.onLoadManagedScene();

        this.gameHud.attachChild(this.diamondZoneEntity);
        this.gameHud.attachChild(this.gameLevelMenuEntity);
    }

    @Override
    public void onUnloadManagedScene() {
        super.onUnloadManagedScene();

        this.gameHud.detachChild(this.diamondZoneEntity);
        this.gameHud.detachChild(this.gameLevelMenuEntity);
    }

}

