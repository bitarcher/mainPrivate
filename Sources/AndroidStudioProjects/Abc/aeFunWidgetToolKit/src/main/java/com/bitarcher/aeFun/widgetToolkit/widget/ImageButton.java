package com.bitarcher.aeFun.widgetToolkit.widget;


import com.bitarcher.aeFun.interfaces.gui.theme.ENoLayoutFound;
import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.theme.context.IImageButtonContext;
import com.bitarcher.aeFun.interfaces.gui.theme.context.ITextButtonContext;
import com.bitarcher.aeFun.interfaces.gui.widgets.IImageButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.ITextButton;
import com.bitarcher.aeFun.interfaces.mvc.IImage;
import com.bitarcher.aeFun.interfaces.mvc.IImagedListener;
import com.bitarcher.aeFun.interfaces.mvc.ILabeledListener;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.Button;

import java.util.ArrayList;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**-
 * Created by michel on 22/01/15.
 */
public class ImageButton extends Button<IImageButtonContext> implements IImageButton {
    protected IImage currentImage;
    ArrayList<IImagedListener> imagedListenerArrayList = new ArrayList<>();



    public ImageButton(ITheme theme, float pX, float pY, float pWidth, float pHeight, IImage image) {
        super(theme, pX, pY, pWidth, pHeight);

        this.setImage(image, false);

        if(this.getLayout() != null)
        {
            this.getLayout().onInit();
        }
        else
        {
            throw new ENoLayoutFound(this);
        }
    }

    void setImage(IImage image, boolean shouldRaise)
    {
        if(this.currentImage != null)
        {
            this.getTheme().getThemeManager().getResourceManager().popRequirement(image.getTextureSetResourceInfo());
        }

        this.currentImage = image;

        if(this.currentImage != null)
        {
            this.getTheme().getThemeManager().getResourceManager().pushRequirement(image.getTextureSetResourceInfo());
        }

        if(shouldRaise)
        {
            for(IImagedListener imagedListener : this.imagedListenerArrayList)
            {
                imagedListener.onImageChanged(this);
            }

            this.onImageChanged(image);
        }
    }



    @Override
    public void addImagedListener(IImagedListener imagedListener) {
        this.imagedListenerArrayList.add(imagedListener);
    }

    @Override
    public void removeImagedListener(IImagedListener imagedListener) {
        this.imagedListenerArrayList.remove(imagedListener);
    }

    @Override
    public void setImage(IImage image) {

        this.setImage(image, true);
    }

    protected void onImageChanged(IImage image)
    {
        if(this.getLayout() != null)
        {
            this.getLayout().getContext().setImage(this.getImage());
        }

    }

    @Override
    public IImage getImage() {
        return this.currentImage;
    }
    
}

