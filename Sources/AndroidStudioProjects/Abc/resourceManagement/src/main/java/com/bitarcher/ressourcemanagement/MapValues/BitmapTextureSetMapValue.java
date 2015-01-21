package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBitmapTexturesSetResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneBitmapTexture;
import com.bitarcher.ressourcemanagement.MapValues.SubValues.OneBitmapTextureSV;
import com.bitarcher.ressourcemanagement.ResourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;

/**
 * Created by michel on 13/01/15.
 */
public class BitmapTextureSetMapValue extends TextureSetMapValue<IBitmapTexturesSetResourceInfo,
        IOneBitmapTexture,
        OneBitmapTextureSV
        > {
    public BitmapTextureSetMapValue(ResourceManager resourceManager, IBitmapTexturesSetResourceInfo texturesSetResourceInfo) {
        super(resourceManager, texturesSetResourceInfo);
    }

    @Override
    protected void setAssetBase(String assetBase) {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(assetBase);
    }

    @Override
    protected String getAssetBase() {
        return BitmapTextureAtlasTextureRegionFactory.getAssetBasePath();
    }

    @Override
    protected OneBitmapTextureSV createOneTexture(IResourceManager resourceManager, TextureSetMapValue textureSetMapValue, IOneBitmapTexture iOneBitmapTexture) {
        return new OneBitmapTextureSV(resourceManager, textureSetMapValue, iOneBitmapTexture);
    }
}
