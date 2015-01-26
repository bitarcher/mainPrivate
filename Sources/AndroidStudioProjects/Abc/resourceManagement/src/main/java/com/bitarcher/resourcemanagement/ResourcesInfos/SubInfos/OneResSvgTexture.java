/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.ResourcesInfos.SubInfos;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResBitmapTexture;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResSvgTexture;

import org.andengine.extension.svg.adt.ISVGColorMapper;

/**
 * Created by michel on 26/01/15.
 */
public class OneResSvgTexture extends OneResTexture implements IOneResSvgTexture {

    int width;
    int height;
    ISVGColorMapper svgColorMapper;

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public ISVGColorMapper getSvgColorMapper() {
        return this.svgColorMapper;
    }


    public OneResSvgTexture(String name, int rawResId, int width, int height, ISVGColorMapper svgColorMapper) {
        super(name, rawResId);

        this.width = width;
        this.height = height;
        this.svgColorMapper = svgColorMapper;
    }

    public OneResSvgTexture(String name, int rawResId, int width, int height) {
        this(name, rawResId, width, height, null);
    }

}