package com.bitarcher.aeFunExamplesShowRoom.resourceManagement.svgEnhanced.MapValues;

import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.svgEnhanced.MapValues.SubValues.OneAssetSvgTextureSV;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues.TextureSetFromAssetMapValue;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.ResourceManager;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.ISvgTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetSvgTexture;

import org.andengine.extension.svg.opengl.texture.atlas.bitmap.SVGBitmapTextureAtlasTextureRegionFactory;


/**
 * Created by michel on 13/01/15.
 */

public class SvgTextureSetFromAssetMapValue extends TextureSetFromAssetMapValue<ISvgTexturesSetFromAssetResourceInfo,
        IOneAssetSvgTexture,
        OneAssetSvgTextureSV
        > {
    @Override
    protected void setAssetBase(String assetBase) {
        //SVGBitmapTextureAtlasTextureRegionFactory.setAssetBasePath(assetBase);
        // FIXME
        if(assetBase.length() != 0) {
            throw new IllegalArgumentException("assetsBase length != 0 not supported, please FIX ME or use asset at the root or use res");
        }
        SVGBitmapTextureAtlasTextureRegionFactory.setAssetBasePath("");
    }

    @Override
    protected String getAssetBase() {
        return null;
    }

    @Override
    protected OneAssetSvgTextureSV createOneTexture(IResourceManager resourceManager,  IOneAssetSvgTexture iOneAssetSvgTexture) {
        return new OneAssetSvgTextureSV(resourceManager, this, iOneAssetSvgTexture);
    }

    public SvgTextureSetFromAssetMapValue(ResourceManager resourceManager, ISvgTexturesSetFromAssetResourceInfo texturesSetResourceInfo) {
        super(resourceManager, texturesSetResourceInfo);
    }
}

