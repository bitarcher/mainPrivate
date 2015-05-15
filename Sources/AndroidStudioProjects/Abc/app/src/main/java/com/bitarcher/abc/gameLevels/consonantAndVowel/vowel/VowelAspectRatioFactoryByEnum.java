package com.bitarcher.abc.gameLevels.consonantAndVowel.vowel;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.basicioc.ITFactory;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneAssetBitmapTexture;

import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 13/05/15.
 */
public class VowelAspectRatioFactoryByEnum implements ITFactory<Float, EnumVowel> {

    IResourceManager resourceManager;

    public VowelAspectRatioFactoryByEnum(IResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    public IResourceManager getResourceManager() {
        return resourceManager;
    }

    @Override
    public Float make(EnumVowel enumVowel) {
        float retval = 0;

        OneAssetBitmapTexture oneAssetBitmapTexture = VowelsResourceInfosSingleton.getInstance().getVowel(enumVowel);
        ITextureRegion textureRegion = this.resourceManager.getTextureRegionFromTextureSetByName(
                VowelsResourceInfosSingleton.getInstance().bitmapTexturesSetFromAssetResourceInfo,
                oneAssetBitmapTexture.getName()
        );

        retval = textureRegion.getWidth() / textureRegion.getHeight();

        return retval;
    }
}
