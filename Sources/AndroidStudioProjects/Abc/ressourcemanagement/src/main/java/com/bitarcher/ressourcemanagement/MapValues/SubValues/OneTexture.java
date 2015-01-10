package com.bitarcher.ressourcemanagement.MapValues.SubValues;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneTexture;
import com.bitarcher.ressourcemanagement.MapValues.TextureSetMapValue;
import com.bitarcher.ressourcemanagement.ResourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 10/01/15.
 */
public class OneTexture {
    ResourceManager ressourceManager;
    TextureSetMapValue textureSetMapValue;
    IOneTexture oneTextureRessourceInfo;
    ITextureRegion textureRegion;

    public ResourceManager getRessourceManager() {
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

    public OneTexture(ResourceManager ressourceManager, TextureSetMapValue textureSetMapValue, IOneTexture oneTextureRessourceInfo) {
        this.ressourceManager = ressourceManager;
        this.textureSetMapValue = textureSetMapValue;
        this.oneTextureRessourceInfo = oneTextureRessourceInfo;

        this.textureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(textureSetMapValue.getTexture(),
                ressourceManager.getContext(), oneTextureRessourceInfo.getFilename());
    }
}
