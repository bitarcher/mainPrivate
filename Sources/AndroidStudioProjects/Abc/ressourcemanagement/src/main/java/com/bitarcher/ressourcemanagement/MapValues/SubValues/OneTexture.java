package com.bitarcher.ressourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.SubInfos.IOneTexture;
import com.bitarcher.ressourcemanagement.MapValues.TextureSetMapValue;
import com.bitarcher.ressourcemanagement.RessourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 10/01/15.
 */
public class OneTexture {
    RessourceManager ressourceManager;
    TextureSetMapValue textureSetMapValue;
    IOneTexture oneTextureRessourceInfo;
    ITextureRegion textureRegion;

    public RessourceManager getRessourceManager() {
        return ressourceManager;
    }

    public TextureSetMapValue getTextureSetMapValue() {
        return textureSetMapValue;
    }

    public IOneTexture getOneTextureRessourceInfo() {
        return oneTextureRessourceInfo;
    }

    public ITextureRegion getTextureRegion() {
        return textureRegion;
    }

    public OneTexture(RessourceManager ressourceManager, TextureSetMapValue textureSetMapValue, IOneTexture oneTextureRessourceInfo) {
        this.ressourceManager = ressourceManager;
        this.textureSetMapValue = textureSetMapValue;
        this.oneTextureRessourceInfo = oneTextureRessourceInfo;

        this.textureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(textureSetMapValue.getTexture(),
                ressourceManager.getContext(), oneTextureRessourceInfo.getFilename());
    }
}
