package com.bitarcher.ressourcemanagement.MapValues;

import android.util.Log;

import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IAnimationResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBitmapAnimationResourceInfo;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;

/**
 * Created by michel on 10/01/15.
 */
public class BitmapAnimationMapValue extends  AnimationMapValue  {
    @Override
    protected ITiledTextureRegion createTiledTexture(IResourceManager resourceManager, BuildableBitmapTextureAtlas buildableBitmapTextureAtlas, IAnimationResourceInfo animationResourceInfo) {
        return BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.buildableBitmapTextureAtlas, resourceManager.getContext(), animationResourceInfo.getFilename(), animationResourceInfo.getNumOfColumns(), animationResourceInfo.getNumOfRows());
    }

    public BitmapAnimationMapValue(IResourceManager resourceManager, IBitmapAnimationResourceInfo bitmapAnimationResourceInfo) {
        super(resourceManager, bitmapAnimationResourceInfo);
    }
}
