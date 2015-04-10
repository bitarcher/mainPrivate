/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abcbllorm.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bitarcher.abcbllorm.BLL.Player;
import com.bitarcher.abcbllorm.BLL.ScorePlayerLevel;
import com.bitarcher.abcbllorm.ConfigurationSingleton;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by michel on 13/02/15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    public DatabaseHelper(Context context)
    {
        super(context, "bitarcherAbc", null, 1);
    }

    /*public DatabaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }*/


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Player.class);
            TableUtils.createTable(connectionSource, ScorePlayerLevel.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ConfigurationSingleton.getInstance().loadDaos(connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
