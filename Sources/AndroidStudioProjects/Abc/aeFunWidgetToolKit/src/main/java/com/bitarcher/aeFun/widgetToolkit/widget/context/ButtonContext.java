package com.bitarcher.aeFun.widgetToolkit.widget.context;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.geometry.ISize;
import com.bitarcher.aeFun.interfaces.gui.theme.context.IButtonContext;
import com.bitarcher.aeFun.interfaces.gui.theme.context.owner.EnumMouseEffect;

/**
 * Created by michel on 09/03/15.
 */
public class ButtonContext implements IButtonContext {
    boolean enabled;
    EnumMouseEffect mouseEffect;
    ISize size;

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public EnumMouseEffect getMouseEffect() {
        return this.mouseEffect;
    }

    @Override
    public ISize getSize() {
        return null;
    }
}
