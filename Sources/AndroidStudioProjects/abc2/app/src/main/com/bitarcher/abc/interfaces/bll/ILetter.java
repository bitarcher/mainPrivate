package com.bitarcher.abc.interfaces.bll;

import com.bitarcher.abc.interfaces.IXmlReader;

import java.util.List;

/**
 * Created by michel on 19/12/14.
 */
public interface ILetter extends IXmlReader {
    int getPosition();

    char getChar();

    List<IAnimal> getAnimalList();

    List<IDinosaur> getDinosaurList();

    IAnimal getAnimalByName(String name);
}
