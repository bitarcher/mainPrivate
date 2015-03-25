package com.bitarcher.aeFunGeometry;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.geometry.EnumDockStyle;
import com.bitarcher.aeFun.interfaces.geometry.IAspectRatioOwner;
import com.bitarcher.aeFun.interfaces.geometry.IContainedPositionAndSizeComputerByAspectRatio;
import com.bitarcher.aeFun.interfaces.geometry.IPositionAndSizeOwner;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;

/**
 * Created by michel on 25/03/15.
 */
public class ContainedPositionAndSizeComputerByAspectRatio implements IContainedPositionAndSizeComputerByAspectRatio {
    @Override
    public IPositionAndSizeOwner compute(IWidget container, EnumDockStyle dockStyle, IAspectRatioOwner aspectRatioOwner, float layoutBorder) {
        return this.compute(container, dockStyle, aspectRatioOwner.getAspectRatio(), layoutBorder);
    }

    @Override
    public IPositionAndSizeOwner compute(IWidget container, EnumDockStyle dockStyle, float aspectRatio, float layoutBorder) {
        
        // TODO

        return null;
    }

    @Override
    public IPositionAndSizeOwner compute(IWidget container, EnumDockStyle dockStyle, float aspectRatio) {
        return this.compute(container, dockStyle, aspectRatio, 0);
    }

    @Override
    public IPositionAndSizeOwner compute(IWidget container, float aspectRatio) {
        return this.compute(container, EnumDockStyle.Center, aspectRatio);
    }
}
