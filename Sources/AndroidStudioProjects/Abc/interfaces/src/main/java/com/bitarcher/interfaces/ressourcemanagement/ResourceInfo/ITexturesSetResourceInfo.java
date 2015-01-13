package com.bitarcher.interfaces.ressourcemanagement.ResourceInfo;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneTexture;

import java.util.List;

/**
 * Created by michel on 12/01/15.
 */
public interface ITexturesSetResourceInfo<TOneTexture extends IOneTexture>  extends IResourceInfo{
    String getAssetsBase();
    int getAtlasWidth();
    int getAtlasHeight();

    List<TOneTexture> getTextureList();
}
