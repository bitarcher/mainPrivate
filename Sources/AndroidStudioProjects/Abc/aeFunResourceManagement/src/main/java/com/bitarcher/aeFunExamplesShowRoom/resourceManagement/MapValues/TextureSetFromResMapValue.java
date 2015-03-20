/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues;


import android.content.Context;

import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues.SubValues.ITextureSetMapValue;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues.SubValues.OneTextureSV;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.ResourceManager;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.ITexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResTexture;

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
