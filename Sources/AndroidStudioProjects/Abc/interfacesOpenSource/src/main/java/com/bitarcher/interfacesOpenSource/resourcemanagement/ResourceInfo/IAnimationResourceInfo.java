package com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo;

import org.andengine.opengl.texture.TextureOptions;

/**
 * Created by michel on 13/01/15.
 */
public interface IAnimationResourceInfo extends  IResourceInfo{
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
