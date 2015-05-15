package com.bitarcher.abc.gameLevels.consonantAndVowel.vowel;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.abc.MainMenu;
import com.bitarcher.abc.commonResourceInfos.BlackBoardResourceInfoSingleton;
import com.bitarcher.abc.gameLevels.common.GameLevelBase;
import com.bitarcher.aeFun.geometry.Point;
import com.bitarcher.aeFun.interfaces.drawables.IFadable;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceInfoListGotter;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceRequirementsStackUser;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.speaker.AlternativeSpeeches;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.FadeInModifier;
import org.andengine.entity.modifier.FadeOutModifier;
import org.andengine.entity.modifier.IEntityModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.modifier.IModifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 13/05/15.
 */
public class PresentationAnimation extends Entity implements IResourceRequirementsStackUser, IResourceInfoListGotter, IFadable {

    ArrayList<IPresentationAnimationListener> presentationAnimationListeners = new ArrayList<>();
    boolean running = false;
    GameLevelBase gameLevelBase;
    Sprite[] vowelsSprite = new Sprite[6];
    Sprite blackBoardSprite;
    float numOfSecondsSinceStart = 0;
    float bbX = 40;
    float bbY = 40;
    float bbWidth = 800 - bbX * 2;
    float bbHeight = 480 - bbY * 2;
    boolean aSpoken = false;

    @Override
    public void fadeIn(float numOfSeconds) {
        for(IEntity childEntity : this.mChildren)
        {
            childEntity.registerEntityModifier(new FadeInModifier(numOfSeconds));
        }
    }

    @Override
    public void fadeOut(float numOfSeconds) {
        for(IEntity childEntity : this.mChildren)
        {
            childEntity.registerEntityModifier(new FadeOutModifier(numOfSeconds));
        }
    }


    public PresentationAnimation(GameLevelBase gameLevelBase) {
        this.gameLevelBase = gameLevelBase;
    }

    public GameLevelBase getGameLevelBase() {
        return gameLevelBase;
    }

    public void addPresentationAnimationListener(IPresentationAnimationListener presentationAnimationListener)
    {
        this.presentationAnimationListeners.add(presentationAnimationListener);
    }

    public void removePresentationAnimationListener(IPresentationAnimationListener presentationAnimationListener)
    {
        this.presentationAnimationListeners.remove(presentationAnimationListener);
    }

    @Override
    public void pushResourceRequirements() {
        this.gameLevelBase.getMainMenu().getSceneManager().getResourceManager().pushRequirement(this);
    }

    @Override
    public void popResourceRequirements() {
        this.gameLevelBase.getMainMenu().getSceneManager().getResourceManager().popRequirement(this);
    }

    @Override
    public List<IResourceInfo> getResourceInfoList() {
        ArrayList<IResourceInfo> retval = new ArrayList<>();

        retval.add(VowelsResourceInfosSingleton.getInstance().bitmapTexturesSetFromAssetResourceInfo);
        retval.add(BlackBoardResourceInfoSingleton.getInstance().getTwoLinesBlackboard());

        return retval;
    }

