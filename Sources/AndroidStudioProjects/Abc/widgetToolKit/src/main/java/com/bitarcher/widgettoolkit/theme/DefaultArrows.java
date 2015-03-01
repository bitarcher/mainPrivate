/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.widgettoolkit.theme;

import android.content.Context;

import com.bitarcher.aeFun.interfaces.gui.theme.IArrows;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.resourcemanagement.ResourcesInfos.SubInfos.OneResSvgTexture;
import com.bitarcher.resourcemanagement.ResourcesInfos.SvgTexturesSetFromResIdsResourceInfo;
import com.bitarcher.widgettoolkit.R;

/**
 * Created by michel on 26/02/15.
 */
public class DefaultArrows implements IArrows {
    Context context;

    public DefaultArrows(Context context) {
        this.context = context;
    }

    SvgTexturesSetFromResIdsResourceInfo resourceInfo = null;

    @Override
    public ITexturesSetResourceInfo getArrowsTexturesSetResourceInfo() {

        if(this.resourceInfo == null) {
            this.resourceInfo = new SvgTexturesSetFromResIdsResourceInfo("@default_arrows", this.context, 1024, 256);

            int sizeX = 220;
            int sizeY = sizeX;

            this.resourceInfo.addOneTexture(new OneResSvgTexture("left", R.raw.d_arrow_left, sizeX, sizeY));
            this.resourceInfo.addOneTexture(new OneResSvgTexture("right", R.raw.d_arrow_right, sizeX, sizeY));
            this.resourceInfo.addOneTexture(new OneResSvgTexture("up", R.raw.d_arrow_up, sizeX, sizeY));
            this.resourceInfo.addOneTexture(new OneResSvgTexture("down", R.raw.d_arrow_down, sizeX, sizeY));
        }

        return this.resourceInfo;
    }
}
