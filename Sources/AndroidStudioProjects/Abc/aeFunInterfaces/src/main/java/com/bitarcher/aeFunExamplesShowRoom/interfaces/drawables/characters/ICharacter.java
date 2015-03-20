package com.bitarcher.aeFunExamplesShowRoom.interfaces.drawables.characters;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFunExamplesShowRoom.interfaces.basicioc.INamed;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.basicioc.IService;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.IResourceManagerLinked;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.resourcemanagement.IResourceRequirementsStackUser;

import org.andengine.entity.IEntity;

/**
 * Created by michel on 18/03/15.
 */
public interface ICharacter extends IEntity, INamed, IResourceManagerLinked, IResourceRequirementsStackUser, IService {
    void setMainPosition(EnumSide side, EnumMainPosition mainPosition);
    float getAspectRatio(); // width / height
}
