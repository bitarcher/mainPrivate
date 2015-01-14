package com.bitarcher.interfaces.basicioc;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

import java.io.*;


/**
 * Created by michel on 19/12/14.
 */
public interface IXmlReader {
    void fromXml(Element element);
}
