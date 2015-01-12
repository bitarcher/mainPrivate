package com.bitarcher.ressourcemanagement;

import android.content.Context;

import com.bitarcher.interfaces.ressourcemanagement.EResourceCreationError;
import com.bitarcher.interfaces.ressourcemanagement.EResourceNotFound;
import com.bitarcher.interfaces.ressourcemanagement.IResourceInfoListGotter;
import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBitmapAnimationResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IMusicResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBuildableBitmapTextureAtlasResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ISoundResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.ressourcemanagement.MapValues.BitmapAnimationMapValue;
import com.bitarcher.ressourcemanagement.MapValues.BuildableBitmapTextureAtlasMapValue;
import com.bitarcher.ressourcemanagement.MapValues.Font.BaseFontMapValue;
import com.bitarcher.ressourcemanagement.MapValues.MapValue;
import com.bitarcher.ressourcemanagement.MapValues.MapValueFactoryByResourceInfo;
import com.bitarcher.ressourcemanagement.MapValues.MusicMapValue;
import com.bitarcher.ressourcemanagement.MapValues.SoundMapValue;
import com.bitarcher.ressourcemanagement.MapValues.TextureSetMapValue;

import org.andengine.audio.music.Music;
import org.andengine.audio.sound.Sound;
import org.andengine.engine.Engine;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITextureRegion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by michel on 08/01/15.
 */
public class ResourceManager implements IResourceManager {
    // We include these objects in the resource manager for
    // easy accessibility across our project.
    Engine engine;
    Context context;
    float cameraWidth;
    float cameraHeight;
    float cameraScaleFactorX;
    float cameraScaleFactorY;

    HashMap<IResourceInfo, MapValue> _map;


    public ResourceManager() {
        this._map = new HashMap<>();
    }

    @Override
    public void pushRequirement(IResourceInfo resourceInfo) throws EResourceCreationError {
        boolean exists = this._map.containsKey(resourceInfo);
        MapValue mapValue = null;

        if(exists)
        {
            mapValue = this._map.get(resourceInfo);
        }
        else {
            MapValueFactoryByResourceInfo factoryByRessourceInfo = new MapValueFactoryByResourceInfo(this);
            mapValue = factoryByRessourceInfo.make(resourceInfo);


            this._map.put(resourceInfo, mapValue);
        }

        mapValue.ref();

    }

    @Override
    public void pushRequirement(IResourceInfoListGotter resourceInfoListGotter)  throws EResourceCreationError {
        for(IResourceInfo ressourceTuple : resourceInfoListGotter.getRessourceInfoList())
        {
            this.pushRequirement(ressourceTuple);
        }

    }

    @Override
    public void popRequirement(IResourceInfo resourceInfo) throws EResourceNotFound {
        boolean exists = this._map.containsKey(resourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(resourceInfo);
        }

        MapValue mapValue = this._map.get(resourceInfo);

        mapValue.unref();

        if(!mapValue.isUsed())
        {
            mapValue.clean();
            this._map.remove(resourceInfo);
        }
    }

    @Override
    public void popRequirement(IResourceInfoListGotter resourceInfoListGotter) throws EResourceNotFound {
        ArrayList<IResourceInfo> copy = new ArrayList<>(resourceInfoListGotter.getRessourceInfoList());

        Collections.reverse(copy);

        for(IResourceInfo ressourceTuple : copy)
        {
            this.popRequirement(ressourceTuple);
        }
    }

    @Override
    public BuildableBitmapTextureAtlas getBuildableBitmapTextureAtlas(IBuildableBitmapTextureAtlasResourceInfo buildableBitmapTextureAtlasRessourceInfo) throws EResourceNotFound {
        boolean exists = this._map.containsKey(buildableBitmapTextureAtlasRessourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(buildableBitmapTextureAtlasRessourceInfo);
        }

        MapValue mapValue = this._map.get(buildableBitmapTextureAtlasRessourceInfo);

        BuildableBitmapTextureAtlas retval = ((BuildableBitmapTextureAtlasMapValue) mapValue).getTValue();

        return retval;
    }

    @Override
    public ITextureRegion getTextureRegionFromTextureSetByName(ITexturesSetResourceInfo textureSetResourceInfo, String textureName) throws EResourceNotFound
    {
        boolean exists = this._map.containsKey(textureSetResourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(textureSetResourceInfo);
        }

        MapValue mapValue = this._map.get(textureSetResourceInfo);

        TextureSetMapValue textureSetMapValue = (TextureSetMapValue) mapValue;

        ITextureRegion retval = textureSetMapValue.getTextureRegionByName(textureName);

        return retval;
    }

    @Override
    public AnimatedSprite getAnimatedSpriteFromBitmapAnimationResourceInfo(IBitmapAnimationResourceInfo bitmapAnimationResourceInfo) throws EResourceNotFound {
        boolean exists = this._map.containsKey(bitmapAnimationResourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(bitmapAnimationResourceInfo);
        }

        MapValue mapValue = this._map.get(bitmapAnimationResourceInfo);
        BitmapAnimationMapValue bitmapAnimationMapValue = (BitmapAnimationMapValue) mapValue;

        AnimatedSprite retval = bitmapAnimationMapValue.getAnimatedSprite();

        return retval;
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public Context getContext() {
        return this.context;
    }

    @Override
    public float getCameraWidth() {
        return this.cameraWidth;
    }

    @Override
    public float getCameraHeight() {
        return this.cameraHeight;
    }

    @Override
    public float getCameraScaleX() {
        return this.cameraScaleFactorX;
    }

    @Override
    public float getCameraScaleY() {
        return this.cameraScaleFactorY;
    }

    // Setup the ResourceManager
    public void setup(final Engine pEngine, final Context pContext, final float pCameraWidth, final float pCameraHeight, final float pCameraScaleX, final float pCameraScaleY){
        this.engine = pEngine;
        this.context = pContext;
        this.cameraWidth = pCameraWidth;
        this.cameraHeight = pCameraHeight;
        this.cameraScaleFactorX = pCameraScaleX;
        this.cameraScaleFactorY = pCameraScaleY;
    }

    @Override
    public Font getFont(IFontResourceInfo fontResourceInfo)  throws EResourceNotFound{
        boolean exists = this._map.containsKey(fontResourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(fontResourceInfo);
        }

        MapValue mapValue = this._map.get(fontResourceInfo);
        BaseFontMapValue fontMapValue = (BaseFontMapValue) mapValue;

        Font retval = fontMapValue.getTValue();

        return retval;
    }

    @Override
    public Sound getSound(ISoundResourceInfo soundResourceInfo) throws EResourceNotFound {
        boolean exists = this._map.containsKey(soundResourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(soundResourceInfo);
        }

        MapValue mapValue = this._map.get(soundResourceInfo);
        SoundMapValue soundMapValue = (SoundMapValue) mapValue;

        Sound retval = soundMapValue.getTValue();

        return retval;
    }

    @Override
    public Music getMusic(IMusicResourceInfo musicResourceInfo) throws EResourceNotFound {
        boolean exists = this._map.containsKey(musicResourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(musicResourceInfo);
        }

        MapValue mapValue = this._map.get(musicResourceInfo);
        MusicMapValue musicMapValue = (MusicMapValue) mapValue;

        Music retval = musicMapValue.getTValue();

        return retval;
    }
}

