package com.bitarcher.aeFun.interfaces.mvc;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;

/**
 * Created by michel on 24/03/15.
 */
public class MvcImageTuple implements IImage {
    ITexturesSetResourceInfo textureSetResourceInfo;
    String textureName;

    public MvcImageTuple(ITexturesSetResourceInfo textureSetResourceInfo, String textureName) {
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

