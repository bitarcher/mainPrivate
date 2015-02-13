/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.bll.xml.abc.orm;

import com.bitarcher.interfaces.basicioc.orm.IIdGotter;
import com.bitarcher.interfaces.bll.xml.abc.ro.levels.INode;

/**
 * Created by michel on 13/02/15.
 */
public interface IScorePlayerLevel extends IIdGotter {
    // scalar
    int getPlayerId();
    String getLevelPath();
    int getScoreIntValue();

    // orm links
    IPlayer getPlayer();

    // Other
    EnumScore getScore();
    INode getLevelNode();
}
