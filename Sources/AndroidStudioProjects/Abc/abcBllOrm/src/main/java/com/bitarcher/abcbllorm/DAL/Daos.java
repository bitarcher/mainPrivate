/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abcbllorm.DAL;

import com.bitarcher.abcbllorm.BLL.Player;
import com.bitarcher.abcbllorm.BLL.ScorePlayerLevel;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by michel on 13/02/15.
 */
public class Daos {

    Dao<Player, Integer> playerDao;
    Dao<ScorePlayerLevel, Integer> scorePlayerLevelDao;

    public Dao<Player, Integer> getPlayerDao() {
        return playerDao;
    }

    public Dao<ScorePlayerLevel, Integer> getScorePlayerLevelDao() {
        return scorePlayerLevelDao;
    }

    public Daos(ConnectionSource connectionSource) throws SQLException {
        this.playerDao = DaoManager.createDao(connectionSource, Player.class);
        this.scorePlayerLevelDao = DaoManager.createDao(connectionSource, ScorePlayerLevel.class);
    }
}
