package com.bitarcher.abc.interfaces.bll;

import com.bitarcher.abc.interfaces.IXmlReader;

import java.util.List;

/**
 * Created by michel on 19/12/14.
 */
public interface IIdiograms extends IXmlReader {
    List<IIdiogram> getIdiogramList();

    IIdiogram getIdiogramByName(String name);
}
