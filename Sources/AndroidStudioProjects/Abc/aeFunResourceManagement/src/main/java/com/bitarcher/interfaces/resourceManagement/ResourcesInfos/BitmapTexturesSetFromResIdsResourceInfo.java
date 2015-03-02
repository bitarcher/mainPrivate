/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.resourceManagement.ResourcesInfos;

import android.content.Context;

import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.IBitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResBitmapTexture;

/**
 * Created by michel on 26/01/15.
 */
public class BitmapTexturesSetFromResIdsResourceInfo extends TexturesSetFromResIdsResourceInfo<IOneResBitmapTexture> implements IBitmapTexturesSetFromResIdsResourceInfo {
    public BitmapTexturesSetFromResIdsResourceInfo(String name, Context context, int atlasWidth, int atlasHeight) {
        super(name, context, atlasWidth, atlasHeight);
    }
}
