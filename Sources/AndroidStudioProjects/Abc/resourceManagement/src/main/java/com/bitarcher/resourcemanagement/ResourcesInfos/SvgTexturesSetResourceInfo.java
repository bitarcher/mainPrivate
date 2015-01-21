package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.ISvgTexturesSetResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneSvgTexture;

/**
 * Created by michel on 13/01/15.
 */
public class SvgTexturesSetResourceInfo extends TexturesSetResourceInfo<IOneSvgTexture> implements ISvgTexturesSetResourceInfo {
    public SvgTexturesSetResourceInfo(String name, int atlasWidth, int atlasHeight, String assetsBase) {
        super(name, atlasWidth, atlasHeight, assetsBase);
    }
}
