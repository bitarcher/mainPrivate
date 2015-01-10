package com.bitarcher.ressourcemanagement.RessourcesInfos;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.ITexturesSetRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.SubInfos.IOneTexture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 10/01/15.
 */
public class TexturesSetRessourceInfo implements ITexturesSetRessourceInfo {

    String name;
    String assetsBase;
    ArrayList<IOneTexture> textureList;
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
    public String getName() {
        return this.name;
    }

    @Override
    public String getAssetsBase() {
        return this.assetsBase;
    }

    @Override
    public List<IOneTexture> getTextureList() {
        return this.textureList;
    }

    @Override
    public boolean isSimilar(IRessourceInfo ressourceInfo) {
        boolean retval = true;

        if(ressourceInfo instanceof ITexturesSetRessourceInfo)
        {
            retval &= this.name == ((ITexturesSetRessourceInfo) ressourceInfo).getName();
        }
        else
        {
            retval = false;
        }

        return retval;
    }

    @Override
    public int getHashCode() {
        return this.name.hashCode();
    }


    public TexturesSetRessourceInfo(String name, int atlasWidth, int atlasHeight, String assetsBase) {
        this.name = name;
        this.atlasWidth = atlasWidth;
        this.atlasHeight = atlasHeight;
        this.assetsBase = assetsBase;
        this.textureList = new ArrayList<>();
    }

    public void addOneTexture(IOneTexture oneTexture)
    {
        this.textureList.add(oneTexture);
    }
}
