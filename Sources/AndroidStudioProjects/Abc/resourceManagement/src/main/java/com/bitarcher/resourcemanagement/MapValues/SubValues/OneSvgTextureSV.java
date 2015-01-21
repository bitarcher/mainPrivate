package com.bitarcher.resourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneSvgTexture;
import com.bitarcher.resourcemanagement.MapValues.TextureSetMapValue;

import org.andengine.extension.svg.opengl.texture.atlas.bitmap.SVGBitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 13/01/15.
 */
public class OneSvgTextureSV extends OneTextureSV<IOneSvgTexture> {

    @Override
    protected ITextureRegion createTextureRegionFromAsset(IResourceManager resourceManager, ITextureSetMapValue textureSetMapValue, IOneSvgTexture iOneSvgTexture) {
        ITextureRegion retval = null;
        if(oneTextureResourceInfo.getSvgColorMapper() != null)
        {
            retval =SVGBitmapTextureAtlasTextureRegionFactory.createFromAsset(textureSetMapValue.getTexture(),
                    resourceManager.getContext(), oneTextureResourceInfo.getFilename(),
                    oneTextureResourceInfo.getWidth(),
                    oneTextureResourceInfo.getHeight(),
                    oneTextureResourceInfo.getSvgColorMapper());
        }
        else
        {
            retval =SVGBitmapTextureAtlasTextureRegionFactory.createFromAsset(textureSetMapValue.getTexture(),
                    resourceManager.getContext(), oneTextureResourceInfo.getFilename(),
                    oneTextureResourceInfo.getWidth(),
                    oneTextureResourceInfo.getHeight());
        }

        return retval;
    }

    public OneSvgTextureSV(IResourceManager resourceManager, TextureSetMapValue textureSetMapValue, IOneSvgTexture oneTextureResourceInfo) {
        super(resourceManager, textureSetMapValue, oneTextureResourceInfo);
    }
}
