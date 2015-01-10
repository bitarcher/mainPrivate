package com.bitarcher.ressourcemanagement.MapValues;

import android.util.Log;

import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBitmapAnimationResourceInfo;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;

/**
 * Created by michel on 10/01/15.
 */
public class BitmapAnimationMapValue extends MapValue  {
    IResourceManager resourceManager;
    IBitmapAnimationResourceInfo bitmapAnimationResourceInfo;
    BuildableBitmapTextureAtlas buildableBitmapTextureAtlas;
    TiledTextureRegion tiledTextureRegion;
    AnimatedSprite animatedSprite;

    public BitmapAnimationMapValue(IResourceManager resourceManager, final IBitmapAnimationResourceInfo bitmapAnimationResourceInfo) {
        this.resourceManager = resourceManager;
        this.bitmapAnimationResourceInfo = bitmapAnimationResourceInfo;

        String mPreviousAssetsBase = BitmapTextureAtlasTextureRegionFactory.getAssetBasePath();
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(bitmapAnimationResourceInfo.getAssetsBase());


        this.buildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(resourceManager.getEngine().getTextureManager(),
                bitmapAnimationResourceInfo.getAtlasWidth(), bitmapAnimationResourceInfo.getAtlasHeight(), bitmapAnimationResourceInfo.getTextureOptions());

        this.tiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.buildableBitmapTextureAtlas, this.resourceManager.getContext(), this.bitmapAnimationResourceInfo.getFilename(), this.bitmapAnimationResourceInfo.getNumOfColumns(), this.bitmapAnimationResourceInfo.getNumOfRows());

        try
        {
            this.buildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 1));
        }
        catch (ITextureAtlasBuilder.TextureAtlasBuilderException e)
        {
            Log.v("Bitmap animation load", "Exception:" + e.getMessage());
        }

        this.buildableBitmapTextureAtlas.load();

        this.animatedSprite = new AnimatedSprite(this.bitmapAnimationResourceInfo.getInitialX(), this.bitmapAnimationResourceInfo.getInitialY(), this.tiledTextureRegion, this.resourceManager.getEngine().getVertexBufferObjectManager())
        {

            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                if(bitmapAnimationResourceInfo.isEnableDithering())
                {

                    pGLState.enableDither();
                }
                super.preDraw(pGLState, pCamera);
            }

            @Override
            protected void postDraw(GLState pGLState, Camera pCamera) {
                pGLState.disableDither();
                super.postDraw(pGLState, pCamera);
            }
        };

        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(mPreviousAssetsBase);
    }

    @Override
    public void clean() {
        this.animatedSprite.clearEntityModifiers();
        this.animatedSprite.clearUpdateHandlers();
        this.animatedSprite = null;
        if(this.buildableBitmapTextureAtlas != null)
        {
            if(this.buildableBitmapTextureAtlas.isLoadedToHardware())
            {
                this.buildableBitmapTextureAtlas.unload();
            }
            this.buildableBitmapTextureAtlas = null;
        }
    }
}
