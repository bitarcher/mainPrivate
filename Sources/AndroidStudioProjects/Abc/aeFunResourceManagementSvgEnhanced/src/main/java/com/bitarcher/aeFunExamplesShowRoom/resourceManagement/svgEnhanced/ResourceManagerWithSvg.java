package com.bitarcher.aeFunExamplesShowRoom.resourceManagement.svgEnhanced;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.MapValues.MapValueFactoryByResourceInfo;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.ResourceManager;
import com.bitarcher.aeFunExamplesShowRoom.resourceManagement.svgEnhanced.MapValues.MapValueFactoryByResourceInfoWithSvg;

/**
 * Created by michel on 13/03/15.
 */
public class ResourceManagerWithSvg extends ResourceManager {
    @Override
    protected MapValueFactoryByResourceInfo getNewMapValueFactoryByResourceInfo() {

        return new MapValueFactoryByResourceInfoWithSvg(this);
    }
}
