package com.bitarcher.aeFun.widgetToolkit.widget.Tools;

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.theme.context.IButtonContext;
import com.bitarcher.aeFun.interfaces.gui.theme.context.IContext;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButtonListener;
import com.bitarcher.aeFun.widgetToolkit.widget.Widget;

import java.util.ArrayList;

/**
 * Created by michel on 22/01/15.
 */
public abstract class Button<TContext extends IButtonContext> extends Widget<TContext> implements IButton<TContext>{

    protected boolean isMousePressedPred;

    @Override
    public boolean isMousePressed() {
        return this.isMousePressedPred;
    }

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
