package com.bitarcher.interfaces.resourcemanagement;

import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.IResourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public class EResourceNotFound extends RuntimeException {
    public EResourceNotFound(IResourceInfo resourceInfo) {
        super(String.format("Resource %s of type %s not found", resourceInfo.getName(), resourceInfo.getClass().toString()));
    }
}
