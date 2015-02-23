/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.gui.widgets;

import com.bitarcher.interfaces.mvc.IImagedAndLabeled;

import java.util.List;

/**
 * Created by michel on 23/02/15.
 */
public interface IScrollingMenu extends IWidget {

    List<IImagedAndLabeled> getImagedAndLabeledList();

    void addScrollingMenuListener(IScrollingMenuListener scrollingMenuListener);
    void removeScrollingMenuListener(IScrollingMenuListener scrollingMenuListener);
}
