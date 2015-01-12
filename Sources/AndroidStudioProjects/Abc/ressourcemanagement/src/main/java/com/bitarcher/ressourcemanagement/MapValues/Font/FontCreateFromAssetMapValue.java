package com.bitarcher.ressourcemanagement.MapValues.Font;

import android.content.res.AssetManager;

import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateFromAssetResourceInfo;

import org.andengine.opengl.font.FontFactory;
import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 12/01/15.
 */
public class FontCreateFromAssetMapValue extends BaseFontMapValue{
    public FontCreateFromAssetMapValue(IResourceManager resourceManager, IFontCreateFromAssetResourceInfo fontCreateFromAssetResourceInfo) {
        this._tObj = FontFactory.createFromAsset(resourceManager.getEngine().getFontManager(),
                resourceManager.getEngine().getTextureManager(),
                fontCreateFromAssetResourceInfo.getTextureWidth(),
                fontCreateFromAssetResourceInfo.getTextureHeight(),
                resourceManager.getContext().getAssets(),
                fontCreateFromAssetResourceInfo.getFilename(),
                fontCreateFromAssetResourceInfo.getFontSize(),
                fontCreateFromAssetResourceInfo.isAntialiased(),
                fontCreateFromAssetResourceInfo.getForeColor());
    }
}
