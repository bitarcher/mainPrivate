package com.bitarcher.abc.gameLevels;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.abc.MainMenu;
import com.bitarcher.abc.gameLevels.consonantAndVowel.HowManyConsonantInTheWordGameLevel;

/**
 * Created by michel on 12/05/15.
 */
public class NextLevelChooser {

    MainMenu mainMenu;

    public NextLevelChooser(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void showNextLevel()
    {
        HowManyConsonantInTheWordGameLevel howManyConsonantInTheWordGameLevel = new HowManyConsonantInTheWordGameLevel(this.mainMenu);

        this.mainMenu.getSceneManager().showScene(howManyConsonantInTheWordGameLevel);
    }
}
