package com.bitarcher.aeFun.widgetToolkit.widget.Tools.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.IContainer;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.IContainerListener;
import com.bitarcher.aeFun.widgetToolkit.widget.Widget;

import java.util.ArrayList;

/**
 * Created by michel on 03/03/15.
 */
public abstract class Container extends Widget implements IContainer {

    ArrayList<IContainerListener> containerListenerArrayList = new ArrayList<>();

    public Container(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(theme, pX, pY, pWidth, pHeight);
    }

    @Override
    public void attachChild(IWidget widget) {
        this.doAddWidget(widget);
    }

    abstract protected void doAddWidget(IWidget widget);

    @Override
    public void addContainerListener(IContainerListener containerListener) {
        this.containerListenerArrayList.add(containerListener);
    }

    @Override
    public void removeContainerListener(IContainerListener containerListener) {
        this.containerListenerArrayList.remove(containerListener);
    }

    protected void raiseChildrenPositionRecomputed()
    {
        for(IContainerListener containerListener : this.containerListenerArrayList)
        {
            containerListener.onChildrenPositionRecomputed(this);
        }
    }
}

