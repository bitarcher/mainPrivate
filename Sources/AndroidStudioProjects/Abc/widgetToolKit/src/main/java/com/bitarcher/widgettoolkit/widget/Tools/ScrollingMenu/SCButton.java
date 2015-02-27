/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.widgettoolkit.widget.Tools.ScrollingMenu;

import com.bitarcher.interfaces.gui.theme.ITheme;

import com.bitarcher.interfaces.mvc.IImagedAndLabeled;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;


import java.util.ArrayList;

/**
 * Created by michel on 27/02/15.
 */
public class SCButton extends Sprite {


    private IImagedAndLabeled imagedAndLabeled;
    private ArrayList<IButtonListener> buttonListenerArrayList = new ArrayList<>();

    public IImagedAndLabeled getImagedAndLabeled() {
        return imagedAndLabeled;
    }


    public SCButton(Scene scene, float pX, float pY, float pWidth, float pHeight, IImagedAndLabeled imagedAndLabeled, ITheme theme) {
        super(pX, pY, pWidth, pHeight,
                theme.getThemeManager().getResourceManager().getTextureRegionFromTextureSetByName(imagedAndLabeled.getTextureSetResourceInfo(), imagedAndLabeled.getTextureName()),
                theme.getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());

        this.imagedAndLabeled = imagedAndLabeled;
        scene.registerTouchArea(this);
    }

    public void addButtonListener(IButtonListener buttonListener) {
        this.buttonListenerArrayList.add(buttonListener);

    }

    public void removeButtonListener(IButtonListener buttonListener) {
        this.buttonListenerArrayList.remove(buttonListener);
    }

    @Override
    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

        for(IButtonListener buttonListener:this.buttonListenerArrayList)
        {
            buttonListener.onClicked(this.imagedAndLabeled);
        }

        return true;
    }
}

