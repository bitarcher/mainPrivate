package com.bitarcher.abc.bll.xml.ro;

import com.bitarcher.interfaces.bll.xml.abc.ro.IAnimal;
import com.bitarcher.interfaces.bll.xml.abc.ro.IDinosaur;
import com.bitarcher.interfaces.bll.xml.abc.ro.ILetter;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 19/12/14.
 */
public class Letter implements ILetter {

    int _position;
    char _char;
    java.util.List<IAnimal> _animalList;
    List<IDinosaur> _dinosaurList;

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

                if(name == "Animal") {
                    Animal animal = new Animal();

                    animal.fromXml(childElement);

                    this._animalList.add(animal);
                }
                else if (name == "Dinosaur") {
                    Dinosaur dinosaur = new Dinosaur();

                    dinosaur.fromXml(childElement);

                    this._dinosaurList.add(dinosaur);
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
    public java.util.List<IAnimal> getAnimalList() {
        return this._animalList;
    }

    @Override
    public List<IDinosaur> getDinosaurList() {
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
