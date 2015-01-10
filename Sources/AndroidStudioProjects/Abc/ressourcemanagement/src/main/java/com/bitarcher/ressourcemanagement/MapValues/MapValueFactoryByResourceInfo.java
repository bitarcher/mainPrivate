package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.basicioc.ITFactory;
import com.bitarcher.interfaces.ressourcemanagement.EResourceCreationError;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBuildableBitmapTextureAtlasResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.ressourcemanagement.ResourceManager;

/**
 * Created by michel on 08/01/15.
 */
public class MapValueFactoryByResourceInfo implements ITFactory<MapValue, IResourceInfo>{
    ResourceManager ressourceManager;

    public MapValueFactoryByResourceInfo(ResourceManager ressourceManager) {
        this.ressourceManager = ressourceManager;
    }

    @Override
    public MapValue make(IResourceInfo ressourceInfo)  throws EResourceCreationError {
        MapValue retval = null;

        if (ressourceInfo instanceof IBuildableBitmapTextureAtlasResourceInfo)
        {
            IBuildableBitmapTextureAtlasResourceInfo buildableBitmapTextureAtlasRessourceInfo = (IBuildableBitmapTextureAtlasResourceInfo) ressourceInfo;
            BuildableBitmapTextureAtlasMapValue buildableBitmapTextureAtlasMapValue = new BuildableBitmapTextureAtlasMapValue(this.ressourceManager,  buildableBitmapTextureAtlasRessourceInfo);
            retval = buildableBitmapTextureAtlasMapValue;
        }
        else if(ressourceInfo instanceof ITexturesSetResourceInfo)
        {
            TextureSetMapValue textureSetMapValue = new TextureSetMapValue(this.ressourceManager, (ITexturesSetResourceInfo) ressourceInfo);

            retval = textureSetMapValue;
        }
        else
        {
            throw new EResourceCreationError(String.format("Unsupported ressource type %s", ressourceInfo.getClass().getName().toString()));
        }

        return retval;
    }
}
