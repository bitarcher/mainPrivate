/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.resourceManagement.ResourcesInfos;

import android.content.Context;

import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.ISvgTexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResSvgTexture;

/**
 * Created by michel on 26/01/15.
 */
public class SvgTexturesSetFromResIdsResourceInfo extends TexturesSetFromResIdsResourceInfo<IOneResSvgTexture> implements ISvgTexturesSetFromResIdsResourceInfo {
    public SvgTexturesSetFromResIdsResourceInfo(String name, Context context, int atlasWidth, int atlasHeight) {
        super(name, context, atlasWidth, atlasHeight);
    }
}
