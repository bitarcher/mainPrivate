/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.ISvgTexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResSvgTexture;

/**
 * Created by michel on 26/01/15.
 */
public class SvgTexturesSetFromResIdsResourceInfo extends TexturesSetFromResIdsResourceInfo<IOneResSvgTexture> implements ISvgTexturesSetFromResIdsResourceInfo {
    public SvgTexturesSetFromResIdsResourceInfo(String name, int atlasWidth, int atlasHeight) {
        super(name, atlasWidth, atlasHeight);
    }
}
