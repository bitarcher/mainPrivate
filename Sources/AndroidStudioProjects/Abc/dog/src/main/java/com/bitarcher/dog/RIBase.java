package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneResBitmapTexture;

import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;

/**
 * Created by michel on 16/03/15.
 */
public class RIBase {
    IResourceManager resourceManager;

    public IResourceManager getResourceManager() {
        return resourceManager;
    }

    public RIBase(IResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    protected BitmapTexturesSetFromResIdsResourceInfo getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName(String name, int resId)
    {
        BitmapTexturesSetFromResIdsResourceInfo retval = null;

        retval = new BitmapTexturesSetFromResIdsResourceInfo(name, 512, 512, BitmapTextureFormat.RGBA_4444, null, this.resourceManager.getContext());

        retval.addOneTexture(new OneResBitmapTexture(name, resId));

        return retval;
    }
}
