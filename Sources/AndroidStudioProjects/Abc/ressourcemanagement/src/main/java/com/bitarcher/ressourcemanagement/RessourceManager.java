package com.bitarcher.ressourcemanagement;

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

import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import java.util.HashMap;

/**
 * Created by michel on 08/01/15.
 */
public class RessourceManager implements IRessourceManager {
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
            MapValueFactoryByRessourceTuple factoryByRessourceTuple = new MapValueFactoryByRessourceTuple();
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
        for(IRessourceTuple ressourceTuple : ressourceTupleListGotter.getRessourceTupleList())
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
}
