package com.bitarcher.interfaces.resourceManagement.ResourcesInfos;

import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.ITexturesSetFromAssetResourceInfo;
import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetTexture;

/**
 * Created by michel on 12/01/15.
 */
public class TexturesSetFromAssetResourceInfo<TOneAssetTexture extends IOneAssetTexture>  extends TexturesSetResourceInfo<TOneAssetTexture> implements ITexturesSetFromAssetResourceInfo<TOneAssetTexture> {

    String assetsBase;

    @Override
    public String getAssetsBase() {
        return this.assetsBase;
    }


    public TexturesSetFromAssetResourceInfo(String name, int atlasWidth, int atlasHeight, String assetsBase) {
        super(name, atlasWidth, atlasHeight);
        this.assetsBase = assetsBase;
    }
}
