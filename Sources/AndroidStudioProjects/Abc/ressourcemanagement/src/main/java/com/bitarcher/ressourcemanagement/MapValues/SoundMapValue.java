package com.bitarcher.ressourcemanagement.MapValues;

import android.util.Log;

import com.bitarcher.interfaces.ressourcemanagement.IResourceManager;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ISoundResourceInfo;

import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;

import java.io.IOException;

/**
 * Created by michel on 12/01/15.
 */
public class SoundMapValue extends TMapValue<Sound> {

    IResourceManager resourceManager;

    public SoundMapValue(IResourceManager resourceManager, ISoundResourceInfo soundResourceInfo) {
        this.resourceManager = resourceManager;

        try {
            // Create the clickSound object via the SoundFactory class
            this._tObj	= SoundFactory.createSoundFromAsset(resourceManager.getEngine().getSoundManager(), resourceManager.getContext(), soundResourceInfo.getAssetPath());
        } catch (final IOException e) {
            Log.v("Sounds Load", "Exception:" + e.getMessage());
        }
    }

    @Override
    public void clean() {
        if(this._tObj!=null) {
            if (this._tObj.isLoaded()) {
                // Unload the clickSound object. Make sure to stop it first.
                this._tObj.stop();
                this.resourceManager.getEngine().getSoundManager().remove(this._tObj);
                this._tObj = null;
            }
        }
    }
}
