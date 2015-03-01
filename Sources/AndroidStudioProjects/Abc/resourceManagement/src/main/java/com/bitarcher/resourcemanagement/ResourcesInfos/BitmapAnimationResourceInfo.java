package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.IBitmapAnimationResourceInfo;

import org.andengine.opengl.texture.TextureOptions;

/**
 * Created by michel on 10/01/15.
 */
public class BitmapAnimationResourceInfo extends AnimationResourceInfo implements IBitmapAnimationResourceInfo {
    public BitmapAnimationResourceInfo(String name, int atlasWidth, int atlasHeight, TextureOptions textureOptions, String assetsBase, String filename, int numOfColumns, int numOfRows, float initialX, float initialY, boolean enableDithering) {
        super(name, atlasWidth, atlasHeight, textureOptions, assetsBase, filename, numOfColumns, numOfRows, initialX, initialY, enableDithering);
    }
}
