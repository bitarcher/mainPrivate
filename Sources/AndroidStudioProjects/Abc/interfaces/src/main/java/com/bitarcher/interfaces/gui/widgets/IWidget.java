package com.bitarcher.interfaces.gui.widgets;

import com.bitarcher.interfaces.gui.theme.ITheme;

import org.andengine.entity.IEntity;

/**
 * Created by michel on 21/01/15.
 */
public interface IWidget extends IEntity{
    ITheme getTheme();

    void addWidgetListener(IWidgetListener widgetListener);
    void removeWidgetListener(IWidgetListener widgetListener);

    boolean isEnabled();
    void setEnabled(boolean enabled);
}
