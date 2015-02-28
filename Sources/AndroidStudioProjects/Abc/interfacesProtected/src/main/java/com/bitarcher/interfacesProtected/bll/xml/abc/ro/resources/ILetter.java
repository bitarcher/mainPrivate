package com.bitarcher.interfacesProtected.bll.xml.abc.ro.resources;

import com.bitarcher.interfacesProtected.basicioc.IXmlReader;

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
