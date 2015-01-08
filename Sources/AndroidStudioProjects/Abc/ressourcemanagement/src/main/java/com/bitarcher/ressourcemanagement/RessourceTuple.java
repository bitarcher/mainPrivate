package com.bitarcher.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.ERessourceType;
import com.bitarcher.interfaces.ressourcemanagement.IRessourceTuple;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public class RessourceTuple  implements IRessourceTuple
{
    ERessourceType _ressourceType;
    IRessourceInfo _ressourceInfo;

    public RessourceTuple(ERessourceType ressourceType, IRessourceInfo ressourceInfo) {
        this._ressourceType = ressourceType;
        this._ressourceInfo = ressourceInfo;
    }

    @Override
    public ERessourceType getType() {
        return this._ressourceType;
    }

    @Override
    public IRessourceInfo getRessourceInfo() {
        return this._ressourceInfo;
    }
}
