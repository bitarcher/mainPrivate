package com.bitarcher.interfaces.mvc;

/**
 * Created by michel on 20/01/15.
 */
public interface ILabeled {
    String getTranslatedLabel();

    void addLabeledListened(ILabeled labeled);
    void removeLabeledListened(ILabeled labeled);
}
