package com.bitarcher.aeFun.interfaces.geometry;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;

/**
 * Created by michel on 25/03/15.
 */
public interface IContainedPositionAndSizeComputerByAspectRatio {
    IPositionAndSizeOwner compute(IWidget container, EnumDockStyle dockStyle, IAspectRatioOwner aspectRatioOwner, float layoutBorder);
    IPositionAndSizeOwner compute(IWidget container, EnumDockStyle dockStyle, float aspectRatio, float layoutBorder);
    IPositionAndSizeOwner compute(IWidget container, EnumDockStyle dockStyle, float aspectRatio);
    IPositionAndSizeOwner compute(IWidget container, float aspectRatio);
}

