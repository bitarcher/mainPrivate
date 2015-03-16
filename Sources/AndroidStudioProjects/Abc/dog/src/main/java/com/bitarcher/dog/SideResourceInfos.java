package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.drawables.characters.EnumSide;

/**
 * Created by michel on 16/03/15.
 */
public class SideResourceInfos extends RIBase{

    EnumSide side;
    RunResourceInfos run;

    public EnumSide getSide() {
        return side;
    }

    public RunResourceInfos getRun() {
        return run;
    }

    public SideResourceInfos(IResourceManager resourceManager, EnumSide side) {
        super(resourceManager);
        this.side = side;
        this.run = new RunResourceInfos(resourceManager, side);
    }
}
