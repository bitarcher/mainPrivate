package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.ITexturesSetFromAssetResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetTexture;

import java.util.ArrayList;
import java.util.List;

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
