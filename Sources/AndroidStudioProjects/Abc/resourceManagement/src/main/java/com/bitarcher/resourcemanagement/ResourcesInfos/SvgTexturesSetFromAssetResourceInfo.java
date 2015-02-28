package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ISvgTexturesSetFromAssetResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.SubInfos.IOneAssetSvgTexture;

/**
 * Created by michel on 13/01/15.
 */
public class SvgTexturesSetFromAssetResourceInfo extends TexturesSetFromAssetResourceInfo<IOneAssetSvgTexture> implements ISvgTexturesSetFromAssetResourceInfo {
    public SvgTexturesSetFromAssetResourceInfo(String name, int atlasWidth, int atlasHeight, String assetsBase) {
        super(name, atlasWidth, atlasHeight, assetsBase);
    }
}
