package com.bitarcher.resourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneBitmapTexture;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 13/01/15.
 */
public class OneBitmapTextureSV extends OneTextureSV<IOneBitmapTexture> {
    public OneBitmapTextureSV(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, IOneBitmapTexture oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }

    @Override
    protected ITextureRegion createTextureRegionFromAsset(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, IOneBitmapTexture iOneBitmapTexture) {
        return BitmapTextureAtlasTextureRegionFactory.createFromAsset(textureSetMapValue.getTexture(),
                resourceManager.getContext(), this.oneTextureResourceInfo.getFilename());
    }
}
