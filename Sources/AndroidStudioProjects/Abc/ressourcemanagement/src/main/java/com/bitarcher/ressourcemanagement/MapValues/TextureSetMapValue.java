package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBitmapTexturesSetResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneTexture;
import com.bitarcher.ressourcemanagement.MapValues.SubValues.OneTexture;
import com.bitarcher.ressourcemanagement.ResourceManager;

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
public abstract class TextureSetMapValue<TexturesSetResourceInfo extends ITexturesSetResourceInfo, TOneTexture extends OneTexture> extends MapValue{

    BuildableBitmapTextureAtlas texture;
    HashMap<String, TOneTexture> hashMap;

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

    public TextureSetMapValue(ResourceManager resourceManager, IBitmapTexturesSetResourceInfo texturesSetResourceInfo) {
        this.hashMap = new HashMap<>();

        String mPreviousAssetBasePath = BitmapTextureAtlasTextureRegionFactory.getAssetBasePath();
        // Set our game assets folder to "assets/gfx/game/"
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(texturesSetResourceInfo.getAssetsBase());


        BuildableBitmapTextureAtlas texture = new BuildableBitmapTextureAtlas(resourceManager.getEngine().getTextureManager(),
                texturesSetResourceInfo.getAtlasWidth(), texturesSetResourceInfo.getAtlasHeight());

        for(IOneTexture oneTextureResourceInfo : texturesSetResourceInfo.getTextureList())
        {
            OneTexture oneTextureMapValue = new OneTexture(resourceManager, this, oneTextureResourceInfo);

            this.hashMap.put(oneTextureResourceInfo.getName(), oneTextureMapValue);
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

    protected abstract TOneTexture getOneTexture()

    public ITextureRegion getTextureRegionByName(String name) {
        return this.hashMap.get(name).getTextureRegion();
    }
}
