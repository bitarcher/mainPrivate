/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues;

import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues.SubValues.OneResBitmapTextureSV;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.IBitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResBitmapTexture;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.ResourceManager;

/**
 * Created by michel on 26/01/15.
 */
public class BitmapTextureSetFromResMapValue extends TextureSetFromResMapValue<IBitmapTexturesSetFromResIdsResourceInfo,
        IOneResBitmapTexture,
        OneResBitmapTextureSV
        > {

    public BitmapTextureSetFromResMapValue(ResourceManager resourceManager, IBitmapTexturesSetFromResIdsResourceInfo texturesSetResourceInfo) {
        super(resourceManager, texturesSetResourceInfo);
    }

    @Override
    protected OneResBitmapTextureSV createOneTexture(IResourceManager resourceManager, IOneResBitmapTexture iOneBitmapTexture) {
        return new OneResBitmapTextureSV(resourceManager, this, iOneBitmapTexture);
    }
}
