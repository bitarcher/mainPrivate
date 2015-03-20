package com.bitarcher.aeFunExamplesShowRoom.interfaces.mvc;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;

/**
 * Created by michel on 20/01/15.
 */
public interface IImage {
    ITexturesSetResourceInfo getTextureSetResourceInfo();
    String getTextureName();
}

