package com.bitarcher.aeFun.bll.xml.abc.ro.resources;

import com.bitarcher.aeFun.interfaces.basicioc.IXmlReader;

import java.util.List;

/**
 * Created by michel on 19/12/14.
 */
public interface IIdiograms extends IXmlReader {
    List<IIdiogram> getIdiogramList();

    IIdiogram getIdiogramByName(String name);
}
