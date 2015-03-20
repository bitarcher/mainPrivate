package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFunExamplesShowRoom.drawables.characters.CharacterSidedImage;

import com.bitarcher.aeFunExamplesShowRoom.drawables.characters.RIBase;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.drawables.characters.EnumSide;

/**
 * Created by michel on 16/03/15.
 */
public class StraightResourceInfos extends RIBase {
    EnumSide side;
    CharacterSidedImage straightBackMouthOpened;
    CharacterSidedImage straightFrontClosedEyes;
    CharacterSidedImage straightFrontClosedEyesSmileTailLifted;
    CharacterSidedImage straightFrontMouthWideOpened;
    CharacterSidedImage straightMiddleMouthOpened;
    CharacterSidedImage straight;


    public EnumSide getSide() {
        return side;
    }

    public CharacterSidedImage getStraightBackMouthOpened() {
        return straightBackMouthOpened;
    }

    public CharacterSidedImage getStraightFrontClosedEyes() {
        return straightFrontClosedEyes;
    }

    public CharacterSidedImage getStraightFrontClosedEyesSmileTailLifted() {
        return straightFrontClosedEyesSmileTailLifted;
    }

    public CharacterSidedImage getStraightFrontMouthWideOpened() {
        return straightFrontMouthWideOpened;
    }

    public CharacterSidedImage getStraightMiddleMouthOpened() {
        return straightMiddleMouthOpened;
    }

    public CharacterSidedImage getStraight() {
        return straight;
    }

    public StraightResourceInfos(Dog dog, EnumSide side) {
        super(dog);
        this.side = side;

        this.straightBackMouthOpened = this.getNewSidedBitmapImageByResId("straightBackMouthOpened", R.drawable.dog_right_straight_back_mouth_opened, side);
        this.straightFrontClosedEyes = this.getNewSidedBitmapImageByResId("straightFrontClosedEyes", R.drawable.dog_right_straight_front_closed_eyes, side);
        this.straightFrontClosedEyesSmileTailLifted = this.getNewSidedBitmapImageByResId("straightFrontClosedEyesSmileTailLifted", R.drawable.dog_right_straight_front_closed_eyes_smile_tail_lifted, side);
        this.straightFrontMouthWideOpened = this.getNewSidedBitmapImageByResId("straightFrontMouthWideOpened", R.drawable.dog_right_straight_front_mouth_wide_opened, side);
        this.straightMiddleMouthOpened = this.getNewSidedBitmapImageByResId("straightMiddleMouthOpened", R.drawable.dog_right_straight_middle_mouth_opened, side);
        this.straight = this.getNewSidedBitmapImageByResId("straight", R.drawable.dog_right_straight, side);
    }
}

