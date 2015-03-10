package com.bitarcher.aefun.widgetLayout.theme;

import android.content.Context;
import android.graphics.Typeface;

import com.bitarcher.aeFun.interfaces.gui.theme.IArrows;
import com.bitarcher.aeFun.interfaces.gui.theme.IFontThemeSection;
import com.bitarcher.aeFun.interfaces.gui.theme.ILayoutFactory;
import com.bitarcher.aeFun.interfaces.gui.theme.IThemeManager;
import com.bitarcher.aeFun.interfaces.gui.theme.widgetSections.IWidgetSections;
import com.bitarcher.aeFun.interfaces.resourcemanagement.EResourceNotFound;

import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.Font.FontCreateFromTypeFaceResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneResSvgTexture;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SvgTexturesSetFromResIdsResourceInfo;
import com.bitarcher.aefun.widgetLayout.DefaultLayoutFactory;
import com.bitarcher.aefun.widgetLayout.R;
import com.bitarcher.aefun.widgetLayout.porcelain.DefaultFontThemeSection;
import com.bitarcher.aefun.widgetLayout.porcelain.DefaultWidgetSections;
//import com.bitarcher.widgettoolkit.R;

import org.andengine.extension.svg.adt.ISVGColorMapper;
import org.andengine.opengl.font.Font;
import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 21/01/15.
 */
public class DefaultTheme extends ThemeBase {



    public DefaultTheme(IThemeManager themeManager, String name) {
        super(themeManager, name);


    }

    @Override
    protected ILayoutFactory getNewLayoutFactory() {
        return new DefaultLayoutFactory();
    }

    @Override
    protected IWidgetSections getNewWidgetSections() {
        return new DefaultWidgetSections(this);
    }

    @Override
    protected IFontThemeSection getNewFontThemeSection() {
        return new DefaultFontThemeSection(this);
    }
}
