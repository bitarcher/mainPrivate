package com.bitarcher.resourcemanagement.ResourcesInfos.SubInfos;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneAssetTexture;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.SubInfos.IOneTexture;

/**
 * Created by michel on 10/01/15.
 */
public abstract class OneAssetTexture extends OneTexture implements IOneAssetTexture {

    String filename;


    @Override
    public String getFilename() {
        return this.filename;
    }

    public OneAssetTexture(String name, String filename) {
        super(name);
        this.filename = filename;
    }
}
