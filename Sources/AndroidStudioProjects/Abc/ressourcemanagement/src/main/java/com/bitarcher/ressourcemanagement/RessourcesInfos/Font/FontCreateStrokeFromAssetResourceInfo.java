package com.bitarcher.ressourcemanagement.RessourcesInfos.Font;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateStrokeFromAssetResourceInfo;

import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 12/01/15.
 */
public class FontCreateStrokeFromAssetResourceInfo extends FontCreateFromAssetResourceInfo implements IFontCreateStrokeFromAssetResourceInfo {

    Color backColor;

    public FontCreateStrokeFromAssetResourceInfo(String name, int textureWidth, int textureHeight, float fontSize, Color frontColor, boolean antialiased, String assetPath, String filename, Color backColor) {
        super(name, textureWidth, textureHeight, fontSize, frontColor, antialiased, assetPath, filename);
        this.backColor = backColor;
    }

    @Override
    public Color getBackColor() {
        return this.backColor;
    }
}
