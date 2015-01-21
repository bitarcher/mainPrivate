package com.bitarcher.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.IResourceInfoListGotter;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IResourceInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by michel on 08/01/15.
 */
public class SimpleResourceInfoListGotter implements IResourceInfoListGotter {
    ArrayList<IResourceInfo> _ressourceTupleList;

    public SimpleResourceInfoListGotter() {
        this._ressourceTupleList = new ArrayList<IResourceInfo>();
    }

    public void addRessourceInfo(IResourceInfo ressourceTuple)
    {
        this._ressourceTupleList.add(ressourceTuple);
    }

    @Override
    public List<IResourceInfo> getRessourceInfoList() {
        return this._ressourceTupleList;
    }
}
