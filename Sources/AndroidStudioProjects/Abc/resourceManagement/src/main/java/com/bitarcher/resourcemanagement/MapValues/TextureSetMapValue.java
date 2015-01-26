/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.resourcemanagement.MapValues;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneTexture;
import com.bitarcher.resourcemanagement.MapValues.SubValues.ITextureSetMapValue;
import com.bitarcher.resourcemanagement.MapValues.SubValues.OneTextureSV;
import com.bitarcher.resourcemanagement.ResourceManager;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.debug.Debug;

import java.util.HashMap;

/**
 * Created by michel on 26/01/15.
 */
public abstract class TextureSetMapValue
    <TTexturesSetResourceInfo extends ITexturesSetResourceInfo<TOneTextureResourceInfo>,
            TOneTextureResourceInfo extends IOneTexture,
            TOneTextureSV extends OneTextureSV<TOneTextureResourceInfo>
            >
    extends MapValue
    implements ITextureSetMapValue

    {
        BuildableBitmapTextureAtlas texture;
        HashMap<String, TOneTextureSV> hashMap;

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

    public TextureSetMapValue(ResourceManager resourceManager, TTexturesSetResourceInfo texturesSetResourceInfo) {
        this.hashMap = new HashMap<>();

        this.beforeLoadingTextures(resourceManager, texturesSetResourceInfo);

        BuildableBitmapTextureAtlas texture = new BuildableBitmapTextureAtlas(resourceManager.getEngine().getTextureManager(),
                texturesSetResourceInfo.getAtlasWidth(), texturesSetResourceInfo.getAtlasHeight());

        for(TOneTextureResourceInfo oneTextureResourceInfo : texturesSetResourceInfo.getTextureList())
        {
            TOneTextureSV oneTextureMapValue = this.createOneTexture(resourceManager, oneTextureResourceInfo);

            this.hashMap.put(oneTextureResourceInfo.getName(), oneTextureMapValue);
        }


        try {
            texture.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 4));
            texture.load();
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Debug.e(e);
        }

        this.afterLoadingTextures(resourceManager, texturesSetResourceInfo);
    }

    protected void beforeLoadingTextures(ResourceManager resourceManager, TTexturesSetResourceInfo texturesSetResourceInfo)
    {

    }

    protected void afterLoadingTextures(ResourceManager resourceManager, TTexturesSetResourceInfo texturesSetResourceInfo)
    {

    }

    protected abstract TOneTextureSV createOneTexture(IResourceManager resourceManager, TOneTextureResourceInfo oneTextureResourceInfo);

    public ITextureRegion getTextureRegionByName(String name) {
        return this.hashMap.get(name).getTextureRegion();
    }
}
