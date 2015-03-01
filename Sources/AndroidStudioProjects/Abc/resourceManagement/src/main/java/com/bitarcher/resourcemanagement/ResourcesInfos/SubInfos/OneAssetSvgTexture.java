package com.bitarcher.resourcemanagement.ResourcesInfos.SubInfos;

import com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.SubInfos.IOneAssetSvgTexture;

import org.andengine.extension.svg.adt.ISVGColorMapper;

/**
 * Created by michel on 13/01/15.
 */
public class OneAssetSvgTexture extends OneAssetTexture implements IOneAssetSvgTexture {
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

    public OneAssetSvgTexture(String name, String filename, int width, int height, ISVGColorMapper svgColorMapper) {
        super(name, filename);
        this.width = width;
        this.height = height;
        this.svgColorMapper = svgColorMapper;
    }

    public OneAssetSvgTexture(String name, String filename, int width, int height) {
        this(name, filename, width, height, null);
    }
}
