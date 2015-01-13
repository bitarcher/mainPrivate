package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ISvgTexturesSetResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneSvgTexture;
import com.bitarcher.ressourcemanagement.MapValues.SubValues.OneSvgTextureSV;
import com.bitarcher.ressourcemanagement.ResourceManager;

import org.andengine.extension.svg.opengl.texture.atlas.bitmap.SVGBitmapTextureAtlasTextureRegionFactory;

/**
 * Created by michel on 13/01/15.
 */
public class SvgTextureSetMapValue extends TextureSetMapValue<ISvgTexturesSetResourceInfo,
        IOneSvgTexture,
        OneSvgTextureSV
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
    protected OneSvgTextureSV createOneTexture(IResourceManager resourceManager, TextureSetMapValue textureSetMapValue, IOneSvgTexture iOneSvgTexture) {
        return new OneSvgTextureSV(resourceManager, textureSetMapValue, iOneSvgTexture);
    }

    public SvgTextureSetMapValue(ResourceManager resourceManager, ISvgTexturesSetResourceInfo texturesSetResourceInfo) {
        super(resourceManager, texturesSetResourceInfo);
    }
}
