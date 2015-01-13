package com.bitarcher.ressourcemanagement.ResourcesInfos;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneTexture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 12/01/15.
 */
public class TexturesSetResourceInfo<TOneTexture extends IOneTexture>  extends ResourceInfo implements ITexturesSetResourceInfo<TOneTexture> {


    String assetsBase;
    ArrayList<TOneTexture> textureList;
    int atlasWidth;
    int atlasHeight;

    @Override
    public int getAtlasWidth() {
        return this.atlasWidth;
    }

    @Override
    public int getAtlasHeight() {
        return this.atlasHeight;
    }

    @Override
    public String getAssetsBase() {
        return this.assetsBase;
    }

    @Override
    public List<TOneTexture> getTextureList() {
        return this.textureList;
    }



    public TexturesSetResourceInfo(String name, int atlasWidth, int atlasHeight, String assetsBase) {
        super(name);
        this.atlasWidth = atlasWidth;
        this.atlasHeight = atlasHeight;
        this.assetsBase = assetsBase;
        this.textureList = new ArrayList<>();
    }

    public void addOneTexture(TOneTexture oneTexture)
    {
        this.textureList.add(oneTexture);
    }
}
