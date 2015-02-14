/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abcbllorm.BLL;

import com.bitarcher.abcbllorm.ConfigurationSingleton;
import com.bitarcher.interfaces.bll.orm.abc.EnumScore;
import com.bitarcher.interfaces.bll.orm.abc.IPlayer;
import com.bitarcher.interfaces.bll.orm.abc.IScorePlayerLevel;
import com.bitarcher.interfaces.bll.xml.abc.ro.levels.INode;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by michel on 13/02/15.
 */

@DatabaseTable(tableName = "tScorePlayerLevel")
public class ScorePlayerLevel  extends OrmBasic implements IScorePlayerLevel {

    @DatabaseField(canBeNull = false, indexName = "levelPath_player")
    String levelPath;

    @DatabaseField(canBeNull = false)
    int scoreIntValue;

    @DatabaseField(canBeNull = false, foreign = true, indexName = "levelPath_player")
    Player player;


    @Override
    public String getLevelPath() {
        return this.levelPath;
    }

    @Override
    public int getScoreIntValue() {
        return this.scoreIntValue;
    }

    @Override
    public void setScoreIntValue(int scoreIntValue) {
        this.scoreIntValue = scoreIntValue;
    }

    @Override
    public IPlayer getPlayer() {
        return this.player;
    }

    @Override
    public EnumScore getScore() {
        assert this.scoreIntValue <= 100;
        EnumScore retval = EnumScore.ZeroStar;

        if(this.scoreIntValue < 20)
        {
            retval = EnumScore.ZeroStar;
        }
        else if(this.scoreIntValue < 40)
        {
            retval = EnumScore.OneStar;
        }
        else if (this.scoreIntValue < 60)
        {
            retval = EnumScore.TwoStars;
        }
        else
        {
            retval = EnumScore.TreeStars;
        }

        return null;
    }

    @Override
    public INode getLevelNode() {
        return ConfigurationSingleton.getInstance().getConfigurator().getLevelNodeByLevelPath(this.levelPath);
    }

    @Override
    public int getId() {
        return this.id;
    }

    public ScorePlayerLevel() {
    }

    public ScorePlayerLevel(Player player, String levelPath, int scoreIntValue) {
        this.player = player;
        this.levelPath = levelPath;
        this.scoreIntValue = scoreIntValue;
    }
}
