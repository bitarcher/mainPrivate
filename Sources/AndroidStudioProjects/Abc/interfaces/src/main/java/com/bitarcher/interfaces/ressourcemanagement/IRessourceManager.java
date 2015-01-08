package com.bitarcher.interfaces.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IBuildableBitmapTextureAtlasRessourceInfo;

/**
 * Created by michel on 07/01/15.
 */
public interface IRessourceManager {
    void pushRequirement(IRessourceTuple ressourceTuple);
    void pushRequirement(IRessourceTupleListGotter ressourceTupleListGotter);

    void popRequirement(IRessourceTuple ressourceTuple);
    void popRequirement(IRessourceTupleListGotter ressourceTupleListGotter);

    org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas getBuildableBitmapTextureAtlasRessourceInfo(IBuildableBitmapTextureAtlasRessourceInfo buildableBitmapTextureAtlasRessourceInfo);
}
