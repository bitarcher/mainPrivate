/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.resourcemanagement.ResourceInfo;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneTexture;

import java.util.List;

/**
 * Created by michel on 26/01/15.
 */
public interface ITexturesSetResourceInfo <TOneTexture extends IOneTexture>  extends IResourceInfo {
    int getAtlasWidth();
    int getAtlasHeight();

    List<TOneTexture> getTextureList();
}
