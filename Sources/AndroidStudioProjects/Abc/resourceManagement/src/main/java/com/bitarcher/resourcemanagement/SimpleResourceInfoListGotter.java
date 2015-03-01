package com.bitarcher.resourcemanagement;

import com.bitarcher.interfacesOpenSource.resourcemanagement.IResourceInfoListGotter;
import com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.IResourceInfo;

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
