/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfacesProtected.bll.orm.abc;

/**
 * Created by michel on 13/02/15.
 */
public enum EnumScore {
    ZeroStar(0),
    OneStar(1),
    TwoStars(2),
    TreeStars(3);

    final int numOfStars;

    public int getNumOfStars()
    {
        return this.numOfStars;
    }

    EnumScore(int numOfStars)
    {
        this.numOfStars = numOfStars;
    }
}

