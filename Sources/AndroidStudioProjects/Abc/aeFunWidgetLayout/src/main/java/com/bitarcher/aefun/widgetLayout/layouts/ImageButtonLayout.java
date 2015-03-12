package com.bitarcher.aefun.widgetLayout.layouts;

import com.bitarcher.aeFun.interfaces.gui.theme.context.IImageButtonContext;
import com.bitarcher.aeFun.interfaces.gui.theme.layout.IImageButtonLayout;
import com.bitarcher.aeFun.interfaces.gui.theme.widgetSections.IButtonSection;
import com.bitarcher.aeFun.interfaces.gui.widgets.IImageButton;
import com.bitarcher.aeFun.interfaces.mvc.IImage;


/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 09/03/15.
 */
public class ImageButtonLayout extends ButtonLayout<IImageButtonContext> implements IImageButtonLayout, IImageButtonContext {
    IImageButton imageButton;



    @Override
    public IImageButton getWidget() {
        return this.imageButton;
    }

    @Override
    public void onPopulate() {
        super.onPopulate();


    }

    @Override
    public void onInit() {
        this._setImage(this.imageButton.getImage());

        super.onInit();
    }


    void _setImage(IImage image) {

        /*this.imageLayer.detachChildren();

        if (!(label.isEmpty()))
        {
            float midWidth = this.imageButton.getWidth() / 2;
            float midHeight = this.imageButton.getHeight() / 2;

            Font font = this.imageButton.getTheme().getWidgetSections().getImageButtonSection().getImageButtonFont();
            Image image = new Image(midWidth, midHeight, font, label, this.imageButton.getTheme().getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager(), DrawType.DYNAMIC);

            this.imageLayer.attachChild(image);
        }*/
    }



    public ImageButtonLayout(IImageButton imageButton)
    {
        super(imageButton);
        this.imageButton = imageButton;
    }


    @Override
    public IImageButtonContext getContext() {
        return this;
    }

    @Override
    protected void doSizeAndPadding()
    {
        super.doSizeAndPadding();

        this._setImage(this.imageButton.getImage());
    }

    @Override
    protected IButtonSection getButtonSection() {
        return this.getWidget().getTheme().getWidgetSections().getImageButtonSection();
    }

    @Override
    public void setImage(IImage image) {
        this._setImage(image);
    }
}
