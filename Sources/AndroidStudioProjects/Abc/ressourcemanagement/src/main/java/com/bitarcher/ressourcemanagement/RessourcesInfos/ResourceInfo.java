package com.bitarcher.ressourcemanagement.RessourcesInfos;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ITexturesSetResourceInfo;

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

        if(ressourceInfo instanceof ITexturesSetResourceInfo)
        {
            retval &= this.name == ((ITexturesSetResourceInfo) ressourceInfo).getName();
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
