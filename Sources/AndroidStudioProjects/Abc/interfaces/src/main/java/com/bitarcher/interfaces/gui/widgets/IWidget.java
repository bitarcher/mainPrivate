package com.bitarcher.interfaces.gui.widgets;

import com.bitarcher.interfaces.gui.theme.ITheme;

/**
 * Created by michel on 21/01/15.
 */
public interface IWidget {
    ITheme getTheme();

    void addWidgetListener(IWidgetListener widgetListener);
    void removeWidgetListener(IWidgetListener widgetListener);
}
