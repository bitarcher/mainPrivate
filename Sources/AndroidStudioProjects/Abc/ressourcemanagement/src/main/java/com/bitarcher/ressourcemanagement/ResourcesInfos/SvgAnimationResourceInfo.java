package com.bitarcher.ressourcemanagement.ResourcesInfos;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ISvgAnimationResourceInfo;
import com.bitarcher.ressourcemanagement.ResourcesInfos.AnimationResourceInfo;

import org.andengine.extension.svg.adt.ISVGColorMapper;
import org.andengine.opengl.texture.TextureOptions;
import org.jetbrains.annotations.Nullable;

/**
 * Created by michel on 13/01/15.
 */
public class SvgAnimationResourceInfo extends AnimationResourceInfo implements ISvgAnimationResourceInfo {
    int width;
    int height;
    ISVGColorMapper svgColorMapper;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Nullable
    @Override
    public ISVGColorMapper getSvgColorMapper() {
        return svgColorMapper;
    }

    public SvgAnimationResourceInfo(String name, int atlasWidth, int atlasHeight, TextureOptions textureOptions, String assetsBase, String filename, int numOfColumns, int numOfRows, float initialX, float initialY, boolean enableDithering, int width, int height, ISVGColorMapper svgColorMapper) {
        super(name, atlasWidth, atlasHeight, textureOptions, assetsBase, filename, numOfColumns, numOfRows, initialX, initialY, enableDithering);
        this.width = width;
        this.height = height;
        this.svgColorMapper = svgColorMapper;
    }
}
