package com.bitarcher.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.IRessourceInfoListGotter;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by michel on 08/01/15.
 */
public class SimpleRessourceInfoListGotter implements IRessourceInfoListGotter {
    ArrayList<IRessourceInfo> _ressourceTupleList;

    public SimpleRessourceInfoListGotter() {
        this._ressourceTupleList = new ArrayList<IRessourceInfo>();
    }

    public void addRessourceInfo(IRessourceInfo ressourceTuple)
    {
        this._ressourceTupleList.add(ressourceTuple);
    }

    @Override
    public List<IRessourceInfo> getRessourceInfoList() {
        return this._ressourceTupleList;
    }
}
