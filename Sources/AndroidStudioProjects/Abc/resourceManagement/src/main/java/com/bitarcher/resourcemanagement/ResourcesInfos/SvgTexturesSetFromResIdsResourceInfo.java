/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.ResourcesInfos;

import android.content.Context;

import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ISvgTexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.SubInfos.IOneResSvgTexture;

/**
 * Created by michel on 26/01/15.
 */
public class SvgTexturesSetFromResIdsResourceInfo extends TexturesSetFromResIdsResourceInfo<IOneResSvgTexture> implements ISvgTexturesSetFromResIdsResourceInfo {
    public SvgTexturesSetFromResIdsResourceInfo(String name, Context context, int atlasWidth, int atlasHeight) {
        super(name, context, atlasWidth, atlasHeight);
    }
}
