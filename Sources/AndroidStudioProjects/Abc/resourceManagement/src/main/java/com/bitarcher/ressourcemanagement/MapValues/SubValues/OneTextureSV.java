package com.bitarcher.ressourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneTexture;
import com.bitarcher.ressourcemanagement.MapValues.TextureSetMapValue;
import com.bitarcher.ressourcemanagement.ResourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 10/01/15.
 */
public abstract class OneTextureSV<TOneTextureResourceInfo extends IOneTexture> {
    IResourceManager resourceManager;
    ITextureSetMapValue textureSetMapValue;
    TOneTextureResourceInfo oneTextureResourceInfo;
    protected ITextureRegion textureRegion;

    public IResourceManager getResourceManager() {
        return resourceManager;
    }

    public ITextureSetMapValue getTextureSetMapValue() {
        return textureSetMapValue;
    }

    public IOneTexture getOneTextureResourceInfo() {
        return oneTextureResourceInfo;
    }

    public ITextureRegion getTextureRegion() {
        return textureRegion;
    }

    public OneTextureSV(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, TOneTextureResourceInfo oneTextureResourceInfo) {
        this.resourceManager = resourceManager;
        this.textureSetMapValue = textureSetMapValue;
        this.oneTextureResourceInfo = oneTextureResourceInfo;

        this.textureRegion = this.createTextureRegionFromAsset(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }

    protected abstract ITextureRegion createTextureRegionFromAsset(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, TOneTextureResourceInfo oneTextureResourceInfo);
}
