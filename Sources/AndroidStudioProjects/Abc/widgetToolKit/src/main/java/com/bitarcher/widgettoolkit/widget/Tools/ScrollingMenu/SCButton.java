/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.widgettoolkit.widget.Tools.ScrollingMenu;

import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.mvc.IImagedAndLabeled;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by michel on 27/02/15.
 */
public class SCButton extends Sprite {

    public SCButton(float pX, float pY, float pWidth, float pHeight, IImagedAndLabeled imagedAndLabeled, ITheme theme) {
        super(pX, pY, pWidth, pHeight,
                theme.getThemeManager().getResourceManager().getTextureRegionFromTextureSetByName(imagedAndLabeled.getTextureSetResourceInfo(), imagedAndLabeled.getTextureName()),
                theme.getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());
    }


}
