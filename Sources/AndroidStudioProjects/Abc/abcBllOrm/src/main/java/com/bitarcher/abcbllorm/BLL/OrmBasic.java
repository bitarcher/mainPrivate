/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abcbllorm.BLL;

import com.bitarcher.interfacesOpenSource.basicioc.orm.IOrmBasic;
import com.bitarcher.interfacesOpenSource.basicioc.orm.SqlRuntimeException;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

import java.sql.SQLException;

/**
 * Created by michel on 14/02/15.
 */
public abstract class OrmBasic extends BaseDaoEnabled implements IOrmBasic {

    @DatabaseField(generatedId = true)
    int id;

    @Override
    public int i_create() {
        int retval = 0;

        try {
            retval = super.create();
        } catch (SQLException e) {
            throw new SqlRuntimeException(e);
        }

        return retval;
    }

    @Override
    public int i_delete() {
        int retval = 0;

        try {
            retval = super.delete();
        } catch (SQLException e) {
            throw new SqlRuntimeException(e);
        }

        return retval;
    }

    @Override
    public Object i_extractId() {
        Object retval = 0;

        try {
            retval = super.extractId();
        } catch (SQLException e) {
            throw new SqlRuntimeException(e);
        }

        return retval;
    }

    @Override
    public int i_refresh() {
        int retval = 0;

        try {
            retval = super.refresh();
        } catch (SQLException e) {
            throw new SqlRuntimeException(e);
        }

        return retval;
    }

    @Override
    public int i_update() {
        int retval = 0;

        try {
            retval = super.update();
        } catch (SQLException e) {
            throw new SqlRuntimeException(e);
        }

        return retval;
    }

    @Override
    public int i_updateId(Object id) {
        int retval = 0;

        try {
            retval = super.updateId(id);
        } catch (SQLException e) {
            throw new SqlRuntimeException(e);
        }

        return retval;
    }
}
