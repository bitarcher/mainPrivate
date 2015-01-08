package com.bitarcher.interfaces.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.IRessourceTuple;

/**
 * Created by michel on 08/01/15.
 */
public class ERessourceTupleNotFound extends Exception {
    public ERessourceTupleNotFound(ERessourceType ressourceType) {
        super(String.format("Ressource tuple of type %s not found", ressourceType.toString()));
    }
}
