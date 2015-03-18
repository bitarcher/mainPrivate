package com.bitarcher.aeFun.drawables.characters;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.drawables.characters.ICharacter;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;

import org.andengine.entity.Entity;

/**
 * Created by michel on 18/03/15.
 */
public abstract class Character extends Entity implements ICharacter {
    String name;
    IResourceManager resourceManager;

    @Override
    public IResourceManager getResourceManager() {
        return this.resourceManager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Character(IResourceManager resourceManager, String name) {
        this.resourceManager = resourceManager;
        this.name = name;
    }
}


