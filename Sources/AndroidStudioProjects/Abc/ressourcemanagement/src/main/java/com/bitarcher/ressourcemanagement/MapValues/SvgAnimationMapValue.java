package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IAnimationResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ISvgAnimationResourceInfo;

import org.andengine.extension.svg.opengl.texture.atlas.bitmap.SVGBitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;

/**
 * Created by michel on 13/01/15.
 */
public class SvgAnimationMapValue  extends  AnimationMapValue<ISvgAnimationResourceInfo>  {
    @Override
    protected ITiledTextureRegion createTiledTexture(IResourceManager resourceManager, BuildableBitmapTextureAtlas buildableBitmapTextureAtlas, ISvgAnimationResourceInfo animationResourceInfo) {
        ITiledTextureRegion retval = null;

        if(animationResourceInfo.getSvgColorMapper() != null) {
            retval = SVGBitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.buildableBitmapTextureAtlas,
                    resourceManager.getContext(), animationResourceInfo.getFilename(),
                    animationResourceInfo.getWidth(), animationResourceInfo.getHeight(),
                    animationResourceInfo.getSvgColorMapper(),
                    animationResourceInfo.getNumOfColumns(), animationResourceInfo.getNumOfRows());
        }
        else
        {
            retval = SVGBitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.buildableBitmapTextureAtlas,
                    resourceManager.getContext(), animationResourceInfo.getFilename(),
                    animationResourceInfo.getWidth(), animationResourceInfo.getHeight(),
                    animationResourceInfo.getNumOfColumns(), animationResourceInfo.getNumOfRows());
        }

        return retval;
    }

    public SvgAnimationMapValue(IResourceManager resourceManager, ISvgAnimationResourceInfo animationResourceInfo) {
        super(resourceManager, animationResourceInfo);
    }
}
