package com.bitarcher.ressourcemanagement.RessourcesInfos.Font;

import android.graphics.Typeface;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateFromTypeFaceResourceInfo;

import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 12/01/15.
 */
public class FontCreateFromTypeFaceResourceInfo extends BaseFontResourceInfo implements IFontCreateFromTypeFaceResourceInfo {

    Typeface typeFace;

    public FontCreateFromTypeFaceResourceInfo(String name, int textureWidth, int textureHeight, float fontSize, int foreColor, boolean antialiased, Typeface typeFace) {
        super(name, textureWidth, textureHeight, fontSize, foreColor, antialiased);
        this.typeFace = typeFace;
    }

    @Override
    public Typeface getTypeFace() {
        return this.typeFace;
    }
}


