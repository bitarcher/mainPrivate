package com.bitarcher.aeFun.interfaces.gui.widgets;

import com.bitarcher.aeFun.interfaces.basicioc.IEnabled;
import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.IPaddable;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.IPositionable;
import com.bitarcher.aeFun.interfaces.gui.widgets.LayoutManagement.Other.ISizable;

import org.andengine.entity.IEntity;

/**
 * Created by michel on 21/01/15.
 */
public interface IWidget extends IEntity, IPositionable, ISizable, IEnabled, IPaddable {
    ITheme getTheme();

    void addWidgetListener(IWidgetListener widgetListener);
    void removeWidgetListener(IWidgetListener widgetListener);

    void onDebugModeChanged(boolean debugModeEnabled);
}
