package com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos;

import org.andengine.extension.svg.adt.ISVGColorMapper;
import org.jetbrains.annotations.Nullable;

/**
 * Created by michel on 13/01/15.
 */
public interface IOneSvgTexture extends IOneTexture {
    int getWidth();
    int getHeight();
    // may return null
    @Nullable
    ISVGColorMapper getSvgColorMapper();
}
