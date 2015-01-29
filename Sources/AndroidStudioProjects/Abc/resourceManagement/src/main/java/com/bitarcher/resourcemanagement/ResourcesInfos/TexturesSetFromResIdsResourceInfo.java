/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.ResourcesInfos;

import android.content.Context;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.ITexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResTexture;

/**
 * Created by michel on 26/01/15.
 */
public class TexturesSetFromResIdsResourceInfo<TOneResTexture extends IOneResTexture>  extends TexturesSetResourceInfo<TOneResTexture> implements ITexturesSetFromResIdsResourceInfo<TOneResTexture> {

    Context context;

    public TexturesSetFromResIdsResourceInfo(String name, Context context, int atlasWidth, int atlasHeight) {
        super(name, atlasWidth, atlasHeight);
        this.context = context;
    }

    @Override
    public Context getContext() {
        return this.context;
    }
}
