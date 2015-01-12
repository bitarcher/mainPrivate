package com.bitarcher.ressourcemanagement.RessourcesInfos.Font;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateFromAssetResourceInfo;

import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 12/01/15.
 */
public class FontCreateFromAssetResourceInfo extends BaseFontResourceInfo implements IFontCreateFromAssetResourceInfo {
    String assetPath;
    String filename;

    public FontCreateFromAssetResourceInfo(String name, int textureWidth, int textureHeight, float fontSize, Color frontColor, boolean antialiased, String assetPath, String filename) {
        super(name, textureWidth, textureHeight, fontSize, frontColor, antialiased);
        this.assetPath = assetPath;
        this.filename = filename;
    }

    @Override
    public String getAssetPath() {
        return assetPath;
    }

    @Override
    public String getFilename() {
        return filename;
    }
}

