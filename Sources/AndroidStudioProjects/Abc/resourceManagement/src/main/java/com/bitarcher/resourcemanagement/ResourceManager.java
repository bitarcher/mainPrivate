package com.bitarcher.resourcemanagement;

import android.content.Context;
import android.util.Log;

import com.bitarcher.interfacesProtected.gui.theme.IThemeManager;
import com.bitarcher.interfacesProtected.resourcemanagement.EResourceCreationError;
import com.bitarcher.interfacesProtected.resourcemanagement.EResourceNotFound;
import com.bitarcher.interfacesProtected.resourcemanagement.IContextProvider;
import com.bitarcher.interfacesProtected.resourcemanagement.IResourceInfoListGotter;
import com.bitarcher.interfacesProtected.resourcemanagement.IResourceManager;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.Font.IFontResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IAnimationResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IMusicResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IBuildableBitmapTextureAtlasResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ISoundResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.resourcemanagement.MapValues.AnimationMapValue;
import com.bitarcher.resourcemanagement.MapValues.BuildableBitmapTextureAtlasMapValue;
import com.bitarcher.resourcemanagement.MapValues.Font.BaseFontMapValue;
import com.bitarcher.resourcemanagement.MapValues.MapValue;
import com.bitarcher.resourcemanagement.MapValues.MapValueFactoryByResourceInfo;
import com.bitarcher.resourcemanagement.MapValues.MusicMapValue;
import com.bitarcher.resourcemanagement.MapValues.SoundMapValue;
import com.bitarcher.resourcemanagement.MapValues.TextureSetMapValue;

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
import java.util.Map;

/**
 * Created by michel on 08/01/15.
 */
public class ResourceManager implements IResourceManager {
    // We include these objects in the resource manager for
    // easy accessibility across our project.
    Engine engine;
    IContextProvider contextProvider;

    IThemeManager themeManager;

    HashMap<IResourceInfo, MapValue> _map;

    public ResourceManager() {
        this._map = new HashMap<>();
    }

    public IThemeManager getThemeManager() {
        return this.themeManager;
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
            MapValueFactoryByResourceInfo factoryByResourceInfo = new MapValueFactoryByResourceInfo(this);
            mapValue = factoryByResourceInfo.make(resourceInfo);

            if(mapValue == null)
            {
                throw  new NullPointerException("MapValueFactory has returned a null value");
            }

            this._map.put(resourceInfo, mapValue);

            Log.d("Resource manager", "ADDED " + resourceInfo.getName()+ String.format("(%x)", resourceInfo.hashCode()));
        }

        mapValue.ref();

    }

    @Override
    public void pushRequirement(IResourceInfoListGotter resourceInfoListGotter)  throws EResourceCreationError {
        for(IResourceInfo resourceTuple : resourceInfoListGotter.getRessourceInfoList())
        {
            this.pushRequirement(resourceTuple);
        }

    }

    @Override
    public void popRequirement(IResourceInfo resourceInfo) throws EResourceNotFound {
        boolean exists = this._map.containsKey(resourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(resourceInfo, this.getContent());
        }

        MapValue mapValue = this._map.get(resourceInfo);

        mapValue.unref();

        if(!mapValue.isUsed())
        {
            mapValue.clean();
            this._map.remove(resourceInfo);
            Log.d("Resource manager", "REMOVED " + resourceInfo.getName()+ String.format("(%x)", resourceInfo.hashCode()));
        }
    }

    @Override
    public void popRequirement(IResourceInfoListGotter resourceInfoListGotter) throws EResourceNotFound {
        ArrayList<IResourceInfo> copy = new ArrayList<>(resourceInfoListGotter.getRessourceInfoList());

        Collections.reverse(copy);

        for(IResourceInfo resourceTuple : copy)
        {
            this.popRequirement(resourceTuple);
        }
    }

    @Override
    public BuildableBitmapTextureAtlas getBuildableBitmapTextureAtlas(IBuildableBitmapTextureAtlasResourceInfo buildableBitmapTextureAtlasRessourceInfo) throws EResourceNotFound {
        boolean exists = this._map.containsKey(buildableBitmapTextureAtlasRessourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(buildableBitmapTextureAtlasRessourceInfo, this.getContent());
        }

        MapValue mapValue = this._map.get(buildableBitmapTextureAtlasRessourceInfo);

        BuildableBitmapTextureAtlas retval = ((BuildableBitmapTextureAtlasMapValue) mapValue).getTValue();

        return retval;
    }

    String getContent()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("ResourceManager(%d) content : ", this.hashCode()));

        for(Map.Entry<IResourceInfo, MapValue> entry : this._map.entrySet())
        {
            stringBuilder.append(entry.getKey().getName()+ String.format("(%x)", entry.getKey().hashCode()) + " ; ");
        }
        stringBuilder.append(String.format("%n"));

        String retval = stringBuilder.toString();

        return retval;
    }

    @Override
    public String toString() {
        return this.getContent();
    }

    @Override
    public ITextureRegion getTextureRegionFromTextureSetByName(ITexturesSetResourceInfo textureSetResourceInfo, String textureName) throws EResourceNotFound
    {
        boolean exists = this._map.containsKey(textureSetResourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(textureSetResourceInfo, this.getContent());
        }

        MapValue mapValue = this._map.get(textureSetResourceInfo);

        TextureSetMapValue textureSetMapValue = (TextureSetMapValue) mapValue;

        ITextureRegion retval = textureSetMapValue.getTextureRegionByName(textureName);

        return retval;
    }

    @Override
    public AnimatedSprite getAnimatedSpriteFromAnimationResourceInfo(IAnimationResourceInfo animationResourceInfo) throws EResourceNotFound {
        boolean exists = this._map.containsKey(animationResourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(animationResourceInfo, this.getContent());
        }

        MapValue mapValue = this._map.get(animationResourceInfo);
        AnimationMapValue animationMapValue = (AnimationMapValue) mapValue;

        AnimatedSprite retval = animationMapValue.getAnimatedSprite();

        return retval;
    }



    @Override
    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public Context getContext() {
        return this.contextProvider.getContext();
    }

    @Override
    public float getCameraWidth() {
        return this.engine.getCamera().getWidth();
    }

    @Override
    public float getCameraHeight() {
        return this.engine.getCamera().getHeight();
    }

    // Setup the ResourceManager
    public void setup(final Engine pEngine, final IContextProvider contextProvider, IThemeManager themeManager){
        this.engine = pEngine;
        this.contextProvider = contextProvider;
        this.themeManager = themeManager;
    }

    @Override
    public Font getFont(IFontResourceInfo fontResourceInfo)  throws EResourceNotFound{
        boolean exists = this._map.containsKey(fontResourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(fontResourceInfo, this.getContent());
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
            throw new EResourceNotFound(soundResourceInfo, this.getContent());
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
            throw new EResourceNotFound(musicResourceInfo, this.getContent());
        }

        MapValue mapValue = this._map.get(musicResourceInfo);
        MusicMapValue musicMapValue = (MusicMapValue) mapValue;

        Music retval = musicMapValue.getTValue();

        return retval;
    }
}

