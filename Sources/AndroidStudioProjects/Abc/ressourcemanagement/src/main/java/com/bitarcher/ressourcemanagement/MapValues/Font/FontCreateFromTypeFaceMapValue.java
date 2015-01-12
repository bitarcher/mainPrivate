package com.bitarcher.ressourcemanagement.MapValues.Font;

import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateFromTypeFaceResourceInfo;

import org.andengine.opengl.font.FontFactory;

/**
 * Created by michel on 12/01/15.
 */
public class FontCreateFromTypeFaceMapValue extends BaseFontMapValue {

    public FontCreateFromTypeFaceMapValue(IResourceManager resourceManager, IFontCreateFromTypeFaceResourceInfo fontCreateFromTypeFaceResourceInfo) {
        this._tObj = FontFactory.create(
                resourceManager.getEngine().getFontManager(),
                resourceManager.getEngine().getTextureManager(),
                fontCreateFromTypeFaceResourceInfo.getTextureWidth(),
                fontCreateFromTypeFaceResourceInfo.getTextureHeight(),
                fontCreateFromTypeFaceResourceInfo.getTypeFace(),
                fontCreateFromTypeFaceResourceInfo.getFontSize(),
                fontCreateFromTypeFaceResourceInfo.isAntialiased(),
                fontCreateFromTypeFaceResourceInfo.getForeColor()
        );
    }
}
