package com.bitarcher.aeFun.interfaces.gui.widgets.Containers.Other;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.geometry.ISize;

/**
 * Created by michel on 04/03/15.
 */
public interface ISizable extends ISize{
    void setSize(float width, float height);

    void setWidth(float width);
    void setHeight(float height);

}
