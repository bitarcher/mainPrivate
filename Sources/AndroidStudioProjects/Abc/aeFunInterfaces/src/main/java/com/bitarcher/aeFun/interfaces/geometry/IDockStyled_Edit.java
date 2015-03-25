package com.bitarcher.aeFun.interfaces.geometry;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 25/03/15.
 */
public interface IDockStyled_Edit extends IDockStyled {
    void setDockStyle(EnumDockStyle dockStyle);

    void addDockStyledListener(IDockStyledListener dockStyledListener);
    void removeDockStyledListener(IDockStyledListener dockStyledListener);
}
