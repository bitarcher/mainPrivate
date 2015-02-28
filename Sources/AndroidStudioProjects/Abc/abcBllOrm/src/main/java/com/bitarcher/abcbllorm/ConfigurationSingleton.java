/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abcbllorm;

import com.bitarcher.abcbllorm.DAL.Daos;
import com.bitarcher.interfacesProtected.bll.orm.abc.IConfigurator;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by michel on 13/02/15.
 */
public class ConfigurationSingleton {
    private static ConfigurationSingleton ourInstance = new ConfigurationSingleton();

    public static ConfigurationSingleton getInstance() {
        return ourInstance;
    }

    private ConfigurationSingleton() {
    }

    IConfigurator configurator;
    Daos daos;

    public void setConfigurator(IConfigurator configurator)
    {
        this.configurator = configurator;
    }

    public IConfigurator getConfigurator() {
        return configurator;
    }

    public void loadDaos(ConnectionSource connectionSource) throws SQLException {
        this.daos = new Daos(connectionSource);
    }

    public Daos getDaos()
    {
        return this.daos;
    }
}
