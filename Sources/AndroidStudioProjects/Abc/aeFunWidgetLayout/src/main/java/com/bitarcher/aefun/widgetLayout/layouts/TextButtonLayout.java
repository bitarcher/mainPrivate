package com.bitarcher.aefun.widgetLayout.layouts;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */


import com.bitarcher.aeFun.interfaces.gui.theme.context.ITextButtonContext;
import com.bitarcher.aeFun.interfaces.gui.theme.layout.ITextButtonLayout;
import com.bitarcher.aeFun.interfaces.gui.widgets.ITextButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;

import org.andengine.entity.primitive.Rectangle;

/**
 * Created by michel on 09/03/15.
 */
public class TextButtonLayout implements ITextButtonLayout {
    ITextButton textButton;
    Rectangle backRectangle;


    @Override
    public ITextButton getWidget() {
        return this.textButton;
    }

    @Override
    public void onPopulate() {
        this.backRectangle = new Rectangle(0, 0, 10, 10, this.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        this.backRectangle.setColor(0.7f, 0.9f, 0.9f);
        this.textButton.attachChild(this.backRectangle);
    }

    @Override
    public void onInit(ITextButtonContext context) {
        this.backRectangle.setSize(context.getSize().getWidth() - context.getPadding(), context.getSize().getHeight() - context.getPadding());

    }

    @Override
    public void onContextChanged(ITextButtonContext context) {
        if(context.getPadding() != null || context.getSize() != null)
        {
            this.backRectangle.setSize(this.textButton.getWidth() - this.textButton.getPadding(), this.textButton.getHeight() - this.textButton.getPadding());
            // TODO
        }
        if(context.isEnabled() != null || context.getMouseEffect() != null)
        {

            // TODO
        }

        if(context.getTranslatedLabel() != null)
        {
            // TODO
        }
    }

    @Override
    public void pushResourceRequirements() {
    }

    @Override
    public void popResourceRequirements() {

    }

    public TextButtonLayout(ITextButton textButton) {
        this.textButton = textButton;
    }
}
