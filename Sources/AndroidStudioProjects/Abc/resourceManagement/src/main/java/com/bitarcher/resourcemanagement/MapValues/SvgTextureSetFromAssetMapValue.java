package com.bitarcher.resourcemanagement.MapValues;

import com.bitarcher.interfacesProtected.resourcemanagement.IResourceManager;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ISvgTexturesSetFromAssetResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.SubInfos.IOneAssetSvgTexture;
import com.bitarcher.resourcemanagement.MapValues.SubValues.OneAssetSvgTextureSV;
import com.bitarcher.resourcemanagement.ResourceManager;

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
        SVGBitmapTextureAtlasTextureRegionFactory.setAssetBasePath(assetBase);
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
