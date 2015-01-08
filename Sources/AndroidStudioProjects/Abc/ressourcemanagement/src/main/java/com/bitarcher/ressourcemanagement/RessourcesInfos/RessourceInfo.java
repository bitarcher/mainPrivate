package com.bitarcher.ressourcemanagement.RessourcesInfos;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;

/**
 * Created by michel on 08/01/15.
 */
public abstract class RessourceInfo  implements IRessourceInfo{
    @Override
    public abstract boolean isSimilar(IRessourceInfo ressourceInfo);

    @Override
    public abstract int getHashCode();
}
