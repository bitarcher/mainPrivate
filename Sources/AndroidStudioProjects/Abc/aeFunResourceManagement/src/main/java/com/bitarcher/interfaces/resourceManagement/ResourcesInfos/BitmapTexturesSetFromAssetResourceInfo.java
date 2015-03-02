package com.bitarcher.interfaces.resourceManagement.ResourcesInfos;

import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.IBitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.interfaces.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetBitmapTexture;

/**
 * Created by michel on 10/01/15.
 */
public class BitmapTexturesSetFromAssetResourceInfo extends TexturesSetFromAssetResourceInfo<IOneAssetBitmapTexture> implements IBitmapTexturesSetFromAssetResourceInfo {
    public BitmapTexturesSetFromAssetResourceInfo(String name, int atlasWidth, int atlasHeight, String assetsBase) {
        super(name, atlasWidth, atlasHeight, assetsBase);
    }
}
