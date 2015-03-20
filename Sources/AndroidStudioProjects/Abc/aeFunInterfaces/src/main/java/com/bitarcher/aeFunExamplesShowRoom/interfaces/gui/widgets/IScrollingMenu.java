/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.mvc.IImageAndLabeled;

import java.util.List;

/**
 * Created by michel on 23/02/15.
 */
public interface IScrollingMenu extends IWidget /* TODO parameters */{

    List<IImageAndLabeled> getImagedAndLabeledList();

    void addScrollingMenuListener(IScrollingMenuListener scrollingMenuListener);
    void removeScrollingMenuListener(IScrollingMenuListener scrollingMenuListener);
}
