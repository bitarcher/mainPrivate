/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfacesProtected.bll.orm.abc;

import com.bitarcher.interfacesProtected.basicioc.orm.IOrmBasic;
import com.bitarcher.interfacesProtected.bll.xml.abc.ro.resources.IAnimal;

/**
 * Created by michel on 13/02/15.
 */
public interface IPlayer extends IOrmBasic {

    // scalar

    String getAnimalAvatarName();

    // orm links

    // Other

    IAnimal getAvatar();

    IScorePlayerLevel getScoreByLevel(String levelPath);
}
