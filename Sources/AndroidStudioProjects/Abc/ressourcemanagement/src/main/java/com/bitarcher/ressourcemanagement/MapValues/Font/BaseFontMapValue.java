package com.bitarcher.ressourcemanagement.MapValues.Font;

import com.bitarcher.ressourcemanagement.MapValues.TMapValue;

import org.andengine.opengl.font.Font;

/**
 * Created by michel on 12/01/15.
 */
public abstract class BaseFontMapValue extends TMapValue<Font> {
    @Override
    public void clean() {
        if(this._tObj != null) {
            this._tObj.unload();
            this._tObj = null;
        }
    }
}
