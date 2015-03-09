package com.bitarcher.aefun.widgetLayout.layouts;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */


import com.bitarcher.aeFun.interfaces.geometry.ISize;
import com.bitarcher.aeFun.interfaces.gui.theme.context.ITextButtonContext;
import com.bitarcher.aeFun.interfaces.gui.theme.context.setter.EnumMouseEffect;
import com.bitarcher.aeFun.interfaces.gui.theme.layout.ITextButtonLayout;
import com.bitarcher.aeFun.interfaces.gui.widgets.ITextButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.vbo.DrawType;

/**
 * Created by michel on 09/03/15.
 */
public class TextButtonLayout implements ITextButtonLayout, ITextButtonContext {
    ITextButton textButton;
    Rectangle backRectangle;
    Entity textLayer;



    @Override
    public ITextButton getWidget() {
        return this.textButton;
    }

    @Override
    public void onPopulate() {
        this.backRectangle = new Rectangle(0, 0, 10, 10, this.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        this.backRectangle.setColor(0.7f, 0.9f, 0.9f);
        this.textButton.attachChild(this.backRectangle);

        //this.text.setWidth(pWidth);
        //this.text.setHeight(pWidth);

        //this.attachChild(this.buttonSprite);

        // I have to do so since Text.setText has problem
        this.textLayer = new Entity();
        this.textButton.attachChild(this.textLayer);
    }

    @Override
    public void onInit() {
        this.setText(this.textButton.getTranslatedLabel());
        this.doSizeAndPadding();


    }


    void setText(String label) {

        this.textLayer.detachChildren();

        if (!(label.isEmpty()))
        {
            float midWidth = this.textButton.getWidth() / 2;
            float midHeight = this.textButton.getHeight() / 2;

            Font font = this.textButton.getTheme().getFontThemeSection().getTextButtonFont();
            Text text = new Text(midWidth, midHeight, font, label, this.textButton.getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager(), DrawType.DYNAMIC);

            this.textLayer.attachChild(text);
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

    @Override
    public void setEnabled(boolean enabled) {

    }

    @Override
    public ITextButtonContext getContext() {
        return this;
    }

    @Override
    public void setMouseEffect(EnumMouseEffect mouseEffect) {
    }

    @Override
    public void setPadding(float padding) {
        this.doSizeAndPadding();
    }

    @Override
    public void setSize(ISize size) {
        this.doSizeAndPadding();
    }

    void doSizeAndPadding()
    {
        float border = 2;
        float midWidth = this.textButton.getWidth() / 2;
        float midHeight = this.textButton.getHeight() / 2;
        float wmp = this.textButton.getWidth() - this.textButton.getPadding();
        float hmp = this.textButton.getHeight() - this.textButton.getPadding();
        float wb = wmp - 2 * border;
        float hb = hmp - 2 * border;


        this.backRectangle.setSize(wmp, hmp);
        this.backRectangle.setPosition(midWidth, midHeight);

        this.setText(this.textButton.getTranslatedLabel());
    }

    @Override
    public void setTranslatedLabel(String translatedLabel) {
        this.setText(translatedLabel);
    }
}
