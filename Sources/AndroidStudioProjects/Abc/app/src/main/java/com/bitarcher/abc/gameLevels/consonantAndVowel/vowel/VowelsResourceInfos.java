package com.bitarcher.abc.gameLevels.consonantAndVowel.vowel;

import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneAssetBitmapTexture;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 06/05/15.
 */
public class VowelsResourceInfos {
    OneAssetBitmapTexture[] vowels = new OneAssetBitmapTexture[6];

    BitmapTexturesSetFromAssetResourceInfo bitmapTexturesSetFromAssetResourceInfo;

    public OneAssetBitmapTexture getVowel(EnumVowel enumVowel) {
        return this.vowels[enumVowel.ordinal()];
    }


    public BitmapTexturesSetFromAssetResourceInfo getBitmapTexturesSetFromAssetResourceInfo() {
        return bitmapTexturesSetFromAssetResourceInfo;
    }

    protected VowelsResourceInfos() {
        this.bitmapTexturesSetFromAssetResourceInfo = new BitmapTexturesSetFromAssetResourceInfo("GameLevelCommon",
                1024, 1024, BitmapTextureFormat.RGBA_4444, TextureOptions.DEFAULT, "gfx/vowels256h/");

        for(EnumVowel enumVowel : EnumVowel.values())
        {
            this.vowels[enumVowel.ordinal()] = new OneAssetBitmapTexture(enumVowel.name(), enumVowel.name() + ".png");
            this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture(this.vowels[enumVowel.ordinal()]);
        }
    }
}
