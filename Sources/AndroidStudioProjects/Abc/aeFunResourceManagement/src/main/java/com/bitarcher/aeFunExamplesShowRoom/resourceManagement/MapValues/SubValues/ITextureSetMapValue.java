package com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues.SubValues;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneTexture;

import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;

/**
 * Created by michel on 13/01/15.
 */
public interface ITextureSetMapValue<TTexturesSetResourceInfo extends ITexturesSetResourceInfo<TOneTextureResourceInfo>,
        TOneTextureResourceInfo extends IOneTexture,
        TOneTextureSV extends OneTextureSV<TOneTextureResourceInfo>
        > {
    TTexturesSetResourceInfo getTexturesSetResourceInfo();
    BuildableBitmapTextureAtlas getTexture();
}
