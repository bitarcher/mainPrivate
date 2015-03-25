package com.bitarcher.aeFunGeometry;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.geometry.EnumAlignStyle;
import com.bitarcher.aeFun.interfaces.geometry.IAspectRatioOwner;
import com.bitarcher.aeFun.interfaces.geometry.IContainedPositionAndSizeComputerByAspectRatio;
import com.bitarcher.aeFun.interfaces.geometry.IPositionAndSizeOwner;
import com.bitarcher.aeFun.interfaces.geometry.ISize;


/**
 * Created by michel on 25/03/15.
 */
public class ContainedPositionAndSizeComputerByAspectRatio implements IContainedPositionAndSizeComputerByAspectRatio {
    @Override
    public IPositionAndSizeOwner compute(ISize container, EnumAlignStyle dockStyle, IAspectRatioOwner aspectRatioOwner, float layoutBorder) {
        return this.compute(container, dockStyle, aspectRatioOwner.getAspectRatio(), layoutBorder);
    }

    @Override
    public IPositionAndSizeOwner compute(ISize container, EnumAlignStyle dockStyle, float containedAspectRatio, float layoutBorder) {

        float containedWidth;
        float containedHeight;
        float containedX;
        float containedY;

        float containerAspectRatio = container.getWidth() / container.getHeight();

        if(containedAspectRatio > containerAspectRatio)
        {
            // consider width is bigger than height
            containedWidth = container.getWidth() - 2 * layoutBorder;
            containedHeight = containedWidth / containedAspectRatio;
        }
        else
        {
            containedHeight = container.getHeight()  - 2 * layoutBorder;
            containedWidth = containedHeight * containedAspectRatio;
        }

        switch (dockStyle)
        {
            case  Fill:
                containedWidth = container.getWidth() - 2 * layoutBorder;
                containedHeight = container.getHeight()  - 2 * layoutBorder;
                containedX = layoutBorder;
                containedY = layoutBorder;
                break;
            case  Bottom:
                containedY = layoutBorder + containedHeight / 2;
                containedX = container.getWidth() / 2;
                break;
            case  Top:
                containedY = container.getHeight() - layoutBorder - containedHeight / 2;
                containedX = container.getWidth() / 2;
                break;
            case  Left:
                containedX = layoutBorder + containedWidth / 2;
                containedY = container.getHeight() / 2;
                break;
            case  Right:
                containedX = container.getWidth() - layoutBorder - containedWidth / 2;
                containedY = container.getHeight() / 2;
                break;
            case  Center:
                containedX = container.getWidth() / 2;
                containedY = container.getHeight() / 2;
                break;
            default:
                throw new UnsupportedOperationException();
        }

        PositionAndSizeOwner retval = new PositionAndSizeOwner(containedX, containedY, containedWidth, containedHeight);

        return retval;
    }

    @Override
    public IPositionAndSizeOwner compute(ISize container, EnumAlignStyle dockStyle, float aspectRatio) {
        return this.compute(container, dockStyle, aspectRatio, 0);
    }

    @Override
    public IPositionAndSizeOwner compute(ISize container, float aspectRatio) {
        return this.compute(container, EnumAlignStyle.Center, aspectRatio);
    }
}
