package com.bitarcher.interfaces.ressourcemanagement.RessourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public interface IBuildableBitmapTextureAtlasRessourceInfo extends IRessourceInfo{
    org.andengine.opengl.texture.TextureManager getTextureManager();
    int getPWidth();
    int getPHeight();
}
