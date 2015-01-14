package com.bitarcher.interfaces.bll.xml.abc.ro;

import com.bitarcher.interfaces.basicioc.IXmlReader;

import java.util.List;

/**
 * Created by michel on 19/12/14.
 */
public interface IIdiograms extends IXmlReader {
    List<IIdiogram> getIdiogramList();

    IIdiogram getIdiogramByName(String name);
}
