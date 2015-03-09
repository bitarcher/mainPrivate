package com.bitarcher.aeFun.widgetToolkit.widget.context;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.geometry.ISize;
import com.bitarcher.aeFun.interfaces.gui.theme.context.ICommonContext;
import com.bitarcher.aeFun.interfaces.gui.theme.context.owner.EnumMouseEffect;

/**
 * Created by michel on 09/03/15.
 */
public class CommonContext implements ICommonContext{
    Float padding;
    Boolean enabled;


    @Override
    public Float getPadding() {
        return this.padding;
    }

    ISize size;

    @Override
    public Boolean isEnabled() {
        return this.enabled;
    }


    @Override
    public ISize getSize() {
        return this.size;
    }

    public CommonContext(Boolean enabled, ISize size, Float padding) {
        this.enabled = enabled;
        this.size = size;
        this.padding = padding;
    }
}
