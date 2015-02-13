/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abcbllorm.BLL;

import com.bitarcher.abcbllorm.ConfigurationSingleton;
import com.bitarcher.interfaces.bll.orm.IPlayer;
import com.bitarcher.interfaces.bll.orm.IScorePlayerLevel;
import com.bitarcher.interfaces.bll.xml.abc.ro.resources.IAnimal;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by michel on 13/02/15.
 */

@DatabaseTable(tableName = "tPlayer")
public class Player extends BaseDaoEnabled implements IPlayer{

    @DatabaseField(generatedId = true)
    int id;


    @DatabaseField(canBeNull = false)
    String animalAvatarName;

    @Override
    public String getAnimalAvatarName() {
        return this.animalAvatarName;
    }

    @Override
    public IAnimal getAvatar() {
        return ConfigurationSingleton.getInstance().getConfigurator().getAnimalByName(this.animalAvatarName);
    }

    @Override
    public int getId() {
        return this.id;
    }

    public Player()
    {
    }

    public Player(String animalAvatarName) {
        this.animalAvatarName = animalAvatarName;
    }


    @Override
    public IScorePlayerLevel getScoreByLevel(String levelPath) {
        return null;
    }

}

