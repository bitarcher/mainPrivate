package com.bitarcher.ressourcemanagement;

import android.content.Context;

import com.bitarcher.interfaces.ressourcemanagement.EResourceCreationError;
import com.bitarcher.interfaces.ressourcemanagement.EResourceNotFound;
import com.bitarcher.interfaces.ressourcemanagement.IResourceInfoListGotter;
import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBuildableBitmapTextureAtlasResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.ressourcemanagement.MapValues.BuildableBitmapTextureAtlasMapValue;
import com.bitarcher.ressourcemanagement.MapValues.MapValue;
import com.bitarcher.ressourcemanagement.MapValues.MapValueFactoryByResourceInfo;
import com.bitarcher.ressourcemanagement.MapValues.TextureSetMapValue;

import org.andengine.engine.Engine;
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
    public void pushRequirement(IResourceInfo ressourceTuple) throws EResourceCreationError {
        boolean exists = this._map.containsKey(ressourceTuple);
        MapValue mapValue = null;

        if(exists)
        {
            mapValue = this._map.get(ressourceTuple);
        }
        else {
            MapValueFactoryByResourceInfo factoryByRessourceInfo = new MapValueFactoryByResourceInfo(this);
            mapValue = factoryByRessourceInfo.make(ressourceTuple);


            this._map.put(ressourceTuple, mapValue);
        }

        mapValue.ref();

    }

    @Override
    public void pushRequirement(IResourceInfoListGotter ressourceTupleListGotter)  throws EResourceCreationError {
        for(IResourceInfo ressourceTuple : ressourceTupleListGotter.getRessourceInfoList())
        {
            this.pushRequirement(ressourceTuple);
        }

    }

    @Override
    public void popRequirement(IResourceInfo ressourceTuple) throws EResourceNotFound {
        boolean exists = this._map.containsKey(ressourceTuple);

        if(!exists)
        {
            throw new EResourceNotFound(ressourceTuple);
        }

        MapValue mapValue = this._map.get(ressourceTuple);

        mapValue.unref();

        if(!mapValue.isUsed())
        {
            mapValue.clean();
            this._map.remove(ressourceTuple);
        }
    }

    @Override
    public void popRequirement(IResourceInfoListGotter ressourceTupleListGotter) throws EResourceNotFound {
        ArrayList<IResourceInfo> copy = new ArrayList<>(ressourceTupleListGotter.getRessourceInfoList());

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
    public ITextureRegion getTextureRegionFromTextureSetByNames(ITexturesSetResourceInfo textureSetRessourceInfo, String textureName) throws EResourceNotFound
    {
        boolean exists = this._map.containsKey(textureSetRessourceInfo);

        if(!exists)
        {
            throw new EResourceNotFound(textureSetRessourceInfo);
        }

        MapValue mapValue = this._map.get(textureSetRessourceInfo);

        TextureSetMapValue textureSetMapValue = (TextureSetMapValue) mapValue;

        ITextureRegion retval = textureSetMapValue.getTextureRegionByName(textureName);

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
        return 0;
    }

    @Override
    public float getCameraScaleY() {
        return 0;
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
}
