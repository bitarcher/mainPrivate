/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.aeFun.resourceManagement.ResourcesInfos;

import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneTexture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 26/01/15.
 */
public class TexturesSetResourceInfo <TOneTexture extends IOneTexture>  extends ResourceInfo implements ITexturesSetResourceInfo<TOneTexture> {

    protected ArrayList<TOneTexture> textureList;
    protected int atlasWidth;
    protected int atlasHeight;

    @Override
    public int getAtlasWidth() {
        return this.atlasWidth;
    }

    @Override
    public int getAtlasHeight() {
        return this.atlasHeight;
    }


    @Override
    public List<TOneTexture> getTextureList() {
        return this.textureList;
    }



    public TexturesSetResourceInfo(String name, int atlasWidth, int atlasHeight) {
        super(name);
        this.atlasWidth = atlasWidth;
        this.atlasHeight = atlasHeight;
        this.textureList = new ArrayList<>();
    }

    public void addOneTexture(TOneTexture oneTexture)
    {
        this.textureList.add(oneTexture);
    }
}
