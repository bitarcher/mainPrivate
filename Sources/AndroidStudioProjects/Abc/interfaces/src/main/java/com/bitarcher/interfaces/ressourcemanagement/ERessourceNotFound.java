package com.bitarcher.interfaces.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public class ERessourceNotFound extends Exception {
    public ERessourceNotFound(IRessourceInfo ressourceInfo) {
        super(String.format("Ressource %s of type %s not found", ressourceInfo.getName(), ressourceInfo.getClass().toString()));
    }
}
