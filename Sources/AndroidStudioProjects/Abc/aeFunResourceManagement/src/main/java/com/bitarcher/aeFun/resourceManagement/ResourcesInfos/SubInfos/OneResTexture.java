/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos;


import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResTexture;

/**
 * Created by michel on 26/01/15.
 */
public abstract class OneResTexture extends OneTexture implements IOneResTexture {

    protected int rawResId;

    @Override
    public int getRawResId() {
        return this.rawResId;
    }

    public OneResTexture(String name, int rawResId) {
        super(name);
        this.rawResId = rawResId;
    }
}
