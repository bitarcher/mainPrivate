/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.widgettoolkit.widget.Tools.ScrollingMenu;

import com.bitarcher.interfaces.mvc.IImagedAndLabeled;

import org.andengine.entity.Entity;

import java.util.ArrayList;

/**
 * Created by michel on 27/02/15.
 */
public class InnerContainer extends Entity {

    static final int PADDING = 10;

    public InnerContainer(float pX, float pY, float pHeight, ArrayList<IImagedAndLabeled> imagedAndLabeledList) {
        super(pX, pY, imagedAndLabeledList.size() * (pHeight + PADDING), pHeight);
    }


}
