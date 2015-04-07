package com.bitarcher.aefun.widgetLayout.layouts.tools;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.context.setter.EnumMouseEffect;
import com.bitarcher.aefun.widgetLayout.layouts.CheckButtonLayout;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 01/04/15.
 */
public class CheckButtonClickableEntity extends Entity {
    CheckButtonLayout checkButtonLayout;

    Rectangle clickableSquare;
    Rectangle clickableFrontSquare;

    protected boolean isTouchAreaRegistered = false;

    public CheckButtonClickableEntity(CheckButtonLayout checkButtonLayout) {

        this.checkButtonLayout = checkButtonLayout;

        this.doSizeAndPadding();
    }

    static float getWidthOrHighByCheckButtonLayout(CheckButtonLayout checkButtonLayout)
    {
        return checkButtonLayout.getWidget().getTheme().getWidgetSections().getCheckButtonSection().getCheckSquareSideLength();
    }

    float getWidthOrHeight()
    {
        return CheckButtonClickableEntity.getWidthOrHighByCheckButtonLayout(this.checkButtonLayout);
    }

    public void setEnableColors()
    {
        if(this.checkButtonLayout.getWidget().isEnabled()) {
            this.clickableSquare.setColor(this.checkButtonLayout.getWidget().getTheme().getWidgetSections().getCheckButtonSection().getClickableEntityColor1());
        }
        else

        {
            this.clickableSquare.setColor(this.checkButtonLayout.getWidget().getTheme().getColorsSection().getDisabledColor1());
        }
    }

    public void onPopulate()
    {
        float side = this.getWidthOrHeight();
        float side2 = side / 2;
        this.clickableSquare = new Rectangle(side2, side2, side, side, this.checkButtonLayout.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());

        this.attachChild(this.clickableSquare);

        float borderSize = 3;
        this.clickableFrontSquare = new Rectangle(side2, side2, this.getWidthOrHeight() - 2 * borderSize, this.getWidthOrHeight() - 2 * borderSize, this.checkButtonLayout.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        Color sColor = this.checkButtonLayout.getWidget().getTheme().getWidgetSections().getCheckButtonSection().getClickableEntityColor2();
        this.clickableFrontSquare.setColor(sColor);
        this.attachChild(this.clickableFrontSquare);
    }

    @Override
    public void onAttached() {
        super.onAttached();

        if(!this.isTouchAreaRegistered)
        {
            Scene scene = this.checkButtonLayout.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getScene();

            scene.registerTouchArea(this);
            this.isTouchAreaRegistered = true;
        }
    }

    @Override
    public void onDetached() {
        super.onDetached();

        if(this.isTouchAreaRegistered)
        {
            Scene scene = this.checkButtonLayout.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getScene();

            scene.unregisterTouchArea(this);

            this.isTouchAreaRegistered = false;
        }

        this.resetMousePressed();
    }

    void resetMousePressed()
    {
        // nothing to do
    }

    @Override
    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

        boolean retval = false;
        if(this.checkButtonLayout.getWidget().isEnabled()) {
            retval = true;

            // TODO
        }

        return retval;
    }


    public void doSizeAndPadding() {

        float side = CheckButtonClickableEntity.getWidthOrHighByCheckButtonLayout(this.checkButtonLayout);
        this.setPosition(
                side + 2,
                this.checkButtonLayout.getWidget().getHeight() / 2);



        this.setSize(side, side);
    }

}

