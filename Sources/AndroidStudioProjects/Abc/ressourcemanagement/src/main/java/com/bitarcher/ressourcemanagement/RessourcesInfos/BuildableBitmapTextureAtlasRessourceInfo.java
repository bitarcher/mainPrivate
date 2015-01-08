package com.bitarcher.ressourcemanagement.RessourcesInfos;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IBuildableBitmapTextureAtlasRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;

import org.andengine.opengl.texture.TextureManager;

/**
 * Created by michel on 08/01/15.
 */
public class BuildableBitmapTextureAtlasRessourceInfo extends RessourceInfo implements IBuildableBitmapTextureAtlasRessourceInfo {

    TextureManager _textureManager;
    int _pWidth;
    int _pHeight;
    String _name;

    public BuildableBitmapTextureAtlasRessourceInfo(TextureManager textureManager, int pWidth, int pHeight, String name) {
        this._textureManager = textureManager;
        this._pWidth = pWidth;
        this._pHeight = pHeight;
        this._name = name;
    }

    @Override
    public TextureManager getTextureManager() {
        return this._textureManager;
    }

    @Override
    public int getPWidth() {
        return this._pWidth;
    }

    @Override
    public int getPHeight() {
        return this._pHeight;
    }

    @Override
    public String getName() {
        return this._name;
    }

    @Override
    public boolean isSimilar(IRessourceInfo ressourceInfo) {
        boolean retval = true;

        if(ressourceInfo instanceof IBuildableBitmapTextureAtlasRessourceInfo) {
            retval &= this._name == ((IBuildableBitmapTextureAtlasRessourceInfo) ressourceInfo).getName();
            retval &= this._pHeight == ((IBuildableBitmapTextureAtlasRessourceInfo) ressourceInfo).getPHeight();
            retval &= this._pWidth == ((IBuildableBitmapTextureAtlasRessourceInfo) ressourceInfo).getPWidth();
        }
        else {
            retval =false;
        }
        return retval;
    }

    @Override
    public int getHashCode() {
        return this._pHeight + this._pWidth + this._name.hashCode();
    }


}
