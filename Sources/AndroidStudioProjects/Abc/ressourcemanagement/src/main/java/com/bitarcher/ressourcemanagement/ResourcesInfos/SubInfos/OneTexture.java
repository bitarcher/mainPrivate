package com.bitarcher.ressourcemanagement.ResourcesInfos.SubInfos;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneTexture;

/**
 * Created by michel on 10/01/15.
 */
public abstract class OneTexture implements IOneTexture {
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
