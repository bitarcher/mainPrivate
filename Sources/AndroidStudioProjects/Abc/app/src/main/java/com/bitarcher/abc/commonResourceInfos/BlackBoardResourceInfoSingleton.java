package com.bitarcher.abc.commonResourceInfos;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SingleBitmapTextureSetFromAssetResourceInfo;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;

/**
 * Created by michel on 15/05/15.
 */
public class BlackBoardResourceInfoSingleton {

    private static BlackBoardResourceInfoSingleton ourInstance = new BlackBoardResourceInfoSingleton();

    public static BlackBoardResourceInfoSingleton getInstance() {
        return ourInstance;
    }

    SingleBitmapTextureSetFromAssetResourceInfo twoLinesBlackboard;

    public SingleBitmapTextureSetFromAssetResourceInfo getTwoLinesBlackboard() {

        if(this.twoLinesBlackboard == null) {
            this.twoLinesBlackboard = new SingleBitmapTextureSetFromAssetResourceInfo("blackBoard.png", 512, 512,
                    BitmapTextureFormat.RGBA_4444, TextureOptions.DEFAULT, "gfx/vowels256h/", 1.0f);
        }
        return twoLinesBlackboard;
    }


    private BlackBoardResourceInfoSingleton() {
    }
}

