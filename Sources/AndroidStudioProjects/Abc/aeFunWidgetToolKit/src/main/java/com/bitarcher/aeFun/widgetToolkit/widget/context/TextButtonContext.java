package com.bitarcher.aeFun.widgetToolkit.widget.context;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.geometry.ISize;
import com.bitarcher.aeFun.interfaces.gui.theme.context.ITextButtonContext;
import com.bitarcher.aeFun.interfaces.gui.theme.context.owner.EnumMouseEffect;

/**
 * Created by michel on 09/03/15.
 */
public class TextButtonContext extends ButtonContext implements ITextButtonContext {
    String translatedLabel;

    @Override
    public String getTranslatedLabel() {
        return this.translatedLabel;
    }

    public TextButtonContext(Boolean enabled, ISize size, Float padding, EnumMouseEffect mouseEffect, String translatedLabel) {
        super(enabled, size, padding, mouseEffect);
        this.translatedLabel = translatedLabel;
    }
}
