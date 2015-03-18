package com.bitarcher.aeFun.drawables.characters;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.drawables.characters.EnumMainPosition;
import com.bitarcher.aeFun.interfaces.drawables.characters.EnumSide;
import com.bitarcher.aeFun.interfaces.drawables.characters.ICharacter;
import com.bitarcher.aeFun.interfaces.drawables.characters.ISidedImage;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;


import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;

import java.util.Date;
import java.util.Queue;

/**
 * Created by michel on 18/03/15.
 */
public abstract class Character extends Entity implements ICharacter {
    String name;
    IResourceManager resourceManager;
    EnumSide currentSide;
    EnumMainPosition currentMainPosition;
    Sprite sprite;
    int counter = 0;

    public EnumSide getCurrentSide() {
        return currentSide;
    }

    public EnumMainPosition getCurrentMainPosition() {
        return currentMainPosition;
    }

    @Override
    public IResourceManager getResourceManager() {
        return this.resourceManager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Character(IResourceManager resourceManager, String name)
    {
        this.resourceManager = resourceManager;
        this.name = name;
    }

    @Override
    public void setMainPosition(EnumSide side, EnumMainPosition mainPosition) {
        if(side != this.currentSide || mainPosition != this.currentMainPosition)
        {
            this.onMainPositionChanged(side, mainPosition);

            this.currentSide = side;
            this.currentMainPosition = mainPosition;
            this.counter = 0;
        }
    }

    protected void onMainPositionChanged(EnumSide side, EnumMainPosition mainPosition)
    {

    }

    void onImageQueueEmpty()
    {

    }

    @Override
    public void start() {
        this.pushResourceRequirements();


        ITextureRegion textureRegion = this.resourceManager.getTextureRegionFromTextureSetByName(this.getInitialSidedImage().getTextureSetResourceInfo(), this.getInitialSidedImage().getTextureName());
        this.sprite = new Sprite(this.getWidth() / 2, this.getHeight() / 2, this.getWidth(), this.getHeight(), textureRegion,  this.resourceManager.getEngine().getVertexBufferObjectManager());
        this.attachChild(this.sprite);
    }

    protected abstract ISidedImage getInitialSidedImage();

    @Override
    public void stop() {
        this.popResourceRequirements();
    }

    @Override
    public void tic(Date dateTime) {

    }
}


