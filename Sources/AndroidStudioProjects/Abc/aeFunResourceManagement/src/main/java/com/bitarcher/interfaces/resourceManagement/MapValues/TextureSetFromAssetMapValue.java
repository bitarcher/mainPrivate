package com.bitarcher.interfaces.resourceManagement.MapValues;

import com.bitarcher.interfaces.resourceManagement.MapValues.SubValues.ITextureSetMapValue;
import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.ITexturesSetFromAssetResourceInfo;
import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetTexture;
import com.bitarcher.interfaces.resourceManagement.MapValues.SubValues.OneTextureSV;
import com.bitarcher.interfaces.resourceManagement.ResourceManager;

import org.jetbrains.annotations.Nullable;

/**
 * Created by michel on 10/01/15.
 */
public abstract class TextureSetFromAssetMapValue<TTexturesSetFromAssetResourceInfo extends ITexturesSetFromAssetResourceInfo<TOneAssetTextureResourceInfo>,
        TOneAssetTextureResourceInfo extends IOneAssetTexture,
        TOneAssetTextureSV extends OneTextureSV<TOneAssetTextureResourceInfo>
        >
        extends TextureSetMapValue<TTexturesSetFromAssetResourceInfo, TOneAssetTextureResourceInfo, TOneAssetTextureSV>
        implements ITextureSetMapValue {

    String previousAssetBasePath = null;

    public TextureSetFromAssetMapValue(ResourceManager resourceManager, TTexturesSetFromAssetResourceInfo texturesSetResourceInfo) {
        super(resourceManager, texturesSetResourceInfo);

    }

    protected abstract void setAssetBase(String assetBase);

    @Nullable
    protected abstract String getAssetBase();

    protected void beforeLoadingTextures(ResourceManager resourceManager, TTexturesSetFromAssetResourceInfo texturesSetResourceInfo)
    {
        this.previousAssetBasePath = this.getAssetBase();
        // Set our game assets folder to "assets/gfx/game/"
        this.setAssetBase(texturesSetResourceInfo.getAssetsBase());

    }

    protected void afterLoadingTextures(ResourceManager resourceManager, TTexturesSetFromAssetResourceInfo texturesSetResourceInfo)
    {
        if(this.previousAssetBasePath != null) {
            // Revert the Asset Path.
            this.setAssetBase(this.previousAssetBasePath);
        }
    }
}
