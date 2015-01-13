package com.bitarcher.ressourcemanagement.ResourcesInfos.Font;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontResourceInfo;
import com.bitarcher.ressourcemanagement.ResourcesInfos.ResourceInfo;

/**
 * Created by michel on 12/01/15.
 */
public abstract class BaseFontResourceInfo extends ResourceInfo implements IFontResourceInfo{
    int textureWidth;
    int textureHeight;
    float fontSize;
    int foreColor;
    boolean antialiased;

    protected BaseFontResourceInfo(String name, int textureWidth, int textureHeight, float fontSize, int foreColor, boolean antialiased) {
        super(name);
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.fontSize = fontSize;
        this.foreColor = foreColor;
        this.antialiased = antialiased;
    }

    @Override
    public int getTextureWidth() {
        return textureWidth;
    }

    @Override
    public int getTextureHeight() {
        return textureHeight;
    }

    @Override
    public float getFontSize() {
        return fontSize;
    }

    @Override
    public int getForeColor() {
        return foreColor;
    }

    @Override
    public boolean isAntialiased() {
        return antialiased;
    }
}
