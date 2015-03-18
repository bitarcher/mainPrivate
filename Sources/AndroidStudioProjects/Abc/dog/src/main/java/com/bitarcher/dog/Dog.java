package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */


import com.bitarcher.aeFun.interfaces.drawables.characters.EnumMainPosition;
import com.bitarcher.aeFun.interfaces.drawables.characters.EnumSide;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceInfoListGotter;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.IResourceInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 18/03/15.
 */
public class Dog extends com.bitarcher.aeFun.drawables.characters.Character implements IResourceInfoListGotter {

    ResourceInfos resourceInfos;

    @Override
    public List<IResourceInfo> getResourceInfoList() {

        ArrayList<IResourceInfo> retval = new ArrayList<>();


        for(EnumSide side : EnumSide.values()) {
            SideResourceInfos sideResourceInfos = this.resourceInfos.getSide(side);

            for (int i = 0; i < 5; i++) {
                retval.add(sideResourceInfos.getRun().runs[i]);
            }

            retval.add(sideResourceInfos.getStraightResourceInfos().getStraight());
            retval.add(sideResourceInfos.getStraightResourceInfos().getStraightBackMouthOpened());
            retval.add(sideResourceInfos.getStraightResourceInfos().getStraightFrontClosedEyes());
            retval.add(sideResourceInfos.getStraightResourceInfos().getStraightFrontClosedEyesSmileTailLifted());
            retval.add(sideResourceInfos.getStraightResourceInfos().getStraightFrontMouthWideOpened());
            retval.add(sideResourceInfos.getStraightResourceInfos().getStraightMiddleMouthOpened());

            retval.add(sideResourceInfos.getLookPlayer());
            retval.add(sideResourceInfos.getUTurn());
            retval.add(sideResourceInfos.getWalk1());
            retval.add(sideResourceInfos.getWalk2());
        }

        return retval;
    }

    public Dog(IResourceManager resourceManager) {
        super(resourceManager, "dog");

        this.resourceInfos = new ResourceInfos(this);
    }

    @Override
    public void pushResourceRequirements() {
        this.getResourceManager().pushRequirement(this);
    }

    @Override
    public void popResourceRequirements() {
        this.getResourceManager().popRequirement(this);
    }

    @Override
    public void setMainPosition(EnumSide side, EnumMainPosition mainPosition) {
        // TODO
    }
}
