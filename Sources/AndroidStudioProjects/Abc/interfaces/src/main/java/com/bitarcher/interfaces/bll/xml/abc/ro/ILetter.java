package com.bitarcher.interfaces.bll.xml.abc.ro;

import com.bitarcher.interfaces.basicioc.IXmlReader;

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
