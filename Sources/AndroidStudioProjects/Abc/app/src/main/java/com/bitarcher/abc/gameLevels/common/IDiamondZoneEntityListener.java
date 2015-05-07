package com.bitarcher.abc.gameLevels.common;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 07/05/15.
 */
public interface IDiamondZoneEntityListener {
    void onNumOfDiamondsChanged(DiamondZoneEntity diamondZoneEntity, int numOfDiamonds);
    void onReinit(DiamondZoneEntity diamondZoneEntity);
}
