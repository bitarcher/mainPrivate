package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.basicioc.ITFactory;
import com.bitarcher.interfaces.ressourcemanagement.ERessourceCreationError;
import com.bitarcher.interfaces.ressourcemanagement.IRessourceTuple;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IBuildableBitmapTextureAtlasRessourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public class MapValueFactoryByRessourceTuple implements ITFactory<MapValue, IRessourceTuple>{
    @Override
    public MapValue make(IRessourceTuple ressourceTuple)  throws ERessourceCreationError {
        MapValue retval = null;

        switch (ressourceTuple.getType()) {
            case BuildableBitmapTextureAtlas:
                IBuildableBitmapTextureAtlasRessourceInfo buildableBitmapTextureAtlasRessourceInfo = (IBuildableBitmapTextureAtlasRessourceInfo) ressourceTuple.getRessourceInfo();
                BuildableBitmapTextureAtlasMapValue buildableBitmapTextureAtlasMapValue = new BuildableBitmapTextureAtlasMapValue(buildableBitmapTextureAtlasRessourceInfo);
                retval = buildableBitmapTextureAtlasMapValue;

                break;
            default:
                throw new ERessourceCreationError(String.format("Unsuported ressource type %s", ressourceTuple.getType().toString()));

        }

        return retval;
    }
}
