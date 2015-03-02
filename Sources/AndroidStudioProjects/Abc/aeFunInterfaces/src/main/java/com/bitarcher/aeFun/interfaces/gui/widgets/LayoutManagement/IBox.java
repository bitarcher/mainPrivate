package com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;

/**
 * Created by michel on 28/02/15.
 */
public interface IBox extends IWidget, IOriginalWidthAndHeightResetable{


    void addBoxListener(IBoxListener boxListener);
    void removeBoxListener(IBoxListener boxListener);

    EnumOrientation getOrientation();
    // false by default
    boolean isShouldFixedSpaceUsageBeResizedOnResize();
    void setShouldFixedSpaceUsageBeResizedOnResize(boolean shouldFixedSpaceUsageBeResizedOnResize);

    void packStart(IWidget widget, ISpaceUsage spaceUsage);
    void packEnd(IWidget widget, ISpaceUsage spaceUsage);
    void removeWidget(IWidget widget);

}

