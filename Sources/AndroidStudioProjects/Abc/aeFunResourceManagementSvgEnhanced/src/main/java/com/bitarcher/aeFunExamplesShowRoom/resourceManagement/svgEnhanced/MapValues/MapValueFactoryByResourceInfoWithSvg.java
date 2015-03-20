package com.bitarcher.aeFunExamplesShowRoom.resourceManagement.svgEnhanced.MapValues;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.EResourceCreationError;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.IResourceInfo;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.ISvgAnimationResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.ISvgTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.ISvgTexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues.MapValue;

import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues.MapValueFactoryByResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.ResourceManager;


/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 08/01/15.
 */
public class MapValueFactoryByResourceInfoWithSvg extends MapValueFactoryByResourceInfo {


    public MapValueFactoryByResourceInfoWithSvg(ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override
    public MapValue make(IResourceInfo resourceInfo)  throws EResourceCreationError {
        MapValue retval = null;

        if(resourceInfo == null)
        {
            throw new NullPointerException("resourceInfo is null");
        }


        if(resourceInfo instanceof ISvgTexturesSetFromAssetResourceInfo)
        {
            SvgTextureSetFromAssetMapValue textureSetMapValue = new SvgTextureSetFromAssetMapValue(this.resourceManager, (ISvgTexturesSetFromAssetResourceInfo) resourceInfo);

            retval = textureSetMapValue;
        }
        else if(resourceInfo instanceof ISvgTexturesSetFromResIdsResourceInfo)
        {
            SvgTextureSetFromResMapValue textureSetMapValue = new SvgTextureSetFromResMapValue(this.resourceManager, (ISvgTexturesSetFromResIdsResourceInfo) resourceInfo);

            retval = textureSetMapValue;
        }
        else if(resourceInfo instanceof ISvgAnimationResourceInfo)
        {
            SvgAnimationMapValue svgAnimationMapValue = new SvgAnimationMapValue(this.resourceManager, (ISvgAnimationResourceInfo) resourceInfo);

            retval = svgAnimationMapValue;
        }
        else
        {
            retval = super.make(resourceInfo);
        }

        return retval;
    }
}

