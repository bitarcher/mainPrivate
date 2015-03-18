package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.drawables.characters.SidedBitmapImageByResId;
import com.bitarcher.aeFun.interfaces.drawables.characters.EnumSide;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneResBitmapTexture;

import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;

/**
 * Created by michel on 16/03/15.
 */

public class RIBase {
    Dog dog;;

    public Dog getDog() {
        return dog;
    }

    public RIBase(Dog dog) {
        this.dog = dog;
    }

    protected SidedBitmapImageByResId getNewSidedBitmapImageByResId(String positionName, int resId, EnumSide side)
    {
        SidedBitmapImageByResId retval = null;

        retval = new SidedBitmapImageByResId(this.dog, positionName, 512, 512, BitmapTextureFormat.RGBA_4444, null, resId, side);

        return retval;
    }
}
