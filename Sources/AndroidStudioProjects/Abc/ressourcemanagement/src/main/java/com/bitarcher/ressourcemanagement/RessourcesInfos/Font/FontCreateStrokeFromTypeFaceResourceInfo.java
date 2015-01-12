package com.bitarcher.ressourcemanagement.RessourcesInfos.Font;

import android.graphics.Typeface;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateStrokeFromTypeFaceResourceInfo;

import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 12/01/15.
 */
public class FontCreateStrokeFromTypeFaceResourceInfo extends FontCreateFromTypeFaceResourceInfo implements IFontCreateStrokeFromTypeFaceResourceInfo {

    Color backColor;

    public FontCreateStrokeFromTypeFaceResourceInfo(String name, int textureWidth, int textureHeight, float fontSize, Color frontColor, boolean antialiased, Typeface typeFace, Color backColor) {
        super(name, textureWidth, textureHeight, fontSize, frontColor, antialiased, typeFace);
        this.backColor = backColor;
    }

    @Override
    public Color getBackColor() {
        return this.backColor;
    }
}
