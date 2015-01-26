/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.IBitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResBitmapTexture;

/**
 * Created by michel on 26/01/15.
 */
public class BitmapTexturesSetFromResIdsResourceInfo extends TexturesSetFromResIdsResourceInfo<IOneResBitmapTexture> implements IBitmapTexturesSetFromResIdsResourceInfo {
    public BitmapTexturesSetFromResIdsResourceInfo(String name, int atlasWidth, int atlasHeight) {
        super(name, atlasWidth, atlasHeight);
    }
}
