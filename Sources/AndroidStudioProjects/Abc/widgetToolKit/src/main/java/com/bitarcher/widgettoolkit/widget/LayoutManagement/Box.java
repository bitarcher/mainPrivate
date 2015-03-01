package com.bitarcher.widgettoolkit.widget.LayoutManagement;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.interfacesOpenSource.gui.theme.ITheme;
import com.bitarcher.interfacesOpenSource.gui.widgets.IWidget;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.EnumOrientation;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.IBox;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.ISpaceUsage;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.IVBox;
import com.bitarcher.interfacesOpenSource.gui.widgets.LayoutManagement.IWidgetAndSpaceUsageTuple;
import com.bitarcher.widgettoolkit.widget.Widget;

import org.andengine.entity.IEntity;
import org.andengine.util.adt.list.SmartList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 28/02/15.
 */
public class Box extends Widget implements IBox {

    SmartList<IWidgetAndSpaceUsageTuple> widgetAndSpaceUsageTupleArrayList = new SmartList<>();

    protected Box(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(theme, pX, pY, pWidth, pHeight);
    }


    @Override
    public EnumOrientation getOrientation() {
        EnumOrientation retval = EnumOrientation.Horizontal;

        if(this instanceof IVBox)
        {
            retval = EnumOrientation.Vertical;
        }

        return retval;
    }

    @Override
    public List<IWidgetAndSpaceUsageTuple> getPacketWidgetList() {
        return this.widgetAndSpaceUsageTupleArrayList;
    }

    @Override
    public void packStart(IWidget widget, ISpaceUsage spaceUsage) {
        this.widgetAndSpaceUsageTupleArrayList.addFirst(new WidgetAndSpaceUsageTupleForBox(widget, spaceUsage));

        this.recomputeWidgetsSizeAndPositions();
    }

    @Override
    public void packEnd(IWidget widget, ISpaceUsage spaceUsage) {
        this.widgetAndSpaceUsageTupleArrayList.addLast(new WidgetAndSpaceUsageTupleForBox(widget, spaceUsage));

        this.recomputeWidgetsSizeAndPositions();
    }

    void recomputeWidgetsSizeAndPositions()
    {
    }

    @Override
    protected void onSizeChanged() {
        super.onSizeChanged();

        this.recomputeWidgetsSizeAndPositions();
    }
}

