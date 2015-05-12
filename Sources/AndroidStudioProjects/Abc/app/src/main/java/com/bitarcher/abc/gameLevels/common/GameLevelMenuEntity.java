package com.bitarcher.abc.gameLevels.common;

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButtonListener;
import com.bitarcher.aeFun.interfaces.mvc.MvcImageTuple;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceInfoListGotter;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceRequirementsStackUser;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.aeFun.widgetToolkit.widget.NoLayoutDecorationImageButton;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;

import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 07/05/15.
 */
public class GameLevelMenuEntity extends Entity implements IResourceInfoListGotter, IResourceRequirementsStackUser {
    IResourceManager resourceManager;
    GameLevelCommonResourceInfos gameLevelCommonResourceInfos;
    ITheme theme;

    ArrayList<IGameLevelMenuEntityListener> gameLevelMenuEntityListeners = new ArrayList<>();
    Sprite background;
    NoLayoutDecorationImageButton home;
    NoLayoutDecorationImageButton listen;
    GameLevelBase gameLevelBase;


    public GameLevelMenuEntity(GameLevelBase gameLevelBase, ITheme theme, GameLevelCommonResourceInfos gameLevelCommonResourceInfos) {
        super(100 + 205f /2f, 108 / 2, 205f, 108);

        this.gameLevelBase = gameLevelBase;
        this.theme = theme;
        this.resourceManager = this.theme.getThemeManager().getResourceManager();
        this.gameLevelCommonResourceInfos = gameLevelCommonResourceInfos;
    }

    @Override
    public List<IResourceInfo> getResourceInfoList() {
        ArrayList<IResourceInfo> retval = new ArrayList<>();

        retval.add(this.gameLevelCommonResourceInfos.bitmapTexturesSetFromAssetResourceInfo);

        return retval;
    }

    @Override
    public void pushResourceRequirements() {
        this.resourceManager.pushRequirement(this);
    }

    @Override
    public void popResourceRequirements() {
        this.resourceManager.popRequirement(this);
    }

    @Override
    public void onAttached() {
        super.onAttached();

        this.pushResourceRequirements();
        this.addEntities();
    }

    @Override
    public void onDetached() {
        this.popResourceRequirements();

        super.onDetached();
    }

    public void addGameLevelMenuEntityListener(IGameLevelMenuEntityListener gameLevelMenuEntityListener)
    {
        this.gameLevelMenuEntityListeners.add(gameLevelMenuEntityListener);
    }

    public void removeGameLevelMenuEntityListener(IGameLevelMenuEntityListener gameLevelMenuEntityListener)
    {
        this.gameLevelMenuEntityListeners.remove(gameLevelMenuEntityListener);
    }


    void clearEntities()
    {
        if(this.background != null)
        {
            this.detachChild(this.background);
            this.background.dispose();
            this.background = null;
        }

        if(this.home != null)
        {
            this.detachChild(this.home);
            this.home.dispose();
            this.home = null;
        }

        if(this.listen != null)
        {
            this.detachChild(this.listen);
            this.listen.dispose();
            this.listen = null;
        }
    }

    void addEntities()
    {
        this.clearEntities();

        this.background = new Sprite(205f / 2f, 108 / 2, 205, 108,
                this.resourceManager.getTextureRegionFromTextureSetByName(
                        this.gameLevelCommonResourceInfos.bitmapTexturesSetFromAssetResourceInfo,
                        this.gameLevelCommonResourceInfos.getMenu_2places_199x108().getName()
                ), this.resourceManager.getEngine().getVertexBufferObjectManager());

        this.background.setAlpha(0.7f);
        this.attachChild(this.background);

        this.home = new NoLayoutDecorationImageButton(this.theme,
                100 / 2f, 100 / 2, 100, 100,
                new MvcImageTuple(this.gameLevelCommonResourceInfos.bitmapTexturesSetFromAssetResourceInfo,
                    this.gameLevelCommonResourceInfos.getHome_190x190().getName(),
                        1));

        this.home.setHud(this.gameLevelBase.gameHud);
        this.attachChild(this.home);

        final GameLevelMenuEntity gameLevelMenuEntity = this;

        this.home.addButtonListener(new IButtonListener() {
            @Override
            public void onClicked(IButton button) {
                for (IGameLevelMenuEntityListener gameLevelMenuEntityListener : gameLevelMenuEntityListeners) {
                    gameLevelMenuEntityListener.onGoBackToMenuClicked(gameLevelMenuEntity);
                }
            }
        });

        this.listen = new NoLayoutDecorationImageButton(this.theme,
                this.home.getX() + 100, 100 / 2, 100, 100,
                new MvcImageTuple(this.gameLevelCommonResourceInfos.bitmapTexturesSetFromAssetResourceInfo,
                        this.gameLevelCommonResourceInfos.getListen_256x256().getName(), 1));

        this.listen.addButtonListener(new IButtonListener() {
            @Override
            public void onClicked(IButton button) {
                for(IGameLevelMenuEntityListener gameLevelMenuEntityListener : gameLevelMenuEntityListeners)
                {
                    gameLevelMenuEntityListener.onRepeatInstructionClicked(gameLevelMenuEntity);
                }
            }
        });

        this.listen.setHud(this.gameLevelBase.gameHud);

        this.attachChild(this.listen);
    }
}

