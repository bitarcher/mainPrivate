package com.bitarcher.ressourcemanagement.RessourcesInfos.SubInfos;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneSvgTexture;

import org.andengine.extension.svg.adt.ISVGColorMapper;

/**
 * Created by michel on 13/01/15.
 */
public class OneSvgTexture extends OneTexture implements IOneSvgTexture {
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

    public OneSvgTexture(String name, String filename, int width, int height, ISVGColorMapper svgColorMapper) {
        super(name, filename);
        this.width = width;
        this.height = height;
        this.svgColorMapper = svgColorMapper;
    }

    public OneSvgTexture(String name, String filename, int width, int height) {
        super(name, filename);
        this.width = width;
        this.height = height;
        this.svgColorMapper = null;
    }
}
