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
public class ButtonContext extends CommonContext implements IButtonContext {

    EnumMouseEffect mouseEffect;


    @Override
    public EnumMouseEffect getMouseEffect() {
        return this.mouseEffect;
    }

    public ButtonContext(Boolean enabled, ISize size, Float padding, EnumMouseEffect mouseEffect) {
        super(enabled, size, padding);
        this.mouseEffect = mouseEffect;
    }
}
