package com.bitarcher.aeFunExamplesShowRoom.resourceManagement.svgEnhanced.MapValues.SubValues;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneSvgTexture;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues.SubValues.OneTextureSV;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues.TextureSetMapValue;

/*
 * Created by michel on 13/01/15.
 */

public abstract class OneSvgTextureSV<TOneSvgTextureResourceInfo extends IOneSvgTexture> extends OneTextureSV<TOneSvgTextureResourceInfo> {

    public OneSvgTextureSV(IResourceManager resourceManager, TextureSetMapValue textureSetMapValue, TOneSvgTextureResourceInfo oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }
}
