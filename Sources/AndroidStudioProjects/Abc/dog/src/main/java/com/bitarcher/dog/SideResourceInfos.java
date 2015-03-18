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
public class SideResourceInfos extends RIBase{

    EnumSide side;
    RunResourceInfos run;
    StraightResourceInfos straightResourceInfos;

    SidedBitmapImageByResId lookPlayer;
    SidedBitmapImageByResId uTurn;
    SidedBitmapImageByResId walk1;
    SidedBitmapImageByResId walk2;
    SidedBitmapImageByResId sit;


    public SidedBitmapImageByResId getSit() {
        return sit;
    }

    public StraightResourceInfos getStraightResourceInfos() {
        return straightResourceInfos;
    }

    public EnumSide getSide() {
        return side;
    }

    public RunResourceInfos getRun() {
        return run;
    }

    public SidedBitmapImageByResId getLookPlayer() {
        return lookPlayer;
    }

    public SidedBitmapImageByResId getUTurn() {
        return uTurn;
    }

    public SidedBitmapImageByResId getWalk1() {
        return walk1;
    }

    public SidedBitmapImageByResId getWalk2() {
        return walk2;
    }

    public SideResourceInfos(Dog dog, EnumSide side) {
        super(dog);
        this.side = side;
        this.run = new RunResourceInfos(dog, side);
        this.straightResourceInfos = new StraightResourceInfos(dog, side);

        if(side == EnumSide.Left)
        {
            this.lookPlayer = this.getNewSidedBitmapImageByResId("lookPlayer", R.drawable.dog_left_look_player, side);
            this.uTurn = this.getNewSidedBitmapImageByResId("uTurn", R.drawable.dog_left_uturn, side);
            this.walk1 = this.getNewSidedBitmapImageByResId("walk1", R.drawable.dog_left_walk1, side);
            this.walk2 = this.getNewSidedBitmapImageByResId("walk2", R.drawable.dog_left_walk2, side);
            this.sit = this.getNewSidedBitmapImageByResId("sit", R.drawable.dog_left_sit, side);
        }
        else
        {
            this.lookPlayer = this.getNewSidedBitmapImageByResId("lookPlayer", R.drawable.dog_right_look_player, side);
            this.uTurn = this.getNewSidedBitmapImageByResId("uTurn", R.drawable.dog_right_uturn, side);
            this.walk1 = this.getNewSidedBitmapImageByResId("walk1", R.drawable.dog_right_walk1, side);
            this.walk2 = this.getNewSidedBitmapImageByResId("walk2", R.drawable.dog_right_walk2, side);
            this.sit = this.getNewSidedBitmapImageByResId("sit", R.drawable.dog_right_sit, side);
        }
    }
}

