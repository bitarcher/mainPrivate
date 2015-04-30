package com.bitarcher.abc.animals;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.abc.MainMenu;
import com.bitarcher.aeFun.interfaces.basicioc.ITFactory;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SingleBitmapTextureSetFromAssetResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SingleBitmapTextureSetFromResIdsResourceInfo;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;

import java.util.HashMap;

/**
 * Created by michel on 30/04/15.
 */
public class AnimalResourceInfos implements ITFactory<SingleBitmapTextureSetFromResIdsResourceInfo, EnumAnimal> {

    ResIdAndAspectRatioTupleFactory resIdAndAspectRatioTupleFactory = new ResIdAndAspectRatioTupleFactory();
    HashMap<EnumAnimal, SingleBitmapTextureSetFromResIdsResourceInfo> hashMap = new HashMap<>();
    MainMenu mainMenu;

    public AnimalResourceInfos(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    int getAtlasWidth()
    {
        // TODO adapt
        return 512;
    }

    int getAtlasHeight()
    {
        // TODO adapt
        return 1024;
    }



    @Override
    public SingleBitmapTextureSetFromResIdsResourceInfo make(EnumAnimal enumAnimal) {

        SingleBitmapTextureSetFromResIdsResourceInfo retval = null;

        if(this.hashMap.containsKey(enumAnimal))
        {
            retval = this.hashMap.get(enumAnimal);
        }
        else
        {
            ResIdAndAspectRatioTuple resIdAndAspectRatioTuple = this.resIdAndAspectRatioTupleFactory.make(enumAnimal);

            retval = new SingleBitmapTextureSetFromResIdsResourceInfo(enumAnimal.name(),
                    this.getAtlasWidth(), this.getAtlasHeight(), BitmapTextureFormat.RGBA_4444, TextureOptions.DEFAULT, this.mainMenu.getSceneManager().getResourceManager().getContext(),
                    resIdAndAspectRatioTuple.resId,
                    resIdAndAspectRatioTuple.getAspectRatio());

            this.hashMap.put(enumAnimal, retval);
        }

        return retval;
    }


}
