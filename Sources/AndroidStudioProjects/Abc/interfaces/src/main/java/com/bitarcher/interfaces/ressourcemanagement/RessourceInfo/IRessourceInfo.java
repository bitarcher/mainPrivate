package com.bitarcher.interfaces.ressourcemanagement.RessourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public interface IRessourceInfo {
    String getName();
    boolean isSimilar(IRessourceInfo ressourceInfo);
    int getHashCode();
}
