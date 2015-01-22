package com.bitarcher.interfaces.gui.widgets;

/**
 * Created by michel on 22/01/15.
 */
public interface ITextButton extends IButton {
    void addTextButtonListener(ITextButtonListener textButtonListener);
    void removeTextButtonListener(ITextButtonListener textButtonListener);

    void setTranslatedLabel(String translatedLabel);
    String getTranslatedLabel();
}
