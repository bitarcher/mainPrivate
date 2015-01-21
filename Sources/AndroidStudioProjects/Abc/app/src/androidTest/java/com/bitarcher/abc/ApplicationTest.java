package com.bitarcher.abc;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.bitarcher.abc.bll.xml.ro.levels.Node;
import com.bitarcher.abc.bll.xml.ro.resources.ResList;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }


/*
    public void testFailed() throws Exception{
        final int expected = 1;
        final int reality = 5;
        assertEquals(expected, reality);
    }
*/


    public void testLoadingLevelsXml() throws Exception
    {
        Node rootNode =null;
        try {
            DocumentBuilderFactory DOMfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder DOMbuilder = DOMfactory.newDocumentBuilder();


            Document doc = DOMbuilder.parse(this.getContext().getResources().getAssets().open("Levels.xml"));
            Node node = new Node(null);
            node.fromXml(doc.getDocumentElement());

        } catch (ParserConfigurationException e) {

            e.printStackTrace();
        }
    }

    public void testLoadingResourcesXml() throws Exception
    {
        Node rootNode =null;
        try {
            DocumentBuilderFactory DOMfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder DOMbuilder = DOMfactory.newDocumentBuilder();


            Document doc = DOMbuilder.parse(this.getContext().getResources().getAssets().open("ResList.xml"));

            ResList resList = new ResList();

            resList.fromXml(doc.getDocumentElement());

        } catch (ParserConfigurationException e) {

            e.printStackTrace();
        }
    }
}