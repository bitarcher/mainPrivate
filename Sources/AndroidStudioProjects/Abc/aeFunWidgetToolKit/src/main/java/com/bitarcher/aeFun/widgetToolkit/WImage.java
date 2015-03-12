package com.bitarcher.aeFun.widgetToolkit;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.mvc.IImage;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;

public class WImage implements IImage
{
    ITexturesSetResourceInfo textureSetResourceInfo;
    String textureName;

    public WImage(ITexturesSetResourceInfo textureSetResourceInfo, String textureName) {
        this.textureSetResourceInfo = textureSetResourceInfo;
        this.textureName = textureName;
    }

    @Override
    public ITexturesSetResourceInfo getTextureSetResourceInfo() {
        return textureSetResourceInfo;
    }

    @Override
    public String getTextureName() {
        return textureName;
    }
}