package com.bitarcher.interfaces.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IResourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public class EResourceNotFound extends Exception {
    public EResourceNotFound(IResourceInfo resourceInfo) {
        super(String.format("Resource %s of type %s not found", resourceInfo.getName(), resourceInfo.getClass().toString()));
    }
}
