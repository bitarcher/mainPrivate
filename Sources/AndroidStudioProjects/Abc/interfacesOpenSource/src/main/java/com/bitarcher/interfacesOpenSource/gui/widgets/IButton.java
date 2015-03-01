package com.bitarcher.interfacesOpenSource.gui.widgets;

/**
 * Created by michel on 22/01/15.
 */
public interface IButton extends IWidget {
    void addButtonListener(IButtonListener buttonListener);
    void removeButtonListener(IButtonListener buttonListener);
}
