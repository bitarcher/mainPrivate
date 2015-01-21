package com.bitarcher.widgettoolkit.theme;

import android.graphics.Typeface;

import com.bitarcher.interfaces.gui.IThemeManager;
import com.bitarcher.interfaces.resourcemanagement.EResourceNotFound;
import com.bitarcher.resourcemanagement.ResourcesInfos.Font.FontCreateFromTypeFaceResourceInfo;

import org.andengine.opengl.font.Font;
import org.andengine.util.adt.color.Color;

/**
 * Created by michel on 21/01/15.
 */
public class DefaultTheme extends ThemeBase {
    protected FontCreateFromTypeFaceResourceInfo bigFontResourceInfo;
    protected FontCreateFromTypeFaceResourceInfo mediumFontResourceInfo;
    protected FontCreateFromTypeFaceResourceInfo smallFontResourceInfo;

    public FontCreateFromTypeFaceResourceInfo getBigFontResourceInfo()
    {
        return this.bigFontResourceInfo;
    }


    public DefaultTheme(IThemeManager themeManager, String name) {
        super(themeManager, name);

        this.setFontResourceInfos();
    }

    protected void setFontResourceInfos()
    {
        this.bigFontResourceInfo =new FontCreateFromTypeFaceResourceInfo("@default/bigFont", 256, 256, 20, Color.BLACK_ARGB_PACKED_INT, true,
                Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        this.mediumFontResourceInfo =new FontCreateFromTypeFaceResourceInfo("@default/mediumFont", 256, 256, 15, Color.BLACK_ARGB_PACKED_INT, true,
                Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
        this.smallFontResourceInfo =new FontCreateFromTypeFaceResourceInfo("@default/smallFont", 256, 256, 12, Color.BLACK_ARGB_PACKED_INT, true,
                Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
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
}
