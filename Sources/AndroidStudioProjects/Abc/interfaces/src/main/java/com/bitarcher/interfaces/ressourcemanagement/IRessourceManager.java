package com.bitarcher.interfaces.ressourcemanagement;

import android.content.Context;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IBuildableBitmapTextureAtlasRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.ITexturesSetRessourceInfo;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 07/01/15.
 */
public interface IRessourceManager {
    Engine getEngine();
    Context getContext();
    float getCameraWidth();
    float getCameraHeight();
    float getCameraScaleX();
    float getCameraScaleY();

    void setup(final Engine pEngine, final Context pContext, final float pCameraWidth, final float pCameraHeight, final float pCameraScaleX, final float pCameraScaleY);

    void pushRequirement(IRessourceInfo ressourceTuple) throws ERessourceCreationError;
    void pushRequirement(IRessourceInfoListGotter ressourceTupleListGotter) throws ERessourceCreationError;

    void popRequirement(IRessourceInfo ressourceTuple) throws ERessourceNotFound;

    // popped in reversed order so you can managed dependances between ressources
    void popRequirement(IRessourceInfoListGotter ressourceTupleListGotter) throws ERessourceNotFound;

    org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas getBuildableBitmapTextureAtlas(IBuildableBitmapTextureAtlasRessourceInfo buildableBitmapTextureAtlasInfo) throws ERessourceNotFound;
    ITextureRegion getTextureRegionFromTextureSetByNames(ITexturesSetRessourceInfo textureSetRessourceInfo, String textureName) throws ERessourceNotFound;
}
