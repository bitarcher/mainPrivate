/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.resourceManagement.MapValues;

import com.bitarcher.interfaces.resourceManagement.MapValues.SubValues.OneResBitmapTextureSV;
import com.bitarcher.interfaces.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.IBitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResBitmapTexture;
import com.bitarcher.interfaces.resourceManagement.ResourceManager;

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
