/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.interfaces.bll.xml.abc.orm;

/**
 * Created by michel on 13/02/15.
 */
public enum EnumScore {
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

