package com.bitarcher.resourcemanagement.MapValues;

import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IBuildableBitmapTextureAtlasResourceInfo;
import com.bitarcher.resourcemanagement.ResourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;

/**
 * Created by michel on 08/01/15.
 */
public class BuildableBitmapTextureAtlasMapValue extends TMapValue<BuildableBitmapTextureAtlas> {

    public BuildableBitmapTextureAtlasMapValue(ResourceManager ressourceManager, IBuildableBitmapTextureAtlasResourceInfo buildableBitmapTextureAtlasRessourceInfo) {
        this._tObj = new BuildableBitmapTextureAtlas(ressourceManager.getEngine().getTextureManager(), buildableBitmapTextureAtlasRessourceInfo.getPWidth(), buildableBitmapTextureAtlasRessourceInfo.getPHeight());
    }

    @Override
    public void clean() {
        this._tObj = null;
    }
}
