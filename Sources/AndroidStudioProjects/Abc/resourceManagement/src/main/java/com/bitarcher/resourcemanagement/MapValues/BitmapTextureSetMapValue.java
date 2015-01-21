package com.bitarcher.resourcemanagement.MapValues;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.IBitmapTexturesSetResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneBitmapTexture;
import com.bitarcher.resourcemanagement.MapValues.SubValues.OneBitmapTextureSV;
import com.bitarcher.resourcemanagement.ResourceManager;

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
