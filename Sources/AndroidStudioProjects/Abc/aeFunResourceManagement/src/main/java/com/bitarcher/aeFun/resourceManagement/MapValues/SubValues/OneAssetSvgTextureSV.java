/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.aeFun.resourceManagement.MapValues.SubValues;

import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetSvgTexture;
import com.bitarcher.aeFun.resourceManagement.MapValues.TextureSetFromAssetMapValue;

import org.andengine.extension.svg.opengl.texture.atlas.bitmap.SVGBitmapTextureAtlasTextureRegionFactory;

import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 26/01/15.
 */
public class OneAssetSvgTextureSV extends OneSvgTextureSV<IOneAssetSvgTexture> {
    public OneAssetSvgTextureSV(IResourceManager resourceManager, TextureSetFromAssetMapValue textureSetMapValue, IOneAssetSvgTexture oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }

    @Override
    protected ITextureRegion createTextureRegionFromResourceInfo(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, IOneAssetSvgTexture oneTextureResourceInfo) {
        ITextureRegion retval = null;

        if (oneTextureResourceInfo.getSvgColorMapper() != null) {
            retval = SVGBitmapTextureAtlasTextureRegionFactory.createFromAsset(textureSetMapValue.getTexture(),
                    resourceManager.getContext(), ((IOneAssetSvgTexture) oneTextureResourceInfo).getFilename(),
                    oneTextureResourceInfo.getWidth(),
                    oneTextureResourceInfo.getHeight(),
                    oneTextureResourceInfo.getSvgColorMapper());
        } else {
            retval = SVGBitmapTextureAtlasTextureRegionFactory.createFromAsset(textureSetMapValue.getTexture(),
                    resourceManager.getContext(), ((IOneAssetSvgTexture)oneTextureResourceInfo).getFilename(),
                    oneTextureResourceInfo.getWidth(),
                    oneTextureResourceInfo.getHeight());
        }

        return retval;
    }
}
