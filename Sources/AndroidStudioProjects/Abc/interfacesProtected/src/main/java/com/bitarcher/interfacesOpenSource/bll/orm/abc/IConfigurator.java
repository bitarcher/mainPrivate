/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfacesOpenSource.bll.orm.abc;

import com.bitarcher.interfacesOpenSource.bll.xml.abc.ro.levels.INode;
import com.bitarcher.interfacesOpenSource.bll.xml.abc.ro.resources.IAnimal;

/**
 * Created by michel on 13/02/15.
 */
public interface IConfigurator {
    INode getLevelNodeByLevelPath(String levelPath);
    IAnimal getAnimalByName(String animalName);
}
