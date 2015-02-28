/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.MapValues.SubValues;

import com.bitarcher.interfacesProtected.resourcemanagement.IResourceManager;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.SubInfos.IOneAssetBitmapTexture;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 26/01/15.
 */
public class OneAssetBitmapTextureSV extends OneBitmapTextureSV<IOneAssetBitmapTexture> {
    public OneAssetBitmapTextureSV(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, IOneAssetBitmapTexture oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }

    @Override
    protected ITextureRegion createTextureRegionFromResourceInfo(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, IOneAssetBitmapTexture oneTextureResourceInfo) {
        ITextureRegion retval = null;

        retval = BitmapTextureAtlasTextureRegionFactory.createFromAsset(textureSetMapValue.getTexture(),
                    resourceManager.getContext(), oneTextureResourceInfo.getFilename());


        return retval;
    }
}
