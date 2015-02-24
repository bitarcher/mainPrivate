/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.gui.widgets;

import com.bitarcher.interfaces.mvc.IImagedAndLabeled;

/**
 * Created by michel on 23/02/15.
 */
public interface IScrollingMenuListener {
    void onItemClicked(IScrollingMenu scrollingMenu, IImagedAndLabeled imagedAndLabeled);
}
