package com.bitarcher.widgettoolkit.theme;

import android.content.Context;
import android.graphics.Typeface;

import com.bitarcher.interfacesProtected.gui.theme.IArrows;
import com.bitarcher.interfacesProtected.gui.theme.IThemeManager;
import com.bitarcher.interfacesProtected.resourcemanagement.EResourceNotFound;

import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.resourcemanagement.ResourcesInfos.Font.FontCreateFromTypeFaceResourceInfo;
import com.bitarcher.resourcemanagement.ResourcesInfos.SubInfos.OneResSvgTexture;
import com.bitarcher.resourcemanagement.ResourcesInfos.SvgTexturesSetFromResIdsResourceInfo;
import com.bitarcher.widgettoolkit.R;

import org.andengine.extension.svg.adt.ISVGColorMapper;
import org.andengine.opengl.font.Font;
import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 21/01/15.
 */
public class DefaultTheme extends ThemeBase {
    protected FontCreateFromTypeFaceResourceInfo bigFontResourceInfo;
    protected FontCreateFromTypeFaceResourceInfo mediumFontResourceInfo;
    protected FontCreateFromTypeFaceResourceInfo smallFontResourceInfo;
    protected SvgTexturesSetFromResIdsResourceInfo textButtonSvgTexturesSetResourceInfo;

    public FontCreateFromTypeFaceResourceInfo getBigFontResourceInfo()
    {
        return this.bigFontResourceInfo;
    }


    public DefaultTheme(IThemeManager themeManager, String name) {
        super(themeManager, name);

        this.setFontResourceInfos();
        this.setTextButtonSvgTexturesSetResourceInfo();
    }

    protected void setFontResourceInfos()
    {
        int c = 1024;
        this.bigFontResourceInfo =new FontCreateFromTypeFaceResourceInfo("@default/bigFont", c, c, 36, Color.BLACK_ARGB_PACKED_INT, true,
                Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        this.mediumFontResourceInfo =new FontCreateFromTypeFaceResourceInfo("@default/mediumFont", c, c, 32, Color.BLACK_ARGB_PACKED_INT, true,
                Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
        this.smallFontResourceInfo =new FontCreateFromTypeFaceResourceInfo("@default/smallFont", c, c, 28, Color.BLACK_ARGB_PACKED_INT, true,
                Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
    }

    protected void setTextButtonSvgTexturesSetResourceInfo()
    {
        int c = 256;

        // remember the resourceInfo is pushed on and popped from the resource manager by the widget itself
        //Context context = WidgetToolkitApp.getContext();
        Context context = this.getThemeManager().getResourceManager().getContext();
        this.textButtonSvgTexturesSetResourceInfo = new SvgTexturesSetFromResIdsResourceInfo("@default/textButtonSvgTextureSet", context, c, c);

        int securityPadding = 30;
        int c2 = c - securityPadding;
        int c3 = c2 / 3;

        // may be null
        ISVGColorMapper colorMapper = this.getTextButtonSvgTexturesSetColorMapper();


        this.textButtonSvgTexturesSetResourceInfo.addOneTexture(new OneResSvgTexture("normal", R.raw.d_text_button_normal, c2, c3, colorMapper));
        this.textButtonSvgTexturesSetResourceInfo.addOneTexture(new OneResSvgTexture("pressed", R.raw.d_text_button_pressed, c2, c3, colorMapper));
        this.textButtonSvgTexturesSetResourceInfo.addOneTexture(new OneResSvgTexture("disabled", R.raw.d_text_button_disabled, c2, c3, colorMapper));

    }

    protected  ISVGColorMapper getTextButtonSvgTexturesSetColorMapper()
    {
        return null;
    }

    @Override
    protected void onPushFontRequirements() {
        super.onPushFontRequirements();

        this.getThemeManager().getResourceManager().pushRequirement(this.bigFontResourceInfo);
        this.getThemeManager().getResourceManager().pushRequirement(this.mediumFontResourceInfo);
        this.getThemeManager().getResourceManager().pushRequirement(this.smallFontResourceInfo);

    }

    @Override
    protected void onPopFontRequirements() throws EResourceNotFound {
        super.onPopFontRequirements();

        this.getThemeManager().getResourceManager().popRequirement(this.bigFontResourceInfo);
        this.getThemeManager().getResourceManager().popRequirement(this.mediumFontResourceInfo);
        this.getThemeManager().getResourceManager().popRequirement(this.smallFontResourceInfo);
    }

    @Override
    protected Font getBigFont() throws EResourceNotFound {
        return this.getThemeManager().getResourceManager().getFont(this.bigFontResourceInfo);
    }

    @Override
    protected Font getMediumFont() throws EResourceNotFound {
        return this.getThemeManager().getResourceManager().getFont(this.mediumFontResourceInfo);
    }

    @Override
    protected Font getSmallFont() throws EResourceNotFound {
        return this.getThemeManager().getResourceManager().getFont(this.smallFontResourceInfo);
    }

    @Override
    protected ITexturesSetResourceInfo getTextButtonTexturesSetResourceInfo() throws EResourceNotFound {
        return this.textButtonSvgTexturesSetResourceInfo;
    }

    IArrows arrows;

    @Override
    public IArrows getArrows() {

        if(this.arrows == null)
        {
            Context context = getThemeManager().getResourceManager().getContext();

            this.arrows = new DefaultArrows(context);
        }

        return this.arrows;
    }
}
