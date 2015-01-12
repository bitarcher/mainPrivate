package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.basicioc.ITFactory;
import com.bitarcher.interfaces.ressourcemanagement.EResourceCreationError;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateFromAssetResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateFromTypeFaceResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateStrokeFromAssetResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontCreateStrokeFromTypeFaceResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBitmapAnimationResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBuildableBitmapTextureAtlasResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.ressourcemanagement.MapValues.Font.FontCreateFromAssetMapValue;
import com.bitarcher.ressourcemanagement.MapValues.Font.FontCreateFromTypeFaceMapValue;
import com.bitarcher.ressourcemanagement.MapValues.Font.FontCreateStrokeFromAssetMapValue;
import com.bitarcher.ressourcemanagement.MapValues.Font.FontCreateStrokeFromTypeFaceMapValue;
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
        else if(resourceInfo instanceof IBitmapAnimationResourceInfo)
        {
            BitmapAnimationMapValue bitmapAnimationMapValue = new BitmapAnimationMapValue(this.resourceManager, (IBitmapAnimationResourceInfo) resourceInfo);

            retval = bitmapAnimationMapValue;
        }
        else if(resourceInfo instanceof IFontCreateFromAssetResourceInfo) {
            retval = new FontCreateFromAssetMapValue(this.resourceManager, (IFontCreateFromAssetResourceInfo) resourceInfo);
        }
        else if(resourceInfo instanceof IFontCreateFromTypeFaceResourceInfo)
        {
            retval = new FontCreateFromTypeFaceMapValue(this.resourceManager, (IFontCreateFromTypeFaceResourceInfo) resourceInfo);
        }
        else if(resourceInfo instanceof IFontCreateStrokeFromAssetResourceInfo)
        {
            retval = new FontCreateStrokeFromAssetMapValue(this.resourceManager, (IFontCreateStrokeFromAssetResourceInfo) resourceInfo);
        }
        else if(resourceInfo instanceof IFontCreateStrokeFromTypeFaceResourceInfo)
        {
            retval = new FontCreateStrokeFromTypeFaceMapValue(this.resourceManager, (IFontCreateStrokeFromTypeFaceResourceInfo) resourceInfo);
        }
        else
        {
            throw new EResourceCreationError(String.format("Unsupported resource type %s", resourceInfo.getClass().getName().toString()));
        }

        return retval;
    }
}
