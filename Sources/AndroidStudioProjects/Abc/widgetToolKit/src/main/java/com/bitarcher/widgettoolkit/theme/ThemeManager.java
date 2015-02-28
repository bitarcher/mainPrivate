package com.bitarcher.widgettoolkit.theme;

import com.bitarcher.interfacesProtected.gui.theme.ITheme;
import com.bitarcher.interfacesProtected.gui.theme.IThemeManager;
import com.bitarcher.interfacesProtected.resourcemanagement.IResourceManager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by michel on 22/01/15.
 */
public class ThemeManager implements IThemeManager {

    @Nullable
    ITheme currentTheme;

    @NotNull
    IResourceManager resourceManager;

    public ThemeManager(IResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    @Override
    public void setCurrentTheme(ITheme currentTheme) {

        if(this.currentTheme != null)
        {
            this.currentTheme.stop();
        }

        this.currentTheme = currentTheme;

        if(this.currentTheme != null)
        {
            this.currentTheme.start();
        }
    }

    @Override
    public ITheme getCurrentTheme() {

        return currentTheme;
    }

    @Override
    public IResourceManager getResourceManager() {
        return resourceManager;
    }
}
