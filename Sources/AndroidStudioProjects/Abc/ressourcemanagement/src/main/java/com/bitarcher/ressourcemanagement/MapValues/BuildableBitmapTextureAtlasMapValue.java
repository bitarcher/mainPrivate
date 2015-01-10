package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IBuildableBitmapTextureAtlasRessourceInfo;
import com.bitarcher.ressourcemanagement.RessourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;

/**
 * Created by michel on 08/01/15.
 */
public class BuildableBitmapTextureAtlasMapValue extends TMapValue<BuildableBitmapTextureAtlas> {

    public BuildableBitmapTextureAtlasMapValue(RessourceManager ressourceManager, IBuildableBitmapTextureAtlasRessourceInfo buildableBitmapTextureAtlasRessourceInfo) {
        this._tObj = new BuildableBitmapTextureAtlas(ressourceManager.getEngine().getTextureManager(), buildableBitmapTextureAtlasRessourceInfo.getPWidth(), buildableBitmapTextureAtlasRessourceInfo.getPHeight());
    }

    @Override
    public void clean() {
        this._tObj = null;
    }
}
