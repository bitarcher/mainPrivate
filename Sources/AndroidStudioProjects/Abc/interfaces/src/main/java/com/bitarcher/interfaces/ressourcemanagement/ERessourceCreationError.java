package com.bitarcher.interfaces.ressourcemanagement;

/**
 * Created by michel on 08/01/15.
 */

// see http://stackoverflow.com/questions/15607060/java-interface-throw-an-exception-but-interface-implementation-does-not-throw-an
public class ERessourceCreationError extends RuntimeException {
    public ERessourceCreationError(String detailMessage) {
        super(detailMessage);
    }
}
