package com.bitarcher.widgettoolkit.theme;

import com.bitarcher.interfaces.gui.EnumFontSize;
import com.bitarcher.interfaces.gui.ITheme;
import com.bitarcher.interfaces.gui.IThemeManager;
import com.bitarcher.interfaces.resourcemanagement.EResourceNotFound;

import org.andengine.opengl.font.Font;

import java.util.Date;
import java.util.NoSuchElementException;

/**
 * Created by michel on 21/01/15.
 */
public abstract class ThemeBase implements ITheme {
    IThemeManager themeManager;
    String name;


    @Override
    public IThemeManager getThemeManager() {
        return this.themeManager;
    }

    protected ThemeBase(IThemeManager themeManager, String name) {
        this.themeManager = themeManager;
        this.name = name;
    }

    protected abstract Font getBigFont() throws EResourceNotFound;
    protected abstract Font getMediumFont() throws EResourceNotFound;
    protected abstract Font getSmallFont() throws EResourceNotFound;


    @Override
    public Font getFont(EnumFontSize eFontSize) throws EResourceNotFound {

        Font retval = null;

        switch(eFontSize)
        {
            case Big:
                retval = this.getBigFont();
                break;
            case Medium:
                retval = this.getMediumFont();
                break;
            case Small:
                retval = this.getSmallFont();
                break;

            default:
                throw new NoSuchElementException(eFontSize.toString());
        }
        return retval;
    }

    @Override
    public String getName() {
        return this.name;
    }


    protected void onPushFontRequirements()
    {

    }

    protected void onPopFontRequirements() throws EResourceNotFound {

    }

    protected void onLoadOtherResources()
    {

    }

    protected void onUnloadOtherResources()
    {

    }

    @Override
    public final void start() {
        this.onPushFontRequirements();
        this.onLoadOtherResources();
    }

    @Override
    public final void stop() {
        this.onUnloadOtherResources();

        try {
            this.onPopFontRequirements();
        } catch (EResourceNotFound eResourceNotFound) {
            eResourceNotFound.printStackTrace();
        }
    }

    @Override
    public void tic(Date dateTime) {
        // not used
    }
}
