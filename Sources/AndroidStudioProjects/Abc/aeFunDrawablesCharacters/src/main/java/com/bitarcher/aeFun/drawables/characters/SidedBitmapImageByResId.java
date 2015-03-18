package com.bitarcher.aeFun.drawables.characters;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import android.content.Context;

import com.bitarcher.aeFun.interfaces.drawables.characters.EnumSide;
import com.bitarcher.aeFun.interfaces.drawables.characters.ICharacter;
import com.bitarcher.aeFun.interfaces.drawables.characters.ISidedImage;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SingleBitmapTextureSetFromResIdsResourceInfo;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;

/**
 * Created by michel on 18/03/15.
 */
public class SidedBitmapImageByResId extends SingleBitmapTextureSetFromResIdsResourceInfo implements ISidedImage {

    EnumSide side;

    ICharacter character;

    public ICharacter getCharacter() {
        return character;
    }

    @Override
    public EnumSide getSide() {
        return side;
    }

    public SidedBitmapImageByResId(ICharacter character, String positionName, int textureWidth, int textureHeight, BitmapTextureFormat bitmapTextureFormat, TextureOptions textureOptions, int resId, EnumSide side) {
        super(character.getName() + "_" + side.name() + "_" + positionName, textureWidth, textureHeight, bitmapTextureFormat, textureOptions, character.getResourceManager().getContext(), resId);
        this.character = character;
        this.side = side;
    }
}

