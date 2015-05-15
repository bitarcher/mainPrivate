package com.bitarcher.abc.gameLevels.consonantAndVowel;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import android.util.Log;

import com.bitarcher.abc.MainMenu;
import com.bitarcher.abc.gameLevels.common.GameLevelBase;
import com.bitarcher.abc.gameLevels.consonantAndVowel.vowel.IPresentationAnimationListener;
import com.bitarcher.abc.gameLevels.consonantAndVowel.vowel.PresentationAnimation;

import org.andengine.entity.modifier.FadeInModifier;
import org.andengine.entity.modifier.FadeOutModifier;

/**
 * Created by michel on 12/05/15.
 */
public class HowManyConsonantInTheWordGameLevel extends GameLevelBase implements IPresentationAnimationListener{

    PresentationAnimation presentationAnimation;
    boolean instructionRunning = true;

    @Override
    public void onPresentationStarted() {

    }

    @Override
    public void onPresentationFinished() {
        presentationAnimation.fadeOut(3);
        getDiamondZoneEntity().fadeIn(3);
        getGameLevelMenuEntity().fadeIn(3);

        Log.v("dk", "presentation finished");

        instructionRunning = false;
    }

    public HowManyConsonantInTheWordGameLevel(MainMenu mainMenu) {
        super(mainMenu, 0f);


        this.presentationAnimation = new PresentationAnimation(this);
        this.presentationAnimation.addPresentationAnimationListener(this);
    }

    @Override
    protected void repeatInstruction() {
        super.repeatInstruction();

        if(!this.instructionRunning)
        {

            getDiamondZoneEntity().fadeOut(0.2f);
            getGameLevelMenuEntity().fadeOut(0.2f);
            this.presentationAnimation.start();
        }
    }

    @Override
    public void onLoadManagedScene() {
        super.onLoadManagedScene();

        this.presentationAnimation.pushResourceRequirements();

        this.attachChild(this.presentationAnimation);

        getDiamondZoneEntity().fadeOut(0.2f);
        getGameLevelMenuEntity().fadeOut(0.2f);
    }

    @Override
    public void onShowScene() {
        super.onShowScene();

        this.presentationAnimation.start();
    }

    @Override
    public void onUnloadManagedScene() {
        super.onUnloadManagedScene();

        this.presentationAnimation.popResourceRequirements();
    }
}
