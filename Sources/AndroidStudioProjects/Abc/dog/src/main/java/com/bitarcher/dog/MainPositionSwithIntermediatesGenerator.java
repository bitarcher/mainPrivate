package com.bitarcher.dog;

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

    Dog dog;

    public Dog getDog() {
        return dog;
    }

    public MainPositionSwithIntermediatesGenerator(Dog dog) {
        this.dog = dog;
    }

    @Override
    public List<ISidedImage> getTransitions(ISidedImage currentImage, EnumSide newSide, EnumMainPosition newMainPosition) {
        ArrayList<ISidedImage> retval = new ArrayList<>();

        SideResourceInfos currentSideResourceInfos =this.getDog().resourceInfos.getSide(currentImage.getSide());
        RunResourceInfos runRI = currentSideResourceInfos.getRun();

        int runInd = runRI.isOneOfThose(currentImage);

        if(runInd >= 0)
        {
            // currentImage is a run, finish run cycle

            for(int i = runInd ; i < runRI.getRuns().length ; i++)
            {
                retval.add(runRI.getRuns()[i]);
            }
        }

        if(currentImage.getSide() != newSide)
        {
            SideResourceInfos newSideResourceInfos =this.getDog().resourceInfos.getSide(newSide);
            retval.add(currentSideResourceInfos.getUTurn());
            retval.add(currentSideResourceInfos.getLookPlayer());
            retval.add(newSideResourceInfos.getLookPlayer());
            retval.add(newSideResourceInfos.getUTurn());

        }

        return retval;
    }
}

