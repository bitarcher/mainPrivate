/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResSvgTexture;

import com.bitarcher.resourcemanagement.MapValues.TextureSetFromResMapValue;

import org.andengine.extension.svg.opengl.texture.atlas.bitmap.SVGBitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 26/01/15.
 */
public class OneResSvgTextureSV extends OneSvgTextureSV<IOneResSvgTexture>{

        public OneResSvgTextureSV(IResourceManager resourceManager,TextureSetFromResMapValue textureSetMapValue,IOneResSvgTexture oneTextureResourceInfo){
            super(resourceManager,textureSetMapValue,oneTextureResourceInfo);
        }

        @Override
        protected ITextureRegion createTextureRegionFromResourceInfo(IResourceManager resourceManager,ITextureSetMapValue textureSetMapValue,IOneResSvgTexture oneTextureResourceInfo){
            ITextureRegion retval=null;

            if (oneTextureResourceInfo.getSvgColorMapper() != null) {
                retval = SVGBitmapTextureAtlasTextureRegionFactory.createFromResource(textureSetMapValue.getTexture(),
                        resourceManager.getContext(), ((IOneResSvgTexture)oneTextureResourceInfo).getRawResId(),
                        oneTextureResourceInfo.getWidth(),
                        oneTextureResourceInfo.getHeight(),
                        oneTextureResourceInfo.getSvgColorMapper());
            } else {
                retval = SVGBitmapTextureAtlasTextureRegionFactory.createFromResource(textureSetMapValue.getTexture(),
                        resourceManager.getContext(), ((IOneResSvgTexture)oneTextureResourceInfo).getRawResId(),
                        oneTextureResourceInfo.getWidth(),
                        oneTextureResourceInfo.getHeight());
            }

            return retval;
        }
}