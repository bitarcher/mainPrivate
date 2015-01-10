package com.bitarcher.interfaces.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.IRessourceTuple;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public class ERessourceNotFound extends Exception {
    public ERessourceNotFound(IRessourceTuple ressourceTuple) {
        super(String.format("Ressource %s of type %s not found", ressourceTuple.getRessourceInfo().getName(), ressourceTuple.getType().toString()));
    }
}
