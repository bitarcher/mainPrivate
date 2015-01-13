package com.bitarcher.ressourcemanagement.RessourcesInfos;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBitmapTexturesSetResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneBitmapTexture;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.SubInfos.IOneTexture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 10/01/15.
 */
public class BitmapTexturesSetResourceInfo extends TexturesSetResourceInfo<IOneBitmapTexture> implements IBitmapTexturesSetResourceInfo {
    public BitmapTexturesSetResourceInfo(String name, int atlasWidth, int atlasHeight, String assetsBase) {
        super(name, atlasWidth, atlasHeight, assetsBase);
    }
}
