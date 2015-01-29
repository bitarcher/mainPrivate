/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.MapValues.SubValues;

import android.content.Context;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.ITexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetBitmapTexture;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneBitmapTexture;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResBitmapTexture;
import com.bitarcher.resourcemanagement.MapValues.TextureSetFromResMapValue;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 26/01/15.
 */
public class OneResBitmapTextureSV extends OneBitmapTextureSV<IOneResBitmapTexture> {
    public OneResBitmapTextureSV(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, IOneResBitmapTexture oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }

    @Override
    protected ITextureRegion createTextureRegionFromResourceInfo(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, IOneResBitmapTexture oneTextureResourceInfo) {
        ITextureRegion retval = null;

        TextureSetFromResMapValue textureSetFromResMapValue = (TextureSetFromResMapValue)textureSetMapValue;

        Context context = textureSetFromResMapValue.getContext();

        retval = BitmapTextureAtlasTextureRegionFactory.createFromResource(textureSetMapValue.getTexture(),
                    context, oneTextureResourceInfo.getRawResId());

        return retval;
    }

}
