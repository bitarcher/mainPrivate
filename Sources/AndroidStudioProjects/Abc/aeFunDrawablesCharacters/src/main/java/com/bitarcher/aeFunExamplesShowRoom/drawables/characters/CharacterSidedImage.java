package com.bitarcher.aeFunExamplesShowRoom.drawables.characters;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFunExamplesShowRoom.interfaces.drawables.characters.EnumSide;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.drawables.characters.ICharacter;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.drawables.characters.ICharacterSidedImage;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.mvc.IImage;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;

/**
 * Created by michel on 19/03/15.
 */
public class CharacterSidedImage implements ICharacterSidedImage {
    IImage image;
    EnumSide side;
    ICharacter character;

    public IImage getImage() {
        return image;
    }

    @Override
    public EnumSide getSide() {
        return side;
    }

    @Override
    public ICharacter getCharacter() {
        return this.character;
    }

    @Override
    public ITexturesSetResourceInfo getTextureSetResourceInfo() {
        return this.image.getTextureSetResourceInfo();
    }

    @Override
    public String getTextureName() {
        return this.image.getTextureName();
    }

    public CharacterSidedImage(IImage image, EnumSide side, ICharacter character) {
        this.image = image;
        this.side = side;
        this.character = character;
    }
}
