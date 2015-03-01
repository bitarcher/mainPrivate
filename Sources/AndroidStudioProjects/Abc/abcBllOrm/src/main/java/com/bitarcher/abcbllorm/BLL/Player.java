/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abcbllorm.BLL;

import com.bitarcher.abcbllorm.ConfigurationSingleton;
import com.bitarcher.aeFun.bll.orm.abc.IPlayer;
import com.bitarcher.aeFun.bll.orm.abc.IScorePlayerLevel;
import com.bitarcher.aeFun.bll.xml.abc.ro.resources.IAnimal;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by michel on 13/02/15.
 */

@DatabaseTable(tableName = "tPlayer")
public class Player extends OrmBasic implements IPlayer{

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

        IScorePlayerLevel retval = null;
        QueryBuilder<ScorePlayerLevel, Integer> qb = ConfigurationSingleton.getInstance().getDaos().getScorePlayerLevelDao().queryBuilder();

        Where where = qb.where();
        PreparedQuery<ScorePlayerLevel> preparedQuery = null;

        try {
            where.eq("levelPath", levelPath);
            where.and();
            where.eq("player_id", this.id);

            preparedQuery = qb.prepare();

            List<ScorePlayerLevel> list = ConfigurationSingleton.getInstance().getDaos().getScorePlayerLevelDao().query(preparedQuery);

            if(!list.isEmpty())
            {
                retval = list.get(0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retval;
    }
}

