package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.IMusicResourceInfo;

/**
 * Created by michel on 12/01/15.
 */
public class MusicResourceInfo extends ResourceInfo implements IMusicResourceInfo {
    String assetPath;

    public MusicResourceInfo(String name, String assetPath) {
        super(name);
        this.assetPath = assetPath;
    }

    @Override
    public String getAssetPath() {
        return assetPath;
    }
}
