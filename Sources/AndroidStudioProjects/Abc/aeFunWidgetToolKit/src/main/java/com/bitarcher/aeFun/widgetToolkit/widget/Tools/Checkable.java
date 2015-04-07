package com.bitarcher.aeFun.widgetToolkit.widget.Tools;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.theme.context.ICheckableContext;
import com.bitarcher.aeFun.interfaces.gui.widgets.ICheckable;
import com.bitarcher.aeFun.interfaces.gui.widgets.ICheckableListener;
import com.bitarcher.aeFun.widgetToolkit.widget.Widget;

import java.util.ArrayList;

/**
 * Created by michel on 20/03/15.
 */
public class Checkable<TCheckableContext extends ICheckableContext> extends Widget<TCheckableContext> implements ICheckable<TCheckableContext> {
    boolean checked;
    ArrayList<ICheckableListener> checkableListeners = new ArrayList<>();

    @Override
    public void addCheckableListener(ICheckableListener checkableListener) {
        this.checkableListeners.add(checkableListener);
    }

    @Override
    public void removeCheckableListener(ICheckableListener checkableListener) {
        this.checkableListeners.remove(checkableListener);
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void setChecked(boolean checked) {
        if(this.checked != checked) {
            this.checked = checked;

            this.onCheckedChanged();

            for(ICheckableListener checkableListener : this.checkableListeners)
            {
                checkableListener.onCheckedChanged(this, checked);
            }
        }
    }

    protected void onCheckedChanged()
    {
        if(this.getLayout() != null)
        {
            this.getLayout().getContext().setChecked(this.checked);
        }
    }

    public Checkable(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(theme, pX, pY, pWidth, pHeight);
    }

    @Override
    public void dispose() {
        super.dispose();

        this.checkableListeners.clear();
    }

    protected void connectToLayoutClickableEntity()
    {
        //this.getLayout().getContext().getClickableEntity()
    }
}
