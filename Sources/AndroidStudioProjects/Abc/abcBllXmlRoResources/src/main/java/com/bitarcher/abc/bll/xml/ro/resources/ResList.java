package com.bitarcher.abc.bll.xml.ro.resources;

import com.bitarcher.aeFun.bll.xml.abc.ro.resources.IIdiograms;
import com.bitarcher.aeFun.bll.xml.abc.ro.resources.ILetters;
import com.bitarcher.aeFun.bll.xml.abc.ro.resources.IResList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Created by michel on 19/12/14.
 */
public class ResList implements IResList {
    ILetters _letters;
    IIdiograms _idiograms;

    @Override
    public ILetters getLetters() {
        return this._letters;
    }

    @Override
    public IIdiograms getIdiograms() {
        return this._idiograms;
    }

    @Override
    public void fromXmlFile(String filename) throws IOException, SAXException, ParserConfigurationException {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(filename);

            this.fromXml(doc.getDocumentElement());
    }

    @Override
    public void fromXml(Element element) {

        for (Node childNode = element.getFirstChild(); childNode != null; ) {
            Node nextChild = childNode.getNextSibling();
            // Do something with childNode, including move or delete...

            if (childNode instanceof Element) {
                Element childElement = (Element) childNode;

                String name = childElement.getNodeName();

                if(name == "Letters") {

                    this._letters = new Letters();

                    this._letters.fromXml(childElement);
                }
                else if (name == "Idiograms")  {
                        this._idiograms = new Idiograms();

                        this._idiograms.fromXml(childElement);
                }
            }

            childNode = nextChild;
        }

    }
}
