package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import android.content.Context;

import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.ITexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneResBitmapTexture;
import com.bitarcher.interfaces.drawables.characters.EnumSide;
import com.bitarcher.interfaces.drawables.characters.dog.EnumPosition;

import org.andengine.opengl.texture.Texture;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;

/**
 * Created by michel on 16/03/15.
 */
public class ResourceInfos {
    IResourceManager resourceManager;

    SideResourceInfos leftSide;
    SideResourceInfos rightSide;

    public IResourceManager getResourceManager() {
        return resourceManager;
    }

    public SideResourceInfos getLeftSide() {
        return leftSide;
    }

    public SideResourceInfos getRightSide() {
        return rightSide;
    }

    public ResourceInfos(IResourceManager resourceManager) {
        this.resourceManager = resourceManager;

        this.leftSide = new SideResourceInfos(resourceManager, EnumSide.Left);
        this.rightSide = new SideResourceInfos(resourceManager,EnumSide.Right);
    }

    public ITexturesSetFromResIdsResourceInfo getTextureResourceInfo(EnumSide side, EnumPosition position)
    {
        ITexturesSetFromResIdsResourceInfo retval = null;

        SideResourceInfos sideResourceInfos = null;

        switch (side)
        {
            case Left:
                sideResourceInfos = this.leftSide;
                break;
            case Right:
                sideResourceInfos = this.rightSide;
                break;
        }

        switch (position)
        {
            case  LookPlayer:
                break;
            case  Run1:
                retval = sideResourceInfos.getRun().getRuns()[0];
                break;
            case  Run2:
                retval = sideResourceInfos.getRun().getRuns()[1];
                break;
            case  Run3:
                retval = sideResourceInfos.getRun().getRuns()[2];
                break;
            case  Run4:
                retval = sideResourceInfos.getRun().getRuns()[3];
                break;
            case  Run5:
                retval = sideResourceInfos.getRun().getRuns()[4];
                break;
            case  Sit:
                break;
            case  StraightBackMouthOpened:
                break;
            case  StraightFrontClosedEyes:
                break;
            case  StraightFrontClosedEyesSmileTailLifted:
                break;
            case  StraightFrontMouthWideOpened:
                break;
            case  StraightMiddleMouthOpened:
                break;
            case  Straight:
                break;
            case  UTurn:
                break;
            case  Walk1:
                break;
            case  Walk2:
                break;
        }

        if(retval == null)
        {
            throw  new UnsupportedOperationException(side.toString() + position.toString());
        }

        return retval;
    }
}
