/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abc;

import com.bitarcher.interfacesProtected.bll.orm.abc.IConfigurator;
import com.bitarcher.interfacesProtected.bll.xml.abc.ro.levels.INode;
import com.bitarcher.interfacesProtected.bll.xml.abc.ro.resources.IAnimal;

/**
 * Created by michel on 13/02/15.
 */
public class OrmConfigurator implements IConfigurator {

    MainActivity mainActivity;

    public OrmConfigurator(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public INode getLevelNodeByLevelPath(String levelPath) {
        return null;
    }

    @Override
    public IAnimal getAnimalByName(String animalName) {
        return null;
    }
}
