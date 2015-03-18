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
public class SideResourceInfos extends RIBase{

    EnumSide side;
    RunResourceInfos run;
    StraightResourceInfos straightResourceInfos;

    BitmapTexturesSetFromResIdsResourceInfo lookPlayer;
    BitmapTexturesSetFromResIdsResourceInfo uTurn;
    BitmapTexturesSetFromResIdsResourceInfo walk1;
    BitmapTexturesSetFromResIdsResourceInfo walk2;


    public StraightResourceInfos getStraightResourceInfos() {
        return straightResourceInfos;
    }

    public EnumSide getSide() {
        return side;
    }

    public RunResourceInfos getRun() {
        return run;
    }

    public BitmapTexturesSetFromResIdsResourceInfo getLookPlayer() {
        return lookPlayer;
    }

    public BitmapTexturesSetFromResIdsResourceInfo getUTurn() {
        return uTurn;
    }

    public BitmapTexturesSetFromResIdsResourceInfo getWalk1() {
        return walk1;
    }

    public BitmapTexturesSetFromResIdsResourceInfo getWalk2() {
        return walk2;
    }

    public SideResourceInfos(Dog dog, EnumSide side) {
        super(dog);
        this.side = side;
        this.run = new RunResourceInfos(dog, side);
        this.straightResourceInfos = new StraightResourceInfos(dog, side);

        if(side == EnumSide.Left)
        {
            this.lookPlayer = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("lookPlayer", R.drawable.dog_left_look_player, side);
            this.uTurn = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("uTurn", R.drawable.dog_left_uturn, side);
            this.walk1 = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("walk1", R.drawable.dog_left_walk1, side);
            this.walk2 = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("walk2", R.drawable.dog_left_walk2, side);
        }
        else
        {
            this.lookPlayer = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("lookPlayer", R.drawable.dog_right_look_player, side);
            this.uTurn = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("uTurn", R.drawable.dog_right_uturn, side);
            this.walk1 = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("walk1", R.drawable.dog_right_walk1, side);
            this.walk2 = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("walk2", R.drawable.dog_right_walk2, side);
        }
    }
}

