/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abc.bll.xml.ro.resources;

import com.bitarcher.interfaces.bll.xml.abc.ro.resources.ISoundable;

import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Element;

/**
 * Created by michel on 13/02/15.
 */
public abstract class ASoundablePictureBase extends APictureBase implements ISoundable{

    String soundFilename;

    @Override
    public boolean getHasSound() {
        return this.soundFilename != null;
    }

    @Nullable
    @Override
    public String getSoundFilename() {
        return this.soundFilename;
    }

    @Override
    public void fromXml(Element element) {
        super.fromXml(element);

        this.soundFilename = element.getAttribute("sound");
    }
}

