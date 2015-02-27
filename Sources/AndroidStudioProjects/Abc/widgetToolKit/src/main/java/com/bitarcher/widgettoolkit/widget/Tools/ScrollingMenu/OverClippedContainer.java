/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.widgettoolkit.widget.Tools.ScrollingMenu;

import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.mvc.IImagedAndLabeled;
import com.bitarcher.widgettoolkit.widget.Tools.ClippingEntity;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.util.GLState;

import java.util.ArrayList;

/**
 * Created by michel on 27/02/15.
 */
public class OverClippedContainer extends ClippingEntity {

    InnerContainer innerContainer;

    public OverClippedContainer(ITheme theme, Scene scene, float pX, float pY, float pWidth, float pHeight, ArrayList<IImagedAndLabeled> imagedAndLabeledList) {
        super(theme, scene, pX, pY, pWidth, pHeight);

        this.innerContainer = new InnerContainer(pX, pY, pHeight, imagedAndLabeledList);

        this.attachChild(this.innerContainer);
    }
}