    Point getDestinationPoint(EnumVowel vowel)
    {
        Point retval = null;

        float firstLineHeight = bbY + bbHeight * 0.72f;
        float secondLineHeight = bbY + bbHeight * 0.3f;

        int column = vowel.ordinal() % 3;
        int row = vowel.ordinal() / 3;

        float y = row == 0 ? firstLineHeight : secondLineHeight;
        float x = bbX + 150 + column * bbWidth * 0.8f / 3;

        if(vowel == EnumVowel.y)
        {
            y -= bbHeight / 20f ;
        }

        retval = new Point(x, y);

        return retval;
    }

    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);

        if(this.running)
        {
            this.numOfSecondsSinceStart += pSecondsElapsed;

            if(this.numOfSecondsSinceStart > 2) {
                if (!this.aSpoken) {
                    this.registerMoveModifier(EnumVowel.a);
                    this.aSpoken = true;
                }
            }




        }
    }

    public void start()
    {
        this.aSpoken = false;
        this.running = true;

        for(IPresentationAnimationListener presentationAnimationListener : this.presentationAnimationListeners)
        {
            presentationAnimationListener.onPresentationStarted();
        }

        if(this.blackBoardSprite != null)
        {
            this.blackBoardSprite.detachSelf();
            this.blackBoardSprite.dispose();
            this.blackBoardSprite = null;
        }

        ITextureRegion blackBoardTextureRegion = this.gameLevelBase.getSceneManager().getResourceManager().getTextureRegionFromTextureSetByName(
                BlackBoardResourceInfoSingleton.getInstance().getTwoLinesBlackboard().getTextureSetResourceInfo(),
                BlackBoardResourceInfoSingleton.getInstance().getTwoLinesBlackboard().getTextureName());


        this.blackBoardSprite = new Sprite(bbX + bbWidth / 2f, bbY + bbHeight / 2f, bbWidth, bbHeight, blackBoardTextureRegion,
                this.gameLevelBase.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        this.blackBoardSprite.setAlpha(0);
        this.attachChild(this.blackBoardSprite);

        for(int i = 0 ; i < this.vowelsSprite.length; i++)
        {
            if(this.vowelsSprite[i] != null)
            {
                this.vowelsSprite[i].clearEntityModifiers();
                if(this.vowelsSprite[i].hasParent())
                {
                    this.vowelsSprite[i].detachSelf();
                }


                this.vowelsSprite[i].dispose();
                this.vowelsSprite[i] = null;
            }
        }


        for(EnumVowel enumVowel : EnumVowel.values())
        {
            ITextureRegion textureRegion = this.gameLevelBase.getMainMenu().getSceneManager().getResourceManager().getTextureRegionFromTextureSetByName(
                    VowelsResourceInfosSingleton.getInstance().bitmapTexturesSetFromAssetResourceInfo,
                    VowelsResourceInfosSingleton.getInstance().getVowel(enumVowel).getName()
            );

            float baseWH = 65f;

            float sw = baseWH;
            float sh = baseWH / 256f * textureRegion.getHeight();

            if(enumVowel == EnumVowel.y)
            {
                sh *= 1.5;
            }

            this.vowelsSprite[enumVowel.ordinal()] = new Sprite(0, 0, sw, sh, textureRegion,
                    this.gameLevelBase.getMainMenu().getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());



            this.attachChild(this.vowelsSprite[enumVowel.ordinal()]);
            this.vowelsSprite[enumVowel.ordinal()].setVisible(false);

        }


        AlternativeSpeeches alternativeSpeeches = new AlternativeSpeeches();
        alternativeSpeeches.addAlternativeSpeech("Les lettres");
        this.gameLevelBase.getMainMenu().getSpeaker().say(alternativeSpeeches);


        this.blackBoardSprite.registerEntityModifier(new FadeInModifier(2));
    }

    void registerMoveModifier(final EnumVowel enumVowel)
    {
        float numOfSeconds = 2f;

        AlternativeSpeeches alternativeSpeeches = new AlternativeSpeeches();
        VowelPronunciationFactory vowelPronunciationFactory = new VowelPronunciationFactory();
        alternativeSpeeches.addAlternativeSpeech(vowelPronunciationFactory.make(enumVowel));
        this.gameLevelBase.getMainMenu().getSpeaker().say(alternativeSpeeches);

        Point destinationPoint = this.getDestinationPoint(enumVowel);

        this.vowelsSprite[enumVowel.ordinal()].setVisible(true);
        this.vowelsSprite[enumVowel.ordinal()].registerEntityModifier(
                new MoveModifier(numOfSeconds, 0, 0, destinationPoint.getX(), destinationPoint.getY(), new IEntityModifier.IEntityModifierListener() {
                    @Override
                    public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {

                    }

                    @Override
                    public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {

                        if (enumVowel != EnumVowel.y) {
                            // not last vowel
                            registerMoveModifier(EnumVowel.values()[enumVowel.ordinal() + 1]);
                        }
                        else
                        {
                            AlternativeSpeeches alternativeSpeeches = new AlternativeSpeeches();
                            alternativeSpeeches.addAlternativeSpeech("sont des voyelles.");
                            gameLevelBase.getMainMenu().getSpeaker().say(alternativeSpeeches);


                            for(IPresentationAnimationListener presentationAnimationListener : presentationAnimationListeners)
                            {
                                presentationAnimationListener.onPresentationFinished();
                            }
                        }
                    }
                }));

    }
}
