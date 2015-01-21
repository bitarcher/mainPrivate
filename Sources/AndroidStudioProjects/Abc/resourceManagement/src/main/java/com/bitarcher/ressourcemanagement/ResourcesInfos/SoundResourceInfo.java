package com.bitarcher.ressourcemanagement.ResourcesInfos;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ISoundResourceInfo;

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
