package com.bitarcher.interfacesProtected.bll.xml.abc.ro.resources;

import com.bitarcher.interfaces.basicioc.IXmlReader;

import java.util.List;

/**
 * Created by michel on 19/12/14.
 */
public interface IIdiograms extends IXmlReader {
    List<IIdiogram> getIdiogramList();

    IIdiogram getIdiogramByName(String name);
}
