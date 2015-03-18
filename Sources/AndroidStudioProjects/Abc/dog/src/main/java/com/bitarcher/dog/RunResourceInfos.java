package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.drawables.characters.SidedBitmapImageByResId;
import com.bitarcher.aeFun.interfaces.drawables.characters.ISidedImage;

import com.bitarcher.aeFun.interfaces.drawables.characters.EnumSide;

/**
 * Created by michel on 16/03/15.
 */
public class RunResourceInfos extends RIBase{

    EnumSide side;
    SidedBitmapImageByResId runs[];

    public SidedBitmapImageByResId[] getRuns() {
        return runs;
    }

    public RunResourceInfos(Dog dog, EnumSide side) {
        super(dog);
        this.side = side;

        this.runs = new SidedBitmapImageByResId[5];

        if(side == EnumSide.Left)
        {
            this.runs[0] = this.getNewSidedBitmapImageByResId("run1", R.drawable.dog_left_run1, side);
            this.runs[1] = this.getNewSidedBitmapImageByResId("run2", R.drawable.dog_left_run2, side);
            this.runs[2] = this.getNewSidedBitmapImageByResId("run3", R.drawable.dog_left_run3, side);
            this.runs[3] = this.getNewSidedBitmapImageByResId("run4", R.drawable.dog_left_run4, side);
            this.runs[4] = this.getNewSidedBitmapImageByResId("run5", R.drawable.dog_left_run5, side);

        }
        else
        {
            this.runs[0] = this.getNewSidedBitmapImageByResId("run1", R.drawable.dog_right_run1, side);
            this.runs[1] = this.getNewSidedBitmapImageByResId("run2", R.drawable.dog_right_run2, side);
            this.runs[2] = this.getNewSidedBitmapImageByResId("run3", R.drawable.dog_right_run3, side);
            this.runs[3] = this.getNewSidedBitmapImageByResId("run4", R.drawable.dog_right_run4, side);
            this.runs[4] = this.getNewSidedBitmapImageByResId("run5", R.drawable.dog_right_run5, side);
        }
    }

    public EnumSide getSide() {
        return side;
    }


    /**
     *
     * @param sidedImage
     * @return -1 if not one of those or the indice if found
     */
    public int isOneOfThose(ISidedImage sidedImage)
    {
        int retval = -1;

        for(int i = 0 ; i < this.runs.length ; i++)
        {
            if(this.runs[i] == sidedImage)
            {
                retval = i;
                break;
            }
        }

        return retval;
    }
}
