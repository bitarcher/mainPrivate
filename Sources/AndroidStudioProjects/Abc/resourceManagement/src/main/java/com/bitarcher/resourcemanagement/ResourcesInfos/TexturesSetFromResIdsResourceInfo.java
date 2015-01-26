/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.ITexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResTexture;

/**
 * Created by michel on 26/01/15.
 */
public class TexturesSetFromResIdsResourceInfo<TOneResTexture extends IOneResTexture>  extends TexturesSetResourceInfo<TOneResTexture> implements ITexturesSetFromResIdsResourceInfo<TOneResTexture> {
    public TexturesSetFromResIdsResourceInfo(String name, int atlasWidth, int atlasHeight) {
        super(name, atlasWidth, atlasHeight);
    }
}
