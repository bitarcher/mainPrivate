package com.bitarcher.abc.bll;

import com.bitarcher.abc.interfaces.IXmlReader;
import com.bitarcher.abc.interfaces.bll.IAnimal;
import com.bitarcher.abc.interfaces.bll.IDinosaur;
import com.bitarcher.abc.interfaces.bll.ILetter;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 19/12/14.
 */
public class Letter implements ILetter {

    int _position;
    char _char;
    java.util.List<com.bitarcher.abc.interfaces.bll.IAnimal> _animalList;
    List<com.bitarcher.abc.interfaces.bll.IDinosaur> _dinosaurList;

    public Letter(int position) {
        this._position = position;
        this._animalList = new ArrayList<IAnimal>();
        this._dinosaurList = new ArrayList<IDinosaur>();
    }

    @Override
    public void fromXml(Element element) {
        this._char = element.getAttribute("char").charAt(0);

        for (Node childNode = element.getFirstChild(); childNode != null; ) {
            Node nextChild = childNode.getNextSibling();
            // Do something with childNode, including move or delete...

            if (childNode instanceof Element) {
                Element childElement = (Element) childNode;

                String name = childElement.getNodeName();

                switch (name) {
                    case "Animal":
                        Animal animal = new Animal();

                        animal.fromXml(childElement);

                        this._animalList.add(animal);
                        break;
                    case "Dinosaur":
                        Dinosaur dinosaur = new Dinosaur();

                        dinosaur.fromXml(childElement);

                        this._dinosaurList.add(dinosaur);
                        break;
                }
            }

            childNode = nextChild;
        }
    }

    @Override
    public int getPosition() {
        return this._position;
    }

    @Override
    public char getChar() {
        return this._char;
    }

    @Override
    public java.util.List<com.bitarcher.abc.interfaces.bll.IAnimal> getAnimalList() {
        return this._animalList;
    }

    @Override
    public List<com.bitarcher.abc.interfaces.bll.IDinosaur> getDinosaurList() {
        return this._dinosaurList;
    }

    @Override
    public IAnimal getAnimalByName(String name) {

        IAnimal retval = null;

        for (IAnimal animal : this._animalList) {
            if (animal.getName() == name) {
                retval = animal;
                break;
            }
        }

        return retval;
    }
}
