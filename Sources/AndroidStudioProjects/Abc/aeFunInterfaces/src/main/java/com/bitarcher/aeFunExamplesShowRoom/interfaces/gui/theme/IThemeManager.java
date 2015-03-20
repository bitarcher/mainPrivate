package com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.IResourceManagerLinked;

/**
 * Created by michel on 21/01/15.
 */
public interface IThemeManager extends IResourceManagerLinked {
    ITheme getCurrentTheme();
    void setCurrentTheme(ITheme theme);
}
