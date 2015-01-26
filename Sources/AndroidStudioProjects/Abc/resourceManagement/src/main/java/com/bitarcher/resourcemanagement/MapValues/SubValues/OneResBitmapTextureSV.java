/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetBitmapTexture;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneBitmapTexture;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResBitmapTexture;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
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

        retval = BitmapTextureAtlasTextureRegionFactory.createFromResource(textureSetMapValue.getTexture(),
                    resourceManager.getContext(), oneTextureResourceInfo.getRawResId());

        return retval;
    }

}
