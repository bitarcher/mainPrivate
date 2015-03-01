package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.IAnimationResourceInfo;

import org.andengine.opengl.texture.TextureOptions;

/**
 * Created by michel on 13/01/15.
 */
public abstract class AnimationResourceInfo extends ResourceInfo implements IAnimationResourceInfo {
    int atlasWidth;
    int atlasHeight;
    TextureOptions textureOptions;
    String assetsBase;
    String filename;
    int numOfColumns;
    int numOfRows;
    float initialX;
    float initialY;
    boolean enableDithering;

    public AnimationResourceInfo(String name, int atlasWidth, int atlasHeight, TextureOptions textureOptions, String assetsBase, String filename, int numOfColumns, int numOfRows, float initialX, float initialY, boolean enableDithering) {
        super(name);
        this.atlasWidth = atlasWidth;
        this.atlasHeight = atlasHeight;
        this.textureOptions = textureOptions;
        this.assetsBase = assetsBase;
        this.filename = filename;
        this.numOfColumns = numOfColumns;
        this.numOfRows = numOfRows;
        this.initialX = initialX;
        this.initialY = initialY;
        this.enableDithering = enableDithering;
    }

    @Override
    public int getAtlasWidth() {
        return atlasWidth;
    }

    @Override
    public int getAtlasHeight() {
        return atlasHeight;
    }

    @Override
    public TextureOptions getTextureOptions() {
        return textureOptions;
    }

    @Override
    public String getAssetsBase() {
        return assetsBase;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public int getNumOfColumns() {
        return numOfColumns;
    }

    @Override
    public int getNumOfRows() {
        return numOfRows;
    }

    @Override
    public float getInitialX() {
        return initialX;
    }

    @Override
    public float getInitialY() {
        return initialY;
    }

    public boolean isEnableDithering() {
        return enableDithering;
    }
}
