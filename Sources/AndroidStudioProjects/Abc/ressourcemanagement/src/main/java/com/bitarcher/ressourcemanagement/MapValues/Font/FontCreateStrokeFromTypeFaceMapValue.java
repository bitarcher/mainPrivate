package com.bitarcher.ressourcemanagement.MapValues.Font;

import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateStrokeFromAssetResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateStrokeFromTypeFaceResourceInfo;

import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;

/**
 * Created by michel on 12/01/15.
 */
public class FontCreateStrokeFromTypeFaceMapValue extends BaseFontMapValue {
    BitmapTextureAtlas fontTexture;

    public FontCreateStrokeFromTypeFaceMapValue(IResourceManager resourceManager, IFontCreateStrokeFromTypeFaceResourceInfo fontCreateStrokeFromTypeFaceResourceInfo) {

        this.fontTexture = new BitmapTextureAtlas(resourceManager.getEngine().getTextureManager(),
                fontCreateStrokeFromTypeFaceResourceInfo.getTextureWidth(),
                fontCreateStrokeFromTypeFaceResourceInfo.getTextureHeight(),
                TextureOptions.BILINEAR);


        this._tObj = FontFactory.createStroke(
                resourceManager.getEngine().getFontManager(),
                this.fontTexture,
                fontCreateStrokeFromTypeFaceResourceInfo.getTypeFace(),
                fontCreateStrokeFromTypeFaceResourceInfo.getFontSize(),
                fontCreateStrokeFromTypeFaceResourceInfo.isAntialiased(),
                fontCreateStrokeFromTypeFaceResourceInfo.getForeColor(),
                fontCreateStrokeFromTypeFaceResourceInfo.getStrokeWidth(),
                fontCreateStrokeFromTypeFaceResourceInfo.getBackColor());
    }

    @Override
    public void clean() {
        super.clean();

        if(this.fontTexture != null) {
            this.fontTexture.unload();
            this.fontTexture = null;
        }
    }
}
