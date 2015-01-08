package com.bitarcher.interfaces.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IBuildableBitmapTextureAtlasRessourceInfo;

/**
 * Created by michel on 07/01/15.
 */
public interface IRessourceManager {
    void pushRequirement(IRessourceTuple ressourceTuple) throws ERessourceCreationError;
    void pushRequirement(IRessourceTupleListGotter ressourceTupleListGotter) throws ERessourceCreationError;

    void popRequirement(IRessourceTuple ressourceTuple) throws ERessourceTupleNotFound;
    void popRequirement(IRessourceTupleListGotter ressourceTupleListGotter) throws ERessourceTupleNotFound;

    org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas getBuildableBitmapTextureAtlasRessourceInfo(IBuildableBitmapTextureAtlasRessourceInfo buildableBitmapTextureAtlasRessourceInfo) throws ERessourceTupleNotFound;
}
