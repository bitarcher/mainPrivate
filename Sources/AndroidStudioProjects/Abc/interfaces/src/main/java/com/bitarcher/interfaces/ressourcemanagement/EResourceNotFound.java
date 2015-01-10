package com.bitarcher.interfaces.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IResourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public class EResourceNotFound extends Exception {
    public EResourceNotFound(IResourceInfo ressourceInfo) {
        super(String.format("Ressource %s of type %s not found", ressourceInfo.getName(), ressourceInfo.getClass().toString()));
    }
}
