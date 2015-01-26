package com.bitarcher.resourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.resourcemanagement.Access.IAsset;
import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetSvgTexture;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneBitmapTexture;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResSvgTexture;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneSvgTexture;
import com.bitarcher.resourcemanagement.MapValues.TextureSetFromAssetMapValue;
import com.bitarcher.resourcemanagement.MapValues.TextureSetMapValue;

import org.andengine.extension.svg.opengl.texture.atlas.bitmap.SVGBitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 13/01/15.
 */
public abstract class OneSvgTextureSV<TOneSvgTextureResourceInfo extends IOneSvgTexture> extends OneTextureSV<TOneSvgTextureResourceInfo>{

    public OneSvgTextureSV(IResourceManager resourceManager, TextureSetMapValue textureSetMapValue, TOneSvgTextureResourceInfo oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }
}
