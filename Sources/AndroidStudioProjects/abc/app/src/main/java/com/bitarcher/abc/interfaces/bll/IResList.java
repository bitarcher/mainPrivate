package com.bitarcher.abc.interfaces.bll;

import com.bitarcher.abc.interfaces.IXmlReader;

import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by michel on 19/12/14.
 */
public interface IResList extends IXmlReader {
    ILetters getLetters();

    IIdiograms getIdiograms();

    void fromXmlFile(String filename) throws IOException, SAXException, ParserConfigurationException;
}
