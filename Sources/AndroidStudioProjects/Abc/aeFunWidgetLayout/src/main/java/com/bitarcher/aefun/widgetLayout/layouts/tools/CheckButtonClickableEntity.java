package com.bitarcher.aefun.widgetLayout.layouts.tools;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aefun.widgetLayout.layouts.CheckButtonLayout;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 01/04/15.
 */
public class CheckButtonClickableEntity extends Entity {
    CheckButtonLayout checkButtonLayout;

    Rectangle clickableSquare;
    Rectangle clickableFrontSquare;


    public CheckButtonClickableEntity(CheckButtonLayout checkButtonLayout) {
        super(CheckButtonClickableEntity.getWidthOrHighByCheckButtonLayout(checkButtonLayout) / 2,
                CheckButtonClickableEntity.getWidthOrHighByCheckButtonLayout(checkButtonLayout) / 2,
                CheckButtonClickableEntity.getWidthOrHighByCheckButtonLayout(checkButtonLayout),
                CheckButtonClickableEntity.getWidthOrHighByCheckButtonLayout(checkButtonLayout));

        this.checkButtonLayout = checkButtonLayout;
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
        this.clickableSquare = new Rectangle(0, 0, this.getWidthOrHeight(), this.getWidthOrHeight(), this.checkButtonLayout.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());

        this.attachChild(this.clickableSquare);

        float borderSize = 3;
        this.clickableFrontSquare = new Rectangle(borderSize, borderSize, this.getWidthOrHeight() - 2 * borderSize, this.getWidthOrHeight() - 2 * borderSize, this.checkButtonLayout.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        Color sColor = this.checkButtonLayout.getWidget().getTheme().getWidgetSections().getCheckButtonSection().getClickableEntityColor2();
        this.clickableFrontSquare.setColor(sColor);
        //this.attachChild(this.clickableFrontSquare);
    }

}

