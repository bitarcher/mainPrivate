package com.bitarcher.interfaces.ressourcemanagement.ResourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public interface IResourceInfo {
    String getName();
    boolean isSimilar(IResourceInfo ressourceInfo);
    int getHashCode();
}
