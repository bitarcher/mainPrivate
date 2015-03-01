package com.bitarcher.interfacesOpenSource.gui.widgets;

/**
 * Created by michel on 22/01/15.
 */
public interface IImageButton extends IButton {
    void addImageButtonListener(IImageButtonListener imageButtonListener);
    void removeImageButtonListener(IImageButtonListener imageButtonListener);
}
