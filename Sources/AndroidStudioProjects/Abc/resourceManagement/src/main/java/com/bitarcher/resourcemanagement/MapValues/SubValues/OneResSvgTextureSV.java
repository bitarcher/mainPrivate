/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.MapValues.SubValues;

import android.content.Context;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneResSvgTexture;

import com.bitarcher.resourcemanagement.MapValues.TextureSetFromResMapValue;


import org.andengine.extension.svg.SVGParser;
import org.andengine.extension.svg.adt.ISVGColorMapper;
import org.andengine.extension.svg.adt.SVG;
import org.andengine.extension.svg.opengl.texture.atlas.bitmap.SVGBitmapTextureAtlasTextureRegionFactory;

import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;

import org.andengine.opengl.texture.region.ITextureRegion;

import java.io.InputStream;
import java.io.InputStreamReader;

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

            TextureSetFromResMapValue textureSetFromResMapValue = (TextureSetFromResMapValue)textureSetMapValue;

            BuildableBitmapTextureAtlas texture = textureSetMapValue.getTexture();

            Context context = textureSetFromResMapValue.getContext();
            int rawResId = ((IOneResSvgTexture)oneTextureResourceInfo).getRawResId();
            int width = oneTextureResourceInfo.getWidth();
            int height = oneTextureResourceInfo.getHeight();
            ISVGColorMapper isvgColorMapper = oneTextureResourceInfo.getSvgColorMapper();

            assert texture != null;
            assert context != null;
            assert rawResId > 0;
            assert width > 0;
            assert height > 0;

/*
            if(isvgColorMapper != null) {
                retval = SVGBitmapTextureAtlasTextureRegionFactory.createFromResource(texture, context, rawResId, width, height, isvgColorMapper);
            }
            else {
                retval = SVGBitmapTextureAtlasTextureRegionFactory.createFromResource(texture, context, rawResId, width, height);
            }
*/

            InputStream is = context.getResources().openRawResource(((IOneResSvgTexture) oneTextureResourceInfo).getRawResId());
            InputStreamReader isr = new InputStreamReader(is);

            SVG svg = SVGParser.parseSVGFromInputStream(is, isvgColorMapper);

            retval = SVGBitmapTextureAtlasTextureRegionFactory.createFromSVG(texture, svg, width, height);


            return retval;
        }
}
