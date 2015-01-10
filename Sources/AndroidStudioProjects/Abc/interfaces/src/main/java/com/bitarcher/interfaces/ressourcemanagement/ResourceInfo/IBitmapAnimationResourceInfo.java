package com.bitarcher.interfaces.ressourcemanagement.ResourceInfo;

import org.andengine.opengl.texture.TextureOptions;

/**
 * Created by michel on 10/01/15.
 */
public interface IBitmapAnimationResourceInfo extends  IResourceInfo{
    int getAtlasWidth();
    int getAtlasHeight();
    TextureOptions getTextureOptions();
    String getAssetsBase();
    String getFilename();
    int getNumOfColumns();
    int getNumOfRows();
    float getInitialX();
    float getInitialY();
    boolean isEnableDithering();
}
