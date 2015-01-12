package com.bitarcher.ressourcemanagement.RessourcesInfos.Font;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontResourceInfo;
import com.bitarcher.ressourcemanagement.RessourcesInfos.ResourceInfo;

import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 12/01/15.
 */
public abstract class BaseFontResourceInfo extends ResourceInfo implements IFontResourceInfo{
    int textureWidth;
    int textureHeight;
    float fontSize;
    Color frontColor;
    boolean antialiased;

    protected BaseFontResourceInfo(String name, int textureWidth, int textureHeight, float fontSize, Color frontColor, boolean antialiased) {
        super(name);
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.fontSize = fontSize;
        this.frontColor = frontColor;
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
    public Color getFrontColor() {
        return frontColor;
    }

    @Override
    public boolean isAntialiased() {
        return antialiased;
    }
}
