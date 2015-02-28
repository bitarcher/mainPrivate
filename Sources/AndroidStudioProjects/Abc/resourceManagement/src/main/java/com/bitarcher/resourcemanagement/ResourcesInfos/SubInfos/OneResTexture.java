/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.ResourcesInfos.SubInfos;


import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.SubInfos.IOneResTexture;

/**
 * Created by michel on 26/01/15.
 */
public abstract class OneResTexture extends OneTexture implements IOneResTexture {

    int rawResId;

    @Override
    public int getRawResId() {
        return this.rawResId;
    }

    public OneResTexture(String name, int rawResId) {
        super(name);
        this.rawResId = rawResId;
    }
}
