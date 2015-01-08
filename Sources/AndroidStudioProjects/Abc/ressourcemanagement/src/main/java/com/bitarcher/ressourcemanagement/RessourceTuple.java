package com.bitarcher.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.ERessourceType;
import com.bitarcher.interfaces.ressourcemanagement.IRessourceTuple;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;

import java.util.concurrent.Callable;

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

    @Override
    public int hashCode()
    {
        return this._ressourceType.ordinal() + this._ressourceInfo.getHashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean retval = true;

        if(obj instanceof IRessourceTuple)
        {
            IRessourceTuple tuple = (IRessourceTuple)obj;

            retval &= tuple.getType() == this.getType();

            if(retval)
            {
                retval &= this._ressourceInfo.isSimilar(tuple.getRessourceInfo());
            }
        }
        else
        {
            retval = false;
        }

        return retval;
    }


}
