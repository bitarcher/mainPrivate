package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.ITexturesSetRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.SubInfos.IOneTexture;
import com.bitarcher.ressourcemanagement.MapValues.SubValues.OneTexture;
import com.bitarcher.ressourcemanagement.RessourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.debug.Debug;

import java.util.HashMap;

/**
 * Created by michel on 10/01/15.
 */
public class TextureSetMapValue extends MapValue{

    BuildableBitmapTextureAtlas texture;
    HashMap<String, OneTexture> hashMap;

    public BuildableBitmapTextureAtlas getTexture()
    {
        return this.texture;
    }

    @Override
    public void clean() {
        if(texture != null)
        {
            if(texture.isLoadedToHardware())
            {
                texture.unload();
            }
        }
        this.hashMap.clear();
    }

    public TextureSetMapValue(RessourceManager ressourceManager, ITexturesSetRessourceInfo texturesSetRessourceInfo) {
        this.hashMap = new HashMap<>();

        String mPreviousAssetBasePath = BitmapTextureAtlasTextureRegionFactory.getAssetBasePath();
        // Set our game assets folder to "assets/gfx/game/"
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(texturesSetRessourceInfo.getAssetsBase());


        BuildableBitmapTextureAtlas texture = new BuildableBitmapTextureAtlas(ressourceManager.getEngine().getTextureManager(), 11, 490);

        for(IOneTexture oneTextureRessourceInfo : texturesSetRessourceInfo.getTextureList())
        {
            OneTexture oneTextureMapValue = new OneTexture(ressourceManager, this, oneTextureRessourceInfo);

            this.hashMap.put(oneTextureRessourceInfo.getName(), oneTextureMapValue);
        }


        try {
            texture.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 4));
            texture.load();
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Debug.e(e);
        }


        // Revert the Asset Path.
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(mPreviousAssetBasePath);
    }

    public ITextureRegion getTextureRegionByName(String name) {
        return this.hashMap.get(name).getTextureRegion();
    }
}
