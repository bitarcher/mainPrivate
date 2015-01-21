package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.IBitmapTexturesSetResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneBitmapTexture;

/**
 * Created by michel on 10/01/15.
 */
public class BitmapTexturesSetResourceInfo extends TexturesSetResourceInfo<IOneBitmapTexture> implements IBitmapTexturesSetResourceInfo {
    public BitmapTexturesSetResourceInfo(String name, int atlasWidth, int atlasHeight, String assetsBase) {
        super(name, atlasWidth, atlasHeight, assetsBase);
    }
}
