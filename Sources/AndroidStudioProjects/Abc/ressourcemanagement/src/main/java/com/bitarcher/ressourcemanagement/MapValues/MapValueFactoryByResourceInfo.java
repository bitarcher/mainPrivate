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
    ResourceManager resourceManager;

    public MapValueFactoryByResourceInfo(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    @Override
    public MapValue make(IResourceInfo resourceInfo)  throws EResourceCreationError {
        MapValue retval = null;

        if (resourceInfo instanceof IBuildableBitmapTextureAtlasResourceInfo)
        {
            IBuildableBitmapTextureAtlasResourceInfo buildableBitmapTextureAtlasResourceInfo = (IBuildableBitmapTextureAtlasResourceInfo) resourceInfo;
            BuildableBitmapTextureAtlasMapValue buildableBitmapTextureAtlasMapValue = new BuildableBitmapTextureAtlasMapValue(this.resourceManager,  buildableBitmapTextureAtlasResourceInfo);
            retval = buildableBitmapTextureAtlasMapValue;
        }
        else if(resourceInfo instanceof ITexturesSetResourceInfo)
        {
            TextureSetMapValue textureSetMapValue = new TextureSetMapValue(this.resourceManager, (ITexturesSetResourceInfo) resourceInfo);

            retval = textureSetMapValue;
        }
        else
        {
            throw new EResourceCreationError(String.format("Unsupported ressource type %s", resourceInfo.getClass().getName().toString()));
        }

        return retval;
    }
}
