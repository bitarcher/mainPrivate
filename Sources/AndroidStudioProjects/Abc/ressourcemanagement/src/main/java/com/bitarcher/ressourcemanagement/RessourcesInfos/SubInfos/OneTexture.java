package com.bitarcher.ressourcemanagement.RessourcesInfos.SubInfos;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.SubInfos.IOneTexture;

/**
 * Created by michel on 10/01/15.
 */
public class OneTexture implements IOneTexture {
    String name;
    String filename;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getFilename() {
        return this.filename;
    }

    public OneTexture(String name, String filename) {
        this.name = name;
        this.filename = filename;
    }
}
