package com.bitarcher.abc.bll.xml.ro.resources;

import com.bitarcher.interfaces.bll.xml.abc.ro.resources.EResourceLicense;
import com.bitarcher.interfaces.bll.xml.abc.ro.resources.IPicture;
import com.bitarcher.interfaces.interfaces.basicioc.IXmlReader;

import org.w3c.dom.Element;

/**
 * Created by michel on 19/12/14.
 */
public abstract class APictureBase implements IXmlReader, IPicture {
    String _name;
    String _img;
    EResourceLicense _license;
    String _author;
    String _reference;


    @Override
    public String getName() {
        return this._name;
    }

    @Override
    public String getImg() {
        return this._img;
    }

    @Override
    public EResourceLicense getLicense() {
        return this._license;
    }

    @Override
    public String getAuthor() {
        return this._author;
    }

    @Override
    public String getReference() {
        return this._reference;
    }

    @Override
    public void fromXml(Element element) {
        this._name = element.getAttribute("name");
        this._img = element.getAttribute("img");
        this._license = EResourceLicense.valueOf(element.getAttribute("license"));
        this._author = element.getAttribute("author");
        this._reference = element.getAttribute("reference");
    }
}
