package com.bitarcher.interfaces.ressourcemanagement;

/**
 * Created by michel on 07/01/15.
 */
public interface IRessourceManager {
    void pushRequirement(IRessourceTuple ressourceTuple);
    void pushRequirement(IRessourceTupleListGotter ressourceTupleListGotter);

    void popRequirement(IRessourceTuple ressourceTuple);
    void popRequirement(IRessourceTupleListGotter ressourceTupleListGotter);


}
