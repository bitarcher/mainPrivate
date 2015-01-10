package com.bitarcher.ressourcemanagement.RessourcesInfos;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBitmapAnimationResourceInfo;

import org.andengine.opengl.texture.TextureOptions;

/**
 * Created by michel on 10/01/15.
 */
public class BitmapAnimationResourceInfo extends ResourceInfo implements IBitmapAnimationResourceInfo {
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

    public BitmapAnimationResourceInfo(String name, int atlasWidth, int atlasHeight, TextureOptions textureOptions, String assetsBase, String filename, int numOfColumns, int numOfRows, float initialX, float initialY, boolean enableDithering) {
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
