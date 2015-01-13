package com.bitarcher.ressourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneTexture;
import com.bitarcher.ressourcemanagement.MapValues.TextureSetMapValue;
import com.bitarcher.ressourcemanagement.ResourceManager;

import org.andengine.extension.svg.opengl.texture.atlas.bitmap.SVGBitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 13/01/15.
 */
public class OneSvgTexture  extends OneTexture {
    @Override
    protected ITextureRegion createTextureRegionFromAsset(ResourceManager resourceManager, TextureSetMapValue textureSetMapValue, IOneTexture oneTextureResourceInfo) {
        //return SVGBitmapTextureAtlasTextureRegionFactory.createFromAsset(textureSetMapValue.getTexture(),

        //        resourceManager.getContext(), oneTextureResourceInfo.getFilename(), );

        return null;
    }

    public OneSvgTexture(ResourceManager resourceManager, TextureSetMapValue textureSetMapValue, IOneTexture oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }
}
