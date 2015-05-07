package com.bitarcher.abc.gameLevels.common;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 07/05/15.
 */
public interface IGameLevelMenuEntityListener {
    void onGoBackToMenuClicked(GameLevelMenuEntity gameLevelMenuEntity);
    void onRepeatInstructionClicked(GameLevelMenuEntity gameLevelMenuEntity);
}
