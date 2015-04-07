package com.bitarcher.aefun.widgetLayout.layouts;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.basicioc.IClickableEntity;
import com.bitarcher.aeFun.interfaces.gui.theme.context.ICheckButtonContext;
import com.bitarcher.aeFun.interfaces.gui.theme.layout.ICheckButtonLayout;
import com.bitarcher.aeFun.interfaces.gui.widgets.ICheckButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aefun.widgetLayout.layouts.tools.CheckButtonClickableEntity;
import com.bitarcher.aefun.widgetLayout.layouts.tools.CheckableContext;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.vbo.DrawType;

/**
 * Created by michel on 20/03/15.
 */
public class CheckButtonLayout extends CheckableContext implements ICheckButtonLayout, ICheckButtonContext {
    ICheckButton checkButton;
    Entity textLayer;
    CheckButtonClickableEntity checkButtonClickableEntity;

    @Override
    protected void doSizeAndPadding() {

        this.checkButtonClickableEntity.doSizeAndPadding();

        this.setText(this.checkButton.getTranslatedLabel());
    }

    @Override
    public void setChecked(boolean checked) {

    }

    @Override
    public void setEnabled(boolean enabled) {
        this.setEnableColors();
    }

    public CheckButtonLayout(ICheckButton checkButton) {
        this.checkButton = checkButton;
    }

    void setEnableColors()
    {
        this.checkButtonClickableEntity.setEnableColors();
    }

    @Override
    public IWidget<ICheckButtonContext> getWidget() {
        return this.checkButton;
    }

    @Override
    public void onPopulate() {
        this.textLayer = new Entity();
        this.checkButton.attachChild(this.textLayer);


        this.checkButtonClickableEntity = new CheckButtonClickableEntity(this);
        this.checkButton.attachChild(this.checkButtonClickableEntity);
        this.checkButtonClickableEntity.onPopulate();
    }

    void setText(String label) {

        this.textLayer.detachChildren();

        if (!(label.isEmpty()))
        {
            float midWidth = this.checkButton.getWidth() / 2;
            float midHeight = this.checkButton.getHeight() / 2;

            Font font = this.checkButton.getTheme().getWidgetSections().getCheckButtonSection().getCheckButtonFont();
            Text text = new Text(midWidth, midHeight, font, label, this.checkButton.getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager(), DrawType.DYNAMIC);

            this.textLayer.attachChild(text);
        }
    }

    @Override
    public void onInit() {
        this.setText(this.checkButton.getTranslatedLabel());
        this.setEnableColors();
    }

    @Override
    public ICheckButtonContext getContext() {
        return this;
    }

    @Override
    public void pushResourceRequirements() {

    }

    @Override
    public void popResourceRequirements() {

    }

    @Override
    public void setTranslatedLabel(String translatedLabel) {
        this.setText(translatedLabel);
    }

    @Override
    public IClickableEntity getClickableEntity() {

        if(this.checkButtonClickableEntity == null)
        {
            throw new RuntimeException("Clickable rectangle not initialised yet");
        }

        return this.checkButtonClickableEntity;
    }
}
