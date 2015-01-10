package com.bitarcher.interfaces.ressourcemanagement.RessourceInfo;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.SubInfos.IOneTexture;

import java.util.List;

/**
 * Created by michel on 10/01/15.
 */
public interface ITexturesSetRessourceInfo extends IRessourceInfo{
    String getName();
    String getAssetsBase();
    int getAtlasWidth();
    int getAtlasHeight();

    List<IOneTexture> getTextureList();
}
