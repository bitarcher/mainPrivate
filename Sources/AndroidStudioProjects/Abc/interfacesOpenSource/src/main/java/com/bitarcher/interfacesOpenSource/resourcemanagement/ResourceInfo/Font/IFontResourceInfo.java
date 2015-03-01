package com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.Font;

import com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.IResourceInfo;


/**
 * Created by michel on 12/01/15.
 */
public interface IFontResourceInfo extends IResourceInfo {
    int getTextureWidth();
    int getTextureHeight();
    float getFontSize();
    int getForeColor();
    boolean isAntialiased();
}
