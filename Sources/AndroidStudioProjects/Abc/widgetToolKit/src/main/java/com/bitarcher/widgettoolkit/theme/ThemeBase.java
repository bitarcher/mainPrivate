package com.bitarcher.widgettoolkit.theme;

import com.bitarcher.aeFun.interfaces.gui.theme.EnumFontSize;
import com.bitarcher.aeFun.interfaces.gui.theme.IFontThemeSection;
import com.bitarcher.aeFun.interfaces.gui.theme.ITextButtonSection;
import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.theme.IThemeManager;
import com.bitarcher.aeFun.interfaces.resourcemanagement.EResourceNotFound;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;

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
    public IFontThemeSection getFontThemeSection() {
        final ThemeBase themeBase = this;

        return new IFontThemeSection() {
            @Override
            public Font getFont(EnumFontSize eFontSize) throws EResourceNotFound {
                return themeBase.getTheFont(eFontSize);
            }

            @Override
            public Font getTextButtonFont() {
                return this.getFont(EnumFontSize.Medium);
            }
        };


    }

    @Override
    public ITextButtonSection getTextButtonSection() {
        final ThemeBase themeBase = this;

        return new ITextButtonSection() {
            @Override
            public ITexturesSetResourceInfo getTexturesSetResourceInfo() {
                ITexturesSetResourceInfo retval = null;

                try {
                    retval = themeBase.getTextButtonTexturesSetResourceInfo();
                } catch (EResourceNotFound eResourceNotFound) {
                    eResourceNotFound.printStackTrace();
                }

                return retval;
            }
        };
    }

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
    protected abstract com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo getTextButtonTexturesSetResourceInfo() throws EResourceNotFound;


    private Font getTheFont(EnumFontSize eFontSize) throws EResourceNotFound {

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
