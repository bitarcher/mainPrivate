package com.bitarcher.interfaces.drawables.characters.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.drawables.characters.EnumMainPosition;
import com.bitarcher.aeFun.interfaces.drawables.characters.EnumSide;
import com.bitarcher.aeFun.interfaces.drawables.characters.IMainPositionSwitchIntermediatesGenerator;
import com.bitarcher.aeFun.interfaces.drawables.characters.ISidedImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 18/03/15.
 */
public class MainPositionSwithIntermediatesGenerator implements IMainPositionSwitchIntermediatesGenerator {
    @Override
    public List<ISidedImage> getTransitions(ISidedImage currentImage, EnumSide newSide, EnumMainPosition newMainPosition) {
        ArrayList<ISidedImage> retval = new ArrayList<>();

        // TODO

        return retval;
    }
}
