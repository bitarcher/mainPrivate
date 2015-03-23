package com.bitarcher.aefun.widgetLayout.layouts;

import com.bitarcher.aeFun.interfaces.geometry.ISize;
import com.bitarcher.aeFun.interfaces.gui.theme.context.ILabelContext;
import com.bitarcher.aeFun.interfaces.gui.theme.context.ITextButtonContext;
import com.bitarcher.aeFun.interfaces.gui.theme.layout.ILabelLayout;

import com.bitarcher.aeFun.interfaces.gui.theme.widgetSections.IButtonSection;
import com.bitarcher.aeFun.interfaces.gui.widgets.ILabel;
import com.bitarcher.aeFun.interfaces.gui.widgets.ITextButton;

import org.andengine.entity.Entity;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.vbo.DrawType;

/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 09/03/15.
 */
public class LabelLayout  implements ILabelLayout, ILabelContext {
    ILabel label;
    Entity textLayer;


    @Override
    public ILabel getWidget() {
        return this.label;
    }

    @Override
    public void pushResourceRequirements() {

    }

    @Override
    public void popResourceRequirements() {

    }

    @Override
    public void onPopulate() {
        
        // I have to do so since Text.setText has problem
        this.textLayer = new Entity();
        this.label.attachChild(this.textLayer);
    }

    @Override
    public void onInit() {
        this.setText(this.label.getTranslatedLabel());
    }


    void setText(String label) {

        this.textLayer.detachChildren();

        if (!(label.isEmpty()))
        {
            float midWidth = this.label.getWidth() / 2;
            float midHeight = this.label.getHeight() / 2;

            Font font = this.label.getTheme().getWidgetSections().getTextButtonSection().getTextButtonFont();
            Text text = new Text(midWidth, midHeight, font, label, this.label.getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager(), DrawType.DYNAMIC);

            this.textLayer.attachChild(text);
        }
    }



    public LabelLayout(ILabel label)
    {
        this.label = label;
    }


    @Override
    public ILabelContext getContext() {
        return this;
    }

    
    protected void doSizeAndPadding()
    {
        this.setText(this.label.getTranslatedLabel());
    }

    @Override
    public void setTranslatedLabel(String translatedLabel) {
        this.setText(translatedLabel);
    }


    @Override
    public void setPadding(float padding) {
        this.doSizeAndPadding();
    }

    @Override
    public void setSize(ISize size) {
        this.doSizeAndPadding();
    }

    @Override
    public void setEnabled(boolean enabled) {
        if(enabled)
        {
            this.label.setAlpha(1);
        }
        else
        {
            this.label.setAlpha(0.5f);
        }
    }
}
