package com.bitarcher.widgettoolkit.theme;

import android.graphics.Typeface;

import com.bitarcher.interfaces.gui.theme.IThemeManager;
import com.bitarcher.interfaces.resourcemanagement.EResourceNotFound;
import com.bitarcher.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.resourcemanagement.ResourcesInfos.Font.FontCreateFromTypeFaceResourceInfo;
import com.bitarcher.resourcemanagement.ResourcesInfos.SubInfos.OneSvgTexture;
import com.bitarcher.resourcemanagement.ResourcesInfos.SvgTexturesSetResourceInfo;

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
    protected SvgTexturesSetResourceInfo textButtonSvgTexturesSetResourceInfo;

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
        int c = 256;
        this.bigFontResourceInfo =new FontCreateFromTypeFaceResourceInfo("@default/bigFont", c, c, 20, Color.BLACK_ARGB_PACKED_INT, true,
                Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        this.mediumFontResourceInfo =new FontCreateFromTypeFaceResourceInfo("@default/mediumFont", c, c, 15, Color.BLACK_ARGB_PACKED_INT, true,
                Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
        this.smallFontResourceInfo =new FontCreateFromTypeFaceResourceInfo("@default/smallFont", c, c, 12, Color.BLACK_ARGB_PACKED_INT, true,
                Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
    }

    protected void setTextButtonSvgTexturesSetResourceInfo()
    {
        int c = 256;

        // remember the resourceInfo is pushed on and popped from the resource manager by the widget itself
        this.textButtonSvgTexturesSetResourceInfo = new SvgTexturesSetResourceInfo("@default/textButtonSvgTextureSet", c, c, "theme/default/textbutton/");

        int c3 = c / 3;

        ISVGColorMapper colorMapper = this.getTextButtonSvgTexturesSetColorMapper();

        if(colorMapper != null) {
            this.textButtonSvgTexturesSetResourceInfo.addOneTexture(new OneSvgTexture("normal", "textButton_normal.svg", c, c3, colorMapper));
            this.textButtonSvgTexturesSetResourceInfo.addOneTexture(new OneSvgTexture("pressed", "textButton_pressed.svg", c, c3, colorMapper));
            this.textButtonSvgTexturesSetResourceInfo.addOneTexture(new OneSvgTexture("disabled", "textButton_disabled.svg", c, c3, colorMapper));
        }
        else {
            this.textButtonSvgTexturesSetResourceInfo.addOneTexture(new OneSvgTexture("normal", "textButton_normal.svg", c, c3));
            this.textButtonSvgTexturesSetResourceInfo.addOneTexture(new OneSvgTexture("pressed", "textButton_pressed.svg", c, c3));
            this.textButtonSvgTexturesSetResourceInfo.addOneTexture(new OneSvgTexture("disabled", "textButton_disabled.svg", c, c3));
        }
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
}
