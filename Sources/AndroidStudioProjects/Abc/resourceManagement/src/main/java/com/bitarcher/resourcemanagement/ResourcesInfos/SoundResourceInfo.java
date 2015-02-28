package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ISoundResourceInfo;

/**
 * Created by michel on 12/01/15.
 */
public class SoundResourceInfo extends ResourceInfo implements ISoundResourceInfo {

    String assetPath;

    public SoundResourceInfo(String name, String assetPath) {
        super(name);
        this.assetPath = assetPath;
    }

    @Override
    public String getAssetPath() {
        return assetPath;
    }
}
