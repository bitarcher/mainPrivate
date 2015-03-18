package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFun.interfaces.drawables.characters.EnumSide;

/**
 * Created by michel on 16/03/15.
 */
public class StraightResourceInfos extends RIBase{
    EnumSide side;
    BitmapTexturesSetFromResIdsResourceInfo straightBackMouthOpened;
    BitmapTexturesSetFromResIdsResourceInfo straightFrontClosedEyes;
    BitmapTexturesSetFromResIdsResourceInfo straightFrontClosedEyesSmileTailLifted;
    BitmapTexturesSetFromResIdsResourceInfo straightFrontMouthWideOpened;
    BitmapTexturesSetFromResIdsResourceInfo straightMiddleMouthOpened;
    BitmapTexturesSetFromResIdsResourceInfo straight;


    public EnumSide getSide() {
        return side;
    }

    public BitmapTexturesSetFromResIdsResourceInfo getStraightBackMouthOpened() {
        return straightBackMouthOpened;
    }

    public BitmapTexturesSetFromResIdsResourceInfo getStraightFrontClosedEyes() {
        return straightFrontClosedEyes;
    }

    public BitmapTexturesSetFromResIdsResourceInfo getStraightFrontClosedEyesSmileTailLifted() {
        return straightFrontClosedEyesSmileTailLifted;
    }

    public BitmapTexturesSetFromResIdsResourceInfo getStraightFrontMouthWideOpened() {
        return straightFrontMouthWideOpened;
    }

    public BitmapTexturesSetFromResIdsResourceInfo getStraightMiddleMouthOpened() {
        return straightMiddleMouthOpened;
    }

    public BitmapTexturesSetFromResIdsResourceInfo getStraight() {
        return straight;
    }

    public StraightResourceInfos(Dog dog, EnumSide side) {
        super(dog);
        this.side = side;


        if(side == EnumSide.Left) {
            this.straightBackMouthOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straightBackMouthOpened", R.drawable.dog_left_straight_back_mouth_opened, side);
            this.straightFrontClosedEyes = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straightFrontClosedEyes", R.drawable.dog_left_straight_front_closed_eyes, side);
            this.straightFrontClosedEyesSmileTailLifted = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straightFrontClosedEyesSmileTailLifted", R.drawable.dog_left_straight_front_closed_eyes_smile_tail_lifted, side);
            this.straightFrontMouthWideOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straightFrontMouthWideOpened", R.drawable.dog_left_straight_front_mouth_wide_opened, side);
            this.straightMiddleMouthOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straightMiddleMouthOpened", R.drawable.dog_left_straight_middle_mouth_opened, side);
            this.straight = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straight", R.drawable.dog_left_straight, side);
        }
        else
        {
            this.straightBackMouthOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straightBackMouthOpened", R.drawable.dog_right_straight_back_mouth_opened, side);
            this.straightFrontClosedEyes = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straightFrontClosedEyes", R.drawable.dog_right_straight_front_closed_eyes, side);
            this.straightFrontClosedEyesSmileTailLifted = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straightFrontClosedEyesSmileTailLifted", R.drawable.dog_right_straight_front_closed_eyes_smile_tail_lifted, side);
            this.straightFrontMouthWideOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straightFrontMouthWideOpened", R.drawable.dog_right_straight_front_mouth_wide_opened, side);
            this.straightMiddleMouthOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straightMiddleMouthOpened", R.drawable.dog_right_straight_middle_mouth_opened, side);
            this.straight = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("straight", R.drawable.dog_right_straight, side);
        }
    }
}

