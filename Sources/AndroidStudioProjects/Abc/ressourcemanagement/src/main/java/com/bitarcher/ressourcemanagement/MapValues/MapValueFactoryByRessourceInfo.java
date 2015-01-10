package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.basicioc.ITFactory;
import com.bitarcher.interfaces.ressourcemanagement.ERessourceCreationError;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IBuildableBitmapTextureAtlasRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.ITexturesSetRessourceInfo;
import com.bitarcher.ressourcemanagement.RessourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;

/**
 * Created by michel on 08/01/15.
 */
public class MapValueFactoryByRessourceInfo implements ITFactory<MapValue, IRessourceInfo>{
    RessourceManager ressourceManager;

    public MapValueFactoryByRessourceInfo(RessourceManager ressourceManager) {
        this.ressourceManager = ressourceManager;
    }

    @Override
    public MapValue make(IRessourceInfo ressourceInfo)  throws ERessourceCreationError {
        MapValue retval = null;

        if (ressourceInfo instanceof IBuildableBitmapTextureAtlasRessourceInfo)
        {
            IBuildableBitmapTextureAtlasRessourceInfo buildableBitmapTextureAtlasRessourceInfo = (IBuildableBitmapTextureAtlasRessourceInfo) ressourceInfo;
            BuildableBitmapTextureAtlasMapValue buildableBitmapTextureAtlasMapValue = new BuildableBitmapTextureAtlasMapValue(this.ressourceManager,  buildableBitmapTextureAtlasRessourceInfo);
            retval = buildableBitmapTextureAtlasMapValue;
        }
        else if(ressourceInfo instanceof ITexturesSetRessourceInfo)
        {
            TextureSetMapValue textureSetMapValue = new TextureSetMapValue(this.ressourceManager, (ITexturesSetRessourceInfo) ressourceInfo);

            retval = textureSetMapValue;
        }
        else
        {
            throw new ERessourceCreationError(String.format("Unsupported ressource type %s", ressourceInfo.getClass().getName().toString()));
        }

        return retval;
    }
}
