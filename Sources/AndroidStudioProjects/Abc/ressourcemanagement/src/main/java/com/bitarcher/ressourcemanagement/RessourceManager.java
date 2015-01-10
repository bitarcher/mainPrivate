package com.bitarcher.ressourcemanagement;

import android.content.Context;

import com.bitarcher.interfaces.ressourcemanagement.ERessourceCreationError;
import com.bitarcher.interfaces.ressourcemanagement.ERessourceNotFound;
import com.bitarcher.interfaces.ressourcemanagement.IRessourceInfoListGotter;
import com.bitarcher.interfaces.ressourcemanagement.IRessourceManager;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IBuildableBitmapTextureAtlasRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.ITexturesSetRessourceInfo;
import com.bitarcher.ressourcemanagement.MapValues.BuildableBitmapTextureAtlasMapValue;
import com.bitarcher.ressourcemanagement.MapValues.MapValue;
import com.bitarcher.ressourcemanagement.MapValues.MapValueFactoryByRessourceInfo;
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
public class RessourceManager implements IRessourceManager {
    // We include these objects in the resource manager for
    // easy accessibility across our project.
    Engine engine;
    Context context;
    float cameraWidth;
    float cameraHeight;
    float cameraScaleFactorX;
    float cameraScaleFactorY;

    HashMap<IRessourceInfo, MapValue> _map;


    public RessourceManager() {
        this._map = new HashMap<>();
    }

    @Override
    public void pushRequirement(IRessourceInfo ressourceTuple) throws ERessourceCreationError{
        boolean exists = this._map.containsKey(ressourceTuple);
        MapValue mapValue = null;

        if(exists)
        {
            mapValue = this._map.get(ressourceTuple);
        }
        else {
            MapValueFactoryByRessourceInfo factoryByRessourceInfo = new MapValueFactoryByRessourceInfo(this);
            mapValue = factoryByRessourceInfo.make(ressourceTuple);


            this._map.put(ressourceTuple, mapValue);
        }

        mapValue.ref();

    }

    @Override
    public void pushRequirement(IRessourceInfoListGotter ressourceTupleListGotter)  throws ERessourceCreationError {
        for(IRessourceInfo ressourceTuple : ressourceTupleListGotter.getRessourceInfoList())
        {
            this.pushRequirement(ressourceTuple);
        }

    }

    @Override
    public void popRequirement(IRessourceInfo ressourceTuple) throws ERessourceNotFound {
        boolean exists = this._map.containsKey(ressourceTuple);

        if(!exists)
        {
            throw new ERessourceNotFound(ressourceTuple);
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
    public void popRequirement(IRessourceInfoListGotter ressourceTupleListGotter) throws ERessourceNotFound {
        ArrayList<IRessourceInfo> copy = new ArrayList<>(ressourceTupleListGotter.getRessourceInfoList());

        Collections.reverse(copy);

        for(IRessourceInfo ressourceTuple : copy)
        {
            this.popRequirement(ressourceTuple);
        }
    }

    @Override
    public BuildableBitmapTextureAtlas getBuildableBitmapTextureAtlas(IBuildableBitmapTextureAtlasRessourceInfo buildableBitmapTextureAtlasRessourceInfo) throws ERessourceNotFound {
        boolean exists = this._map.containsKey(buildableBitmapTextureAtlasRessourceInfo);

        if(!exists)
        {
            throw new ERessourceNotFound(buildableBitmapTextureAtlasRessourceInfo);
        }

        MapValue mapValue = this._map.get(buildableBitmapTextureAtlasRessourceInfo);

        BuildableBitmapTextureAtlas retval = ((BuildableBitmapTextureAtlasMapValue) mapValue).getTValue();

        return retval;
    }

    @Override
    public ITextureRegion getTextureRegionFromTextureSetByNames(ITexturesSetRessourceInfo textureSetRessourceInfo, String textureName) throws ERessourceNotFound
    {
        boolean exists = this._map.containsKey(textureSetRessourceInfo);

        if(!exists)
        {
            throw new ERessourceNotFound(textureSetRessourceInfo);
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
