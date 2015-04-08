package com.bitarcher.aeFun.widgetLayout.layouts.tools;

import com.bitarcher.aeFun.interfaces.basicioc.IClickableEntity;
import com.bitarcher.aeFun.interfaces.basicioc.IClickableListener;
import com.bitarcher.aeFun.interfaces.gui.theme.context.setter.ICheckedSetter;
import com.bitarcher.aeFun.widgetLayout.layouts.CheckButtonLayout;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.adt.color.Color;

import java.util.ArrayList;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 01/04/15.
 */
public class CheckButtonClickableEntityOld extends Entity implements IClickableEntity, ICheckedSetter{
    CheckButtonLayout checkButtonLayout;
    ArrayList<IClickableListener> clickableListenerArrayList = new ArrayList<>();

    Rectangle clickableSquare;
    Rectangle clickableFrontSquare;
    CheckSymbol checkSymbol;

    protected boolean isTouchAreaRegistered = false;

    public CheckButtonClickableEntityOld(CheckButtonLayout checkButtonLayout) {

        this.checkButtonLayout = checkButtonLayout;

        this.doSizeAndPadding();
    }

    @Override
    public void setChecked(boolean checked) {
        this.checkSymbol.setVisible(checked);
    }

    @Override
    public void addClickableListener(IClickableListener clickableListener) {
        this.clickableListenerArrayList.add(clickableListener);
    }

    @Override
    public void removeClickableListener(IClickableListener clickableListener) {
        this.clickableListenerArrayList.remove(clickableListener);
    }

    static float getWidthOrHighByCheckButtonLayout(CheckButtonLayout checkButtonLayout)
    {
        return checkButtonLayout.getWidget().getTheme().getWidgetSections().getCheckButtonSection().getSideLength();
    }

    float getWidthOrHeight()
    {
        return CheckButtonClickableEntityOld.getWidthOrHighByCheckButtonLayout(this.checkButtonLayout);
    }

    public void setEnableColors()
    {
        boolean enabled =this.checkButtonLayout.getWidget().isEnabled();
        if(enabled) {
            this.clickableSquare.setColor(this.checkButtonLayout.getWidget().getTheme().getWidgetSections().getCheckButtonSection().getClickableEntityColor1());
        }
        else

        {
            this.clickableSquare.setColor(this.checkButtonLayout.getWidget().getTheme().getColorsSection().getDisabledColor1());
        }

        this.checkSymbol.setEnabled(enabled);
    }

    public void onPopulate()
    {
        float side = this.getWidthOrHeight();
        float side2 = side / 2;
        this.clickableSquare = new Rectangle(side2, side2, side, side, this.checkButtonLayout.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());

        this.attachChild(this.clickableSquare);

        float borderSize = 3;
        float reducedSide = side - 2 * borderSize;

        this.clickableFrontSquare = new Rectangle(side2, side2, reducedSide, reducedSide, this.checkButtonLayout.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        Color sColor = this.checkButtonLayout.getWidget().getTheme().getWidgetSections().getCheckButtonSection().getClickableEntityColor2();
        this.clickableFrontSquare.setColor(sColor);
        this.attachChild(this.clickableFrontSquare);

       /* this.checkSymbol = new CheckSymbol(this, side2, side2, reducedSide, reducedSide);
        this.setChecked(((com.bitarcher.aeFun.interfaces.basicioc.ICheckable)this.checkButtonLayout.getWidget()).isChecked());
        this.attachChild(this.checkSymbol);*/
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

        if(pSceneTouchEvent.isActionDown()) {
            if (this.checkButtonLayout.getWidget().isEnabled()) {
                retval = true;

                for (IClickableListener clickableListener : this.clickableListenerArrayList) {
                    clickableListener.onClick(this);
                }
            }
        }

        return retval;
    }


    public void doSizeAndPadding() {

        float side = CheckButtonClickableEntityOld.getWidthOrHighByCheckButtonLayout(this.checkButtonLayout);
        this.setPosition(
                side + 2,
                this.checkButtonLayout.getWidget().getHeight() / 2);



        this.setSize(side, side);
    }

}

