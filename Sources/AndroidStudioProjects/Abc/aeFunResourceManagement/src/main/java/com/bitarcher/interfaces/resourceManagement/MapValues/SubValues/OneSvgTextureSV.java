package com.bitarcher.interfaces.resourceManagement.MapValues.SubValues;

import com.bitarcher.interfaces.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneSvgTexture;
import com.bitarcher.interfaces.resourceManagement.MapValues.TextureSetMapValue;

/**
 * Created by michel on 13/01/15.
 */
public abstract class OneSvgTextureSV<TOneSvgTextureResourceInfo extends IOneSvgTexture> extends OneTextureSV<TOneSvgTextureResourceInfo>{

    public OneSvgTextureSV(IResourceManager resourceManager, TextureSetMapValue textureSetMapValue, TOneSvgTextureResourceInfo oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }
}
