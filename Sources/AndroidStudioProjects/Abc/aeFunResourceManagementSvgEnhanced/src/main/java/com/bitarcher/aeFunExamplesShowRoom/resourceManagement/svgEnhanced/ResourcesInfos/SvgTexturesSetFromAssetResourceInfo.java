
package com.bitarcher.aeFunExamplesShowRoom.resourceManagement.svgEnhanced.ResourcesInfos;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.ISvgTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetSvgTexture;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.ResourcesInfos.TexturesSetFromAssetResourceInfo;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;


/**
 * Created by michel on 13/01/15.
 */

public class SvgTexturesSetFromAssetResourceInfo extends TexturesSetFromAssetResourceInfo<IOneAssetSvgTexture> implements ISvgTexturesSetFromAssetResourceInfo {
    public SvgTexturesSetFromAssetResourceInfo(String name, int atlasWidth, int atlasHeight, BitmapTextureFormat bitmapTextureFormat, TextureOptions textureOptions, String assetsBase) {
        super(name, atlasWidth, atlasHeight, bitmapTextureFormat, textureOptions, assetsBase);
    }
}

