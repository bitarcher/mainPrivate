package com.bitarcher.interfaces.ressourcemanagement;

import android.content.Context;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBuildableBitmapTextureAtlasResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ITexturesSetResourceInfo;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 07/01/15.
 */
public interface IResourceManager {
    Engine getEngine();
    Context getContext();
    float getCameraWidth();
    float getCameraHeight();
    float getCameraScaleX();
    float getCameraScaleY();

    void setup(final Engine pEngine, final Context pContext, final float pCameraWidth, final float pCameraHeight, final float pCameraScaleX, final float pCameraScaleY);

    void pushRequirement(IResourceInfo ressourceTuple) throws EResourceCreationError;
    void pushRequirement(IResourceInfoListGotter ressourceTupleListGotter) throws EResourceCreationError;

    void popRequirement(IResourceInfo ressourceTuple) throws EResourceNotFound;

    // popped in reversed order so you can managed dependances between ressources
    void popRequirement(IResourceInfoListGotter ressourceTupleListGotter) throws EResourceNotFound;

    org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas getBuildableBitmapTextureAtlas(IBuildableBitmapTextureAtlasResourceInfo buildableBitmapTextureAtlasInfo) throws EResourceNotFound;
    ITextureRegion getTextureRegionFromTextureSetByNames(ITexturesSetResourceInfo textureSetRessourceInfo, String textureName) throws EResourceNotFound;
}
