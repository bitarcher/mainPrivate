package com.bitarcher.widgettoolkit.widget;

import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.gui.widgets.IButton;
import com.bitarcher.interfaces.gui.widgets.IButtonListener;

import java.util.ArrayList;

/**
 * Created by michel on 22/01/15.
 */
public abstract class Button extends Widget implements IButton{

    protected ArrayList<IButtonListener> buttonListenerArrayList=new ArrayList<>();

    protected Button(float pX, float pY, float pWidth, float pHeight, ITheme theme) {
        super(pX, pY, pWidth, pHeight, theme);
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
