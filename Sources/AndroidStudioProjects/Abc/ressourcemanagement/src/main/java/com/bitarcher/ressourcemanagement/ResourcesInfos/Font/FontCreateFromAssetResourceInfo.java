package com.bitarcher.ressourcemanagement.ResourcesInfos.Font;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateFromAssetResourceInfo;

/**
 * Created by michel on 12/01/15.
 */
public class FontCreateFromAssetResourceInfo extends BaseFontResourceInfo implements IFontCreateFromAssetResourceInfo {
    String filename;

    public FontCreateFromAssetResourceInfo(String name, int textureWidth, int textureHeight, float fontSize, int foreColor, boolean antialiased, String filename) {
        super(name, textureWidth, textureHeight, fontSize, foreColor, antialiased);
        this.filename = filename;
    }


    @Override
    public String getFilename() {
        return filename;
    }
}

