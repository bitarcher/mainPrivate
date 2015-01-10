package com.bitarcher.ressourcemanagement;

import android.content.Context;

import com.bitarcher.interfaces.ressourcemanagement.ERessourceCreationError;
import com.bitarcher.interfaces.ressourcemanagement.ERessourceTupleNotFound;
import com.bitarcher.interfaces.ressourcemanagement.ERessourceType;
import com.bitarcher.interfaces.ressourcemanagement.IRessourceManager;
import com.bitarcher.interfaces.ressourcemanagement.IRessourceTuple;
import com.bitarcher.interfaces.ressourcemanagement.IRessourceTupleListGotter;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IBuildableBitmapTextureAtlasRessourceInfo;
import com.bitarcher.ressourcemanagement.MapValues.BuildableBitmapTextureAtlasMapValue;
import com.bitarcher.ressourcemanagement.MapValues.MapValue;
import com.bitarcher.ressourcemanagement.MapValues.MapValueFactoryByRessourceTuple;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;

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

    HashMap<IRessourceTuple, MapValue> _map;


    public RessourceManager() {
        this._map = new HashMap<>();
    }

    @Override
    public void pushRequirement(IRessourceTuple ressourceTuple) throws ERessourceCreationError{
        boolean exists = this._map.containsKey(ressourceTuple);
        MapValue mapValue = null;

        if(exists)
        {
            mapValue = this._map.get(ressourceTuple);
        }
        else {
            MapValueFactoryByRessourceTuple factoryByRessourceTuple = new MapValueFactoryByRessourceTuple(this);
            mapValue = factoryByRessourceTuple.make(ressourceTuple);


            this._map.put(ressourceTuple, mapValue);
        }

        mapValue.ref();

    }

    @Override
    public void pushRequirement(IRessourceTupleListGotter ressourceTupleListGotter)  throws ERessourceCreationError {
        for(IRessourceTuple ressourceTuple : ressourceTupleListGotter.getRessourceTupleList())
        {
            this.pushRequirement(ressourceTuple);
        }

    }

    @Override
    public void popRequirement(IRessourceTuple ressourceTuple) throws ERessourceTupleNotFound {
        boolean exists = this._map.containsKey(ressourceTuple);

        if(!exists)
        {
            throw new ERessourceTupleNotFound(ressourceTuple.getType());
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
    public void popRequirement(IRessourceTupleListGotter ressourceTupleListGotter) throws ERessourceTupleNotFound{
        ArrayList<IRessourceTuple> copy = new ArrayList<>(ressourceTupleListGotter.getRessourceTupleList());

        Collections.reverse(copy);

        for(IRessourceTuple ressourceTuple : copy)
        {
            this.popRequirement(ressourceTuple);
        }
    }

    @Override
    public BuildableBitmapTextureAtlas getBuildableBitmapTextureAtlasRessourceInfo(IBuildableBitmapTextureAtlasRessourceInfo buildableBitmapTextureAtlasRessourceInfo) throws ERessourceTupleNotFound{
        boolean exists = this._map.containsKey(buildableBitmapTextureAtlasRessourceInfo);

        if(!exists)
        {
            throw new ERessourceTupleNotFound(ERessourceType.BuildableBitmapTextureAtlas);
        }

        MapValue mapValue = this._map.get(buildableBitmapTextureAtlasRessourceInfo);

        BuildableBitmapTextureAtlas retval = ((BuildableBitmapTextureAtlasMapValue) mapValue).getTValue();

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
