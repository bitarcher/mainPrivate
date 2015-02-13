/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.bll.xml.abc.orm;

import com.bitarcher.interfaces.basicioc.orm.IIdGotter;
import com.bitarcher.interfaces.bll.xml.abc.ro.resources.IAnimal;

/**
 * Created by michel on 13/02/15.
 */
public interface IPlayer extends IIdGotter {

    // scalar

    String getAnimalAvatarName();

    // orm links

    // Other

    IAnimal getAvatar();
}
