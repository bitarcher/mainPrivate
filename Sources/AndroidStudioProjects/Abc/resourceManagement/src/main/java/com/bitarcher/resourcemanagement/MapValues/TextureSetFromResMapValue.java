/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.MapValues;


import android.content.Context;

import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.ITexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResTexture;
import com.bitarcher.resourcemanagement.MapValues.SubValues.ITextureSetMapValue;
import com.bitarcher.resourcemanagement.MapValues.SubValues.OneTextureSV;
import com.bitarcher.resourcemanagement.ResourceManager;

/**
 * Created by michel on 26/01/15.
 */
public abstract class TextureSetFromResMapValue <TTexturesSetFromResResourceInfo extends ITexturesSetFromResIdsResourceInfo<TOneResTextureResourceInfo>,
        TOneResTextureResourceInfo extends IOneResTexture,
        TOneResTextureSV extends OneTextureSV<TOneResTextureResourceInfo>
        >
        extends TextureSetMapValue<TTexturesSetFromResResourceInfo, TOneResTextureResourceInfo, TOneResTextureSV>
        implements ITextureSetMapValue {


    public TextureSetFromResMapValue(ResourceManager resourceManager, TTexturesSetFromResResourceInfo texturesSetResourceInfo) {
        super(resourceManager, texturesSetResourceInfo);

    }

    public Context getContext()
    {

        ITexturesSetFromResIdsResourceInfo texturesSetFromResIdsResourceInfo = (ITexturesSetFromResIdsResourceInfo) this.getTexturesSetResourceInfo();
        Context retval = texturesSetFromResIdsResourceInfo.getContext();

        return retval;
    }
}
