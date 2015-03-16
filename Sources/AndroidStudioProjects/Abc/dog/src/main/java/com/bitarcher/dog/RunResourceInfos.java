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
public class RunResourceInfos extends RIBase{

    EnumSide side;
    BitmapTexturesSetFromResIdsResourceInfo runs[];

    public BitmapTexturesSetFromResIdsResourceInfo[] getRuns() {
        return runs;
    }

    public RunResourceInfos(IResourceManager resourceManager, EnumSide side) {
        super(resourceManager);
        this.side = side;

        this.runs = new BitmapTexturesSetFromResIdsResourceInfo[5];

        if(side == EnumSide.Left)
        {
            this.runs[0] = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("run1", R.drawable.dog_left_run1);
            this.runs[1] = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("run2", R.drawable.dog_left_run2);
            this.runs[2] = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("run3", R.drawable.dog_left_run3);
            this.runs[3] = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("run4", R.drawable.dog_left_run4);
            this.runs[4] = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("run5", R.drawable.dog_left_run5);

        }
        else
        {
            this.runs[0] = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("run1", R.drawable.dog_right_run1);
            this.runs[1] = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("run2", R.drawable.dog_right_run2);
            this.runs[2] = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("run3", R.drawable.dog_right_run3);
            this.runs[3] = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("run4", R.drawable.dog_right_run4);
            this.runs[4] = this.getNewBitmapTexturesSetFromResIdsResourceInfoFromResIdAndName("run5", R.drawable.dog_right_run5);
        }
    }

    public EnumSide getSide() {
        return side;
    }


}
