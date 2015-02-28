package com.bitarcher.resourcemanagement.MapValues.SubValues;

import com.bitarcher.interfacesProtected.resourcemanagement.IResourceManager;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.SubInfos.IOneSvgTexture;
import com.bitarcher.resourcemanagement.MapValues.TextureSetMapValue;

/**
 * Created by michel on 13/01/15.
 */
public abstract class OneSvgTextureSV<TOneSvgTextureResourceInfo extends IOneSvgTexture> extends OneTextureSV<TOneSvgTextureResourceInfo>{

    public OneSvgTextureSV(IResourceManager resourceManager, TextureSetMapValue textureSetMapValue, TOneSvgTextureResourceInfo oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }
}
