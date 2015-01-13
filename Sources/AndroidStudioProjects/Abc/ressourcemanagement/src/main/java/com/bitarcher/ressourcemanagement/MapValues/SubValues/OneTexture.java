package com.bitarcher.ressourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneTexture;
import com.bitarcher.ressourcemanagement.MapValues.TextureSetMapValue;
import com.bitarcher.ressourcemanagement.ResourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 10/01/15.
 */
public abstract class OneTexture {
    ResourceManager resourceManager;
    TextureSetMapValue textureSetMapValue;
    IOneTexture oneTextureResourceInfo;
    protected ITextureRegion textureRegion;

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public TextureSetMapValue getTextureSetMapValue() {
        return textureSetMapValue;
    }

    public IOneTexture getOneTextureResourceInfo() {
        return oneTextureResourceInfo;
    }

    public ITextureRegion getTextureRegion() {
        return textureRegion;
    }

    public OneTexture(ResourceManager resourceManager, TextureSetMapValue textureSetMapValue, IOneTexture oneTextureResourceInfo) {
        this.resourceManager = resourceManager;
        this.textureSetMapValue = textureSetMapValue;
        this.oneTextureResourceInfo = oneTextureResourceInfo;



        this.textureRegion = this.createTextureRegionFromAsset(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }

    protected abstract ITextureRegion createTextureRegionFromAsset(ResourceManager resourceManager, TextureSetMapValue textureSetMapValue, IOneTexture oneTextureResourceInfo);
}
