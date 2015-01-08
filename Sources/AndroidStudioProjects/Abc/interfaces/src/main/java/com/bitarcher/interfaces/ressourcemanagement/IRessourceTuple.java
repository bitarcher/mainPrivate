package com.bitarcher.interfaces.ressourcemanagement;

import com.bitarcher.interfaces.ressourcemanagement.RessourceInfo.IRessourceInfo;

public interface IRessourceTuple {
    ERessourceType getType();
    IRessourceInfo getRessourceInfo();
}