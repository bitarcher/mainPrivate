/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.aeFunExamplesShowRoom.resourceManagement.ResourcesInfos.SubInfos;


import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResTexture;

/**
 * Created by michel on 26/01/15.
 */
public abstract class OneResTexture extends OneTexture implements IOneResTexture {

    protected int resId;

    @Override
    public int getResId() {
        return this.resId;
    }

    public OneResTexture(String name, int resId) {
        super(name);
        this.resId = resId;
    }
}
