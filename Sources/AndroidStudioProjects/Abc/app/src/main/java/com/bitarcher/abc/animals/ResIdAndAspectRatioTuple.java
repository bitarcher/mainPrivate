package com.bitarcher.abc.animals;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 30/04/15.
 */
public class ResIdAndAspectRatioTuple {
    int resId;
    float aspectRatio;

    public ResIdAndAspectRatioTuple(int resId, float aspectRatio) {
        this.resId = resId;
        this.aspectRatio = aspectRatio;
    }

    public int getResId() {
        return resId;
    }

    public float getAspectRatio() {
        return aspectRatio;
    }
}

