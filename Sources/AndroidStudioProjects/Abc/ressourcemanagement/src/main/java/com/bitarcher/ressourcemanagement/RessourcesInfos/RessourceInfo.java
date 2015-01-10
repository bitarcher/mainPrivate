package com.bitarcher.ressourcemanagement.RessourcesInfos;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.ITexturesSetRessourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public abstract class RessourceInfo  implements IRessourceInfo{
    String name;

    protected RessourceInfo(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public boolean isSimilar(IRessourceInfo ressourceInfo) {
        boolean retval = true;

        if(ressourceInfo instanceof ITexturesSetRessourceInfo)
        {
            retval &= this.name == ((ITexturesSetRessourceInfo) ressourceInfo).getName();
        }
        else
        {
            retval = false;
        }

        return retval;
    }

    @Override
    public int getHashCode() {
        return this.name.hashCode();
    }

}
