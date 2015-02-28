package com.bitarcher.interfacesProtected.gui.widgets;

import com.bitarcher.interfacesProtected.mvc.ILabeled_Edit;

/**
 * Created by michel on 22/01/15.
 */
public interface ITextButton extends IButton, ILabeled_Edit{
    void addTextButtonListener(ITextButtonListener textButtonListener);
    void removeTextButtonListener(ITextButtonListener textButtonListener);
}
