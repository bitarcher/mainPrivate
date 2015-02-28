package com.bitarcher.interfaces.mvc;

/**
 * Created by michel on 20/01/15.
 */
public interface IListItem {
    String getTranslatedLabel(ITextColumn textColumn);
    IImageTuple getImageTuple(IImageColumn imageColumn);
}
