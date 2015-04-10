/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.bll.xml.abc.ro.resources;

import org.jetbrains.annotations.Nullable;

/**
 * Created by michel on 13/02/15.
 */
public interface ISoundable {
    boolean getHasSound();

    @Nullable
    String getSoundFilename();
}
