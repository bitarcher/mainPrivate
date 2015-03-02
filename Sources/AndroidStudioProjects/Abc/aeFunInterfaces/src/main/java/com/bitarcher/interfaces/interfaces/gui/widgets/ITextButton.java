package com.bitarcher.interfaces.interfaces.gui.widgets;

import com.bitarcher.interfaces.interfaces.mvc.ILabeled_Edit;

/**
 * Created by michel on 22/01/15.
 */
public interface ITextButton extends IButton, ILabeled_Edit{
    void addTextButtonListener(ITextButtonListener textButtonListener);
    void removeTextButtonListener(ITextButtonListener textButtonListener);
}
