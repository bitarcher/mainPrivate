package com.bitarcher.aeFun.widgetLayout.layouts.tools;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.widgets.Tools.IEnableSetterEntity;

import org.andengine.entity.primitive.DrawMode;
import org.andengine.entity.primitive.Mesh;
import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 08/04/15.
 */
public class CheckSymbol extends Mesh implements IEnableSetterEntity {

    CheckButtonClickableEntity checkButtonClickableEntity;

    public CheckSymbol(CheckButtonClickableEntity checkButtonClickableEntity, float x, float y, float width, float height) {
        super(x, y, width, height, CheckSymbol.getCoordinates(width, height), 6, DrawMode.TRIANGLE_STRIP, checkButtonClickableEntity.checkableLayout.getWidget().getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager()); // dummy init

        this.checkButtonClickableEntity = checkButtonClickableEntity;
        this.setColor();
    }

    static float[] getCoordinates(float width, float height)
    {
        float UNUSED = 0;

        // coordinates for triangle_strip
        float[] retval = new float[]{
            // p0
            0.05f * width, 0.6f * height, UNUSED,
            // p1
            0, 0.5f * height, UNUSED,
            // p2
            0.4f * width, 0, UNUSED,
            // p3
            0.4f * width, 0.15f * height, UNUSED,
            // p4
            1f * width, 0.95f * height, UNUSED,
            // p5
            0.9f * width, 1 * height, UNUSED
        };

        return retval;
    }

    void setColor()
    {
        Color color;
        ITheme theme = this.checkButtonClickableEntity.checkableLayout.getWidget().getTheme();

        if(this.checkButtonClickableEntity.checkableLayout.getWidget().isEnabled())
        {
            color = theme.getWidgetSections().getCheckButtonSection().getActivatedColor2();
        }
        else
        {
            color = theme.getWidgetSections().getCheckButtonSection().getDisabledColor2();
        }

        this.setColor(color);
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.setColor();
    }
}
