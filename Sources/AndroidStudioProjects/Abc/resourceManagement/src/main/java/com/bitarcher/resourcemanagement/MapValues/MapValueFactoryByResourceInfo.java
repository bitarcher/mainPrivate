package com.bitarcher.resourcemanagement.MapValues;

import com.bitarcher.interfacesProtected.basicioc.ITFactory;
import com.bitarcher.interfacesProtected.resourcemanagement.EResourceCreationError;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.Font.IFontCreateFromAssetResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.Font.IFontCreateFromTypeFaceResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.Font.IFontCreateStrokeFromAssetResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.Font.IFontCreateStrokeFromTypeFaceResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IBitmapAnimationResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IBitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IBitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IBuildableBitmapTextureAtlasResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IMusicResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ISoundResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ISvgAnimationResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ISvgTexturesSetFromAssetResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ISvgTexturesSetFromResIdsResourceInfo;
import com.bitarcher.resourcemanagement.MapValues.Font.FontCreateFromAssetMapValue;
import com.bitarcher.resourcemanagement.MapValues.Font.FontCreateFromTypeFaceMapValue;
import com.bitarcher.resourcemanagement.MapValues.Font.FontCreateStrokeFromAssetMapValue;
import com.bitarcher.resourcemanagement.MapValues.Font.FontCreateStrokeFromTypeFaceMapValue;
import com.bitarcher.resourcemanagement.ResourceManager;




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

        if(resourceInfo == null)
        {
            throw new NullPointerException("resourceInfo is null");
        }

        if (resourceInfo instanceof IBuildableBitmapTextureAtlasResourceInfo)
        {
            IBuildableBitmapTextureAtlasResourceInfo buildableBitmapTextureAtlasResourceInfo = (IBuildableBitmapTextureAtlasResourceInfo) resourceInfo;
            BuildableBitmapTextureAtlasMapValue buildableBitmapTextureAtlasMapValue = new BuildableBitmapTextureAtlasMapValue(this.resourceManager,  buildableBitmapTextureAtlasResourceInfo);
            retval = buildableBitmapTextureAtlasMapValue;
        }
        else if(resourceInfo instanceof IBitmapTexturesSetFromAssetResourceInfo)
        {
            BitmapTextureSetFromAssetMapValue textureSetMapValue = new BitmapTextureSetFromAssetMapValue(this.resourceManager, (IBitmapTexturesSetFromAssetResourceInfo) resourceInfo);

            retval = textureSetMapValue;
        }
        else if(resourceInfo instanceof ISvgTexturesSetFromAssetResourceInfo)
        {
            SvgTextureSetFromAssetMapValue textureSetMapValue = new SvgTextureSetFromAssetMapValue(this.resourceManager, (ISvgTexturesSetFromAssetResourceInfo) resourceInfo);

            retval = textureSetMapValue;
        }
        else if(resourceInfo instanceof IBitmapTexturesSetFromResIdsResourceInfo)
        {
            BitmapTextureSetFromResMapValue textureSetMapValue = new BitmapTextureSetFromResMapValue(this.resourceManager, (IBitmapTexturesSetFromResIdsResourceInfo) resourceInfo);

            retval = textureSetMapValue;
        }
        else if(resourceInfo instanceof ISvgTexturesSetFromResIdsResourceInfo)
        {
            SvgTextureSetFromResMapValue textureSetMapValue = new SvgTextureSetFromResMapValue(this.resourceManager, (ISvgTexturesSetFromResIdsResourceInfo) resourceInfo);

            retval = textureSetMapValue;
        }
        else if(resourceInfo instanceof IBitmapAnimationResourceInfo)
        {
            BitmapAnimationMapValue bitmapAnimationMapValue = new BitmapAnimationMapValue(this.resourceManager, (IBitmapAnimationResourceInfo) resourceInfo);

            retval = bitmapAnimationMapValue;
        }
        else if(resourceInfo instanceof ISvgAnimationResourceInfo)
        {
            SvgAnimationMapValue svgAnimationMapValue = new SvgAnimationMapValue(this.resourceManager, (ISvgAnimationResourceInfo) resourceInfo);

            retval = svgAnimationMapValue;
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
        else if(resourceInfo instanceof ISoundResourceInfo)
        {
            retval = new SoundMapValue(this.resourceManager, (ISoundResourceInfo) resourceInfo);
        }
        else if(resourceInfo instanceof IMusicResourceInfo)
        {
            retval = new MusicMapValue(this.resourceManager, (IMusicResourceInfo) resourceInfo);
        }
        else
        {
            throw new EResourceCreationError(String.format("Unsupported resource type %s", resourceInfo.getClass().getName().toString()));
        }

        return retval;
    }
}

