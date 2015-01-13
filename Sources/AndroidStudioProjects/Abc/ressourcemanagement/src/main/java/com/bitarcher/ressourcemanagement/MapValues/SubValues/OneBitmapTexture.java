package com.bitarcher.ressourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneTexture;
import com.bitarcher.ressourcemanagement.MapValues.TextureSetMapValue;
import com.bitarcher.ressourcemanagement.ResourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 13/01/15.
 */
public class OneBitmapTexture extends OneTexture {
    public OneBitmapTexture(ResourceManager resourceManager, TextureSetMapValue textureSetMapValue, IOneTexture oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }

    @Override
    protected ITextureRegion createTextureRegionFromAsset(ResourceManager resourceManager, TextureSetMapValue textureSetMapValue, IOneTexture oneTextureResourceInfo) {
        return BitmapTextureAtlasTextureRegionFactory.createFromAsset(textureSetMapValue.getTexture(),
                resourceManager.getContext(), this.oneTextureResourceInfo.getFilename());
    }
}
