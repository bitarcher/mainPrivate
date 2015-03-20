package com.bitarcher.aeFunExamplesShowRoom.resourceManagement;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.IResourceInfoListGotter;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.IResourceInfo;

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
    public List<IResourceInfo> getResourceInfoList() {
        return this._ressourceTupleList;
    }
}
