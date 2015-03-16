package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfaces.drawables.characters.EnumSide;

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

    public StraightResourceInfos(IResourceManager resourceManager, EnumSide side) {
        super(resourceManager);
        this.side = side;


        if(side == EnumSide.Left) {
            this.straightBackMouthOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straightBackMouthOpened", R.drawable.dog_left_straight_back_mouth_opened);
            this.straightFrontClosedEyes = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straightFrontClosedEyes", R.drawable.dog_left_straight_front_closed_eyes);
            this.straightFrontClosedEyesSmileTailLifted = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straightFrontClosedEyesSmileTailLifted", R.drawable.dog_left_straight_front_closed_eyes_smile_tail_lifted);
            this.straightFrontMouthWideOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straightFrontMouthWideOpened", R.drawable.dog_left_straight_front_mouth_wide_opened);
            this.straightMiddleMouthOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straightMiddleMouthOpened", R.drawable.dog_left_straight_middle_mouth_opened);
            this.straight = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straight", R.drawable.dog_left_straight);
        }
        else
        {
            this.straightBackMouthOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straightBackMouthOpened", R.drawable.dog_right_straight_back_mouth_opened);
            this.straightFrontClosedEyes = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straightFrontClosedEyes", R.drawable.dog_right_straight_front_closed_eyes);
            this.straightFrontClosedEyesSmileTailLifted = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straightFrontClosedEyesSmileTailLifted", R.drawable.dog_right_straight_front_closed_eyes_smile_tail_lifted);
            this.straightFrontMouthWideOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straightFrontMouthWideOpened", R.drawable.dog_right_straight_front_mouth_wide_opened);
            this.straightMiddleMouthOpened = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straightMiddleMouthOpened", R.drawable.dog_right_straight_middle_mouth_opened);
            this.straight = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("dog" + side.name() + "straight", R.drawable.dog_right_straight);
        }
    }
}

