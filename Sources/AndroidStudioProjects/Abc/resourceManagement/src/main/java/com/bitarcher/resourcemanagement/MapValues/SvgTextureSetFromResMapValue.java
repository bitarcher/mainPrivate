/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.MapValues;

import com.bitarcher.interfacesOpenSource.resourcemanagement.IResourceManager;
import com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.ISvgTexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.SubInfos.IOneResSvgTexture;
import com.bitarcher.resourcemanagement.MapValues.SubValues.OneResSvgTextureSV;
import com.bitarcher.resourcemanagement.ResourceManager;

/**
 * Created by michel on 26/01/15.
 */
public class SvgTextureSetFromResMapValue extends TextureSetFromResMapValue<ISvgTexturesSetFromResIdsResourceInfo,
        IOneResSvgTexture,
        OneResSvgTextureSV
        > {

    @Override
    protected OneResSvgTextureSV createOneTexture(IResourceManager resourceManager,  IOneResSvgTexture iOneResSvgTexture) {
        return new OneResSvgTextureSV(resourceManager, this, iOneResSvgTexture);
    }

    public SvgTextureSetFromResMapValue(ResourceManager resourceManager, ISvgTexturesSetFromResIdsResourceInfo texturesSetResourceInfo) {
        super(resourceManager, texturesSetResourceInfo);
    }
}
