package com.bitarcher.widgettoolkit.widget;

import com.bitarcher.interfacesProtected.gui.theme.ITheme;
import com.bitarcher.interfacesProtected.gui.widgets.IButton;
import com.bitarcher.interfacesProtected.gui.widgets.IButtonListener;

import java.util.ArrayList;

/**
 * Created by michel on 22/01/15.
 */
public abstract class Button extends Widget implements IButton{

    protected ArrayList<IButtonListener> buttonListenerArrayList=new ArrayList<>();

    protected Button(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(theme, pX, pY, pWidth, pHeight);
    }

    @Override
    public void addButtonListener(IButtonListener buttonListener) {
        this.buttonListenerArrayList.add(buttonListener);
    }

    @Override
    public void removeButtonListener(IButtonListener buttonListener) {
        this.buttonListenerArrayList.remove(buttonListener);
    }
}
