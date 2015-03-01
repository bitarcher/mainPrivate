package com.bitarcher.abc.bll.xml.ro.resources;

import com.bitarcher.interfacesOpenSource.bll.xml.abc.ro.resources.ILetter;
import com.bitarcher.interfacesOpenSource.bll.xml.abc.ro.resources.ILetters;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by michel on 19/12/14.
 */
public class Letters implements ILetters {
    ArrayList<ILetter> _letterList;
    HashMap<Character, ILetter> _dict;

    public Letters() {
        this._letterList = new ArrayList<ILetter>();
        this._dict = new HashMap<Character, ILetter>();
    }

    @Override
    public List<ILetter> getLetterList() {
        return this._letterList;
    }

    @Override
    public Map<Character, ILetter> getLetterByChar(char c) {
        return this._dict;
    }

    @Override
    public void fromXml(Element element) {
        int position = 0;

        for (Node childNode = element.getFirstChild(); childNode != null; ) {
            Node nextChild = childNode.getNextSibling();
            // Do something with childNode, including move or delete...

            if (childNode instanceof Element) {
                Element childElement = (Element) childNode;

                String name = childElement.getNodeName();

                if(name == "Letter") {

                    Letter letter = new Letter(position);
                    position++;

                    letter.fromXml(childElement);

                    this._letterList.add(letter);
                    this._dict.put(letter.getChar(), letter);


                }
            }

            childNode = nextChild;
        }

    }
}
