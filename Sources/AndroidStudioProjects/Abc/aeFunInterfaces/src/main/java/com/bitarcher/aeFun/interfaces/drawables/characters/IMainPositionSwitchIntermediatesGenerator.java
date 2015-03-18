package com.bitarcher.aeFun.interfaces.drawables.characters;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.mvc.IImage;

import java.util.List;

/**
 * Created by michel on 18/03/15.
 */
public interface IMainPositionSwitchIntermediatesGenerator {
    List<ISidedImage> getTransitions(ISidedImage currentImage, EnumSide newSide, EnumMainPosition newMainPosition);
}
