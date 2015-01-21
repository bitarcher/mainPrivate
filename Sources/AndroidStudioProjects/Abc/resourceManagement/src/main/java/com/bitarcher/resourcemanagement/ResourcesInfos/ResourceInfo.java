package com.bitarcher.resourcemanagement.ResourcesInfos;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.IBitmapTexturesSetResourceInfo;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.IResourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public abstract class ResourceInfo implements IResourceInfo {
    String name;

    protected ResourceInfo(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public boolean isSimilar(IResourceInfo ressourceInfo) {
        boolean retval = true;

        if(ressourceInfo instanceof IBitmapTexturesSetResourceInfo)
        {
            retval &= this.name == ((IBitmapTexturesSetResourceInfo) ressourceInfo).getName();
        }
        else
        {
            retval = false;
        }

        return retval;
    }

    @Override
    public int getHashCode() {
        return this.name.hashCode();
    }

}
