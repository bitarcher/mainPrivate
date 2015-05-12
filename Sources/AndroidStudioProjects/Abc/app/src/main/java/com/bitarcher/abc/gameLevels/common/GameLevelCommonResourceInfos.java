package com.bitarcher.abc.gameLevels.common;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneAssetBitmapTexture;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;

/**
 * Created by michel on 06/05/15.
 */
public class GameLevelCommonResourceInfos {
    OneAssetBitmapTexture diamond_3places_106x203;
    OneAssetBitmapTexture diamond_300x179;
    OneAssetBitmapTexture home_190x190;
    OneAssetBitmapTexture listen_256x256;
    OneAssetBitmapTexture menu_2places_199x108;

    BitmapTexturesSetFromAssetResourceInfo bitmapTexturesSetFromAssetResourceInfo;

    public OneAssetBitmapTexture getDiamond_3places_106x203() {
        return diamond_3places_106x203;
    }

    public OneAssetBitmapTexture getDiamond_300x179() {
        return diamond_300x179;
    }

    public OneAssetBitmapTexture getHome_190x190() {
        return home_190x190;
    }

    public OneAssetBitmapTexture getListen_256x256() {
        return listen_256x256;
    }

    public OneAssetBitmapTexture getMenu_2places_199x108() {
        return menu_2places_199x108;
    }

    public BitmapTexturesSetFromAssetResourceInfo getBitmapTexturesSetFromAssetResourceInfo() {
        return bitmapTexturesSetFromAssetResourceInfo;
    }

    public GameLevelCommonResourceInfos() {
        this.bitmapTexturesSetFromAssetResourceInfo = new BitmapTexturesSetFromAssetResourceInfo("GameLevelCommon",
                1024, 512, BitmapTextureFormat.RGBA_4444, TextureOptions.DEFAULT, "gfx/GameLevelCommon/");

        // TODO improve it should use 512 x 512 texture atlas
        this.diamond_3places_106x203 = new OneAssetBitmapTexture("diamond_3places_106x203", "diamond_3places_106x203.png");
        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture(this.diamond_3places_106x203);

        this.diamond_300x179 = new OneAssetBitmapTexture("diamond_300x179", "diamond_300x179.png");
        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture(this.diamond_300x179);

        this.home_190x190 = new OneAssetBitmapTexture("home_190x190", "home_190x190.png");
        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture(this.home_190x190);

        this.listen_256x256 = new OneAssetBitmapTexture("listen_256x256", "listen_256x256.png");
        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture(this.listen_256x256);

        this.menu_2places_199x108 = new OneAssetBitmapTexture("menu_2places_199x108", "menu_2places_199x108.png");
        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture(this.menu_2places_199x108);
    }
}
