package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.drawables.characters.SidedBitmapImageByResId;

import com.bitarcher.aeFun.interfaces.drawables.characters.EnumSide;

/**
 * Created by michel on 16/03/15.
 */
public class StraightResourceInfos extends RIBase{
    EnumSide side;
    SidedBitmapImageByResId straightBackMouthOpened;
    SidedBitmapImageByResId straightFrontClosedEyes;
    SidedBitmapImageByResId straightFrontClosedEyesSmileTailLifted;
    SidedBitmapImageByResId straightFrontMouthWideOpened;
    SidedBitmapImageByResId straightMiddleMouthOpened;
    SidedBitmapImageByResId straight;


    public EnumSide getSide() {
        return side;
    }

    public SidedBitmapImageByResId getStraightBackMouthOpened() {
        return straightBackMouthOpened;
    }

    public SidedBitmapImageByResId getStraightFrontClosedEyes() {
        return straightFrontClosedEyes;
    }

    public SidedBitmapImageByResId getStraightFrontClosedEyesSmileTailLifted() {
        return straightFrontClosedEyesSmileTailLifted;
    }

    public SidedBitmapImageByResId getStraightFrontMouthWideOpened() {
        return straightFrontMouthWideOpened;
    }

    public SidedBitmapImageByResId getStraightMiddleMouthOpened() {
        return straightMiddleMouthOpened;
    }

    public SidedBitmapImageByResId getStraight() {
        return straight;
    }

    public StraightResourceInfos(Dog dog, EnumSide side) {
        super(dog);
        this.side = side;


        if(side == EnumSide.Left) {
            this.straightBackMouthOpened = this.getNewSidedBitmapImageByResId("straightBackMouthOpened", R.drawable.dog_left_straight_back_mouth_opened, side);
            this.straightFrontClosedEyes = this.getNewSidedBitmapImageByResId("straightFrontClosedEyes", R.drawable.dog_left_straight_front_closed_eyes, side);
            this.straightFrontClosedEyesSmileTailLifted = this.getNewSidedBitmapImageByResId("straightFrontClosedEyesSmileTailLifted", R.drawable.dog_left_straight_front_closed_eyes_smile_tail_lifted, side);
            this.straightFrontMouthWideOpened = this.getNewSidedBitmapImageByResId("straightFrontMouthWideOpened", R.drawable.dog_left_straight_front_mouth_wide_opened, side);
            this.straightMiddleMouthOpened = this.getNewSidedBitmapImageByResId("straightMiddleMouthOpened", R.drawable.dog_left_straight_middle_mouth_opened, side);
            this.straight = this.getNewSidedBitmapImageByResId("straight", R.drawable.dog_left_straight, side);
        }
        else
        {
            this.straightBackMouthOpened = this.getNewSidedBitmapImageByResId("straightBackMouthOpened", R.drawable.dog_right_straight_back_mouth_opened, side);
            this.straightFrontClosedEyes = this.getNewSidedBitmapImageByResId("straightFrontClosedEyes", R.drawable.dog_right_straight_front_closed_eyes, side);
            this.straightFrontClosedEyesSmileTailLifted = this.getNewSidedBitmapImageByResId("straightFrontClosedEyesSmileTailLifted", R.drawable.dog_right_straight_front_closed_eyes_smile_tail_lifted, side);
            this.straightFrontMouthWideOpened = this.getNewSidedBitmapImageByResId("straightFrontMouthWideOpened", R.drawable.dog_right_straight_front_mouth_wide_opened, side);
            this.straightMiddleMouthOpened = this.getNewSidedBitmapImageByResId("straightMiddleMouthOpened", R.drawable.dog_right_straight_middle_mouth_opened, side);
            this.straight = this.getNewSidedBitmapImageByResId("straight", R.drawable.dog_right_straight, side);
        }
    }
}

