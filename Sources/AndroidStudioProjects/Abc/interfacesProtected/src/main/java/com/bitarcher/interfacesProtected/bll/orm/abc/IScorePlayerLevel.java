/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfacesProtected.bll.orm.abc;

import com.bitarcher.interfacesProtected.basicioc.orm.IOrmBasic;
import com.bitarcher.interfacesProtected.bll.xml.abc.ro.levels.INode;

/**
 * Created by michel on 13/02/15.
 */
public interface IScorePlayerLevel extends IOrmBasic {
    // scalar
    String getLevelPath();
    int getScoreIntValue();
    void setScoreIntValue(int scoreIntValue);

    // orm links
    IPlayer getPlayer();

    // Other
    EnumScore getScore();
    INode getLevelNode();
}
