package com.bitarcher.abc.bll;

import com.bitarcher.abc.interfaces.bll.IIdiogram;
import com.bitarcher.abc.interfaces.bll.IIdiograms;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 19/12/14.
 */
public class Idiograms implements IIdiograms {
    ArrayList<IIdiogram> _idiogramList;


    public Idiograms() {
        this._idiogramList = new ArrayList<>();

    }

    @Override
    public List<IIdiogram> getIdiogramList() {
        return this._idiogramList;
    }

    @Override
    public IIdiogram getIdiogramByName(String name) {
        IIdiogram retval = null;

        for (IIdiogram idiogram : this._idiogramList) {
            if (idiogram.getName() == name) {
                retval = idiogram;
                break;
            }
        }

        return retval;
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

                switch (name) {
                    case "Idiogram":
                        Idiogram idiogram = new Idiogram();
                        position++;

                        idiogram.fromXml(childElement);

                        this._idiogramList.add(idiogram);
                        break;

                }
            }

            childNode = nextChild;
        }

    }
}
