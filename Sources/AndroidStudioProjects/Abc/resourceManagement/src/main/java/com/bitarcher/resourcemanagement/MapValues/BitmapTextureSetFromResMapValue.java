/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.MapValues;

import com.bitarcher.interfacesProtected.resourcemanagement.IResourceManager;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IBitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.SubInfos.IOneResBitmapTexture;
import com.bitarcher.resourcemanagement.MapValues.SubValues.OneResBitmapTextureSV;
import com.bitarcher.resourcemanagement.ResourceManager;

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
