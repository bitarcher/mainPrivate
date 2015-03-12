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
import org.andengine.entity.primitive.Gradient;
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
    //Gradient gradient;
    Entity textLayer;
    Gradient gradient;



    @Override
    public ITextButton getWidget() {
        return this.textButton;
    }

    @Override
    public void onPopulate() {
        this.backRectangle = new Rectangle(0, 0, 10, 10, this.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        this.backRectangle.setColor(this.getWidget().getTheme().getWidgetSections().getTextButtonSection().getBorderColor());
        this.textButton.attachChild(this.backRectangle);


        //this.text.setWidth(pWidth);
        //this.text.setHeight(pWidth);

        //this.attachChild(this.buttonSprite);

        this.gradient = new Gradient(0, 0, 10, 10, this.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        this.textButton.attachChild(this.gradient);

        // I have to do so since Text.setText has problem
        this.textLayer = new Entity();
        this.textButton.attachChild(this.textLayer);
    }

    @Override
    public void onInit() {
        this.setText(this.textButton.getTranslatedLabel());
        this.doSizeAndPadding();
        this.doGradientColor();
    }


    void setText(String label) {

        this.textLayer.detachChildren();

        if (!(label.isEmpty()))
        {
            float midWidth = this.textButton.getWidth() / 2;
            float midHeight = this.textButton.getHeight() / 2;

            Font font = this.textButton.getTheme().getWidgetSections().getTextButtonSection().getTextButtonFont();
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
        this.doGradientColor();
    }

    @Override
    public ITextButtonContext getContext() {
        return this;
    }

    @Override
    public void setMouseEffect(EnumMouseEffect mouseEffect) {
        this.doGradientColor();
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
        float tw = this.textButton.getWidth();
        float th = this.textButton.getHeight();

        float midWidth = tw / 2;
        float midHeight = th / 2;

        float wmp = tw - 2 * this.textButton.getPadding();
        float hmp = th - 2 * this.textButton.getPadding();

        float border = 4;
        float wb = wmp - 2 * border;
        float hb = hmp - 2 * border;


        this.backRectangle.setSize(wmp, hmp);
        this.backRectangle.setPosition(midWidth, midHeight);

        this.setText(this.textButton.getTranslatedLabel());

        this.gradient.setSize(wb, hb);
        this.gradient.setPosition(midWidth, midHeight);

    }

    void doGradientColor()
    {
        if(this.textButton.isEnabled()) {
            if(this.textButton.isMousePressed())
            {
                gradient.setFromColor(this.getWidget().getTheme().getWidgetSections().getTextButtonSection().getActivatedColor1());
                gradient.setToColor(this.getWidget().getTheme().getWidgetSections().getTextButtonSection().getActivatedColor2());
            }
            else {
                gradient.setFromColor(this.getWidget().getTheme().getWidgetSections().getTextButtonSection().getNormalColor1());
                gradient.setToColor(this.getWidget().getTheme().getWidgetSections().getTextButtonSection().getNormalColor2());
            }
        }
        else
        {
            gradient.setFromColor(this.getWidget().getTheme().getWidgetSections().getTextButtonSection().getDisabledColor1());
            gradient.setToColor(this.getWidget().getTheme().getWidgetSections().getTextButtonSection().getDisabledColor2());
        }
    }

    @Override
    public void setTranslatedLabel(String translatedLabel) {
        this.setText(translatedLabel);
    }
}
