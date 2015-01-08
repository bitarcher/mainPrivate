package com.bitarcher.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.IRessourceTuple;
import com.bitarcher.interfaces.ressourcemanagement.IRessourceTupleListGotter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by michel on 08/01/15.
 */
public class SimpleRessourceTupleListGotter implements IRessourceTupleListGotter {
    ArrayList<IRessourceTuple> _ressourceTupleList;

    public SimpleRessourceTupleListGotter() {
        this._ressourceTupleList = new ArrayList<IRessourceTuple>();
    }

    public void addRessourceTuple(IRessourceTuple ressourceTuple)
    {
        this._ressourceTupleList.add(ressourceTuple);
    }

    @Override
    public List<IRessourceTuple> getRessourceTupleList() {
        return this._ressourceTupleList;
    }
}
