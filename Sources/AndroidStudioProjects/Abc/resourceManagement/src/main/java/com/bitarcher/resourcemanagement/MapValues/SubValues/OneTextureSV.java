package com.bitarcher.resourcemanagement.MapValues.SubValues;

import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneTexture;

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

        this.textureRegion = this.createTextureRegionFromResourceInfo(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }

    protected abstract ITextureRegion createTextureRegionFromResourceInfo(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, TOneTextureResourceInfo oneTextureResourceInfo);
}
