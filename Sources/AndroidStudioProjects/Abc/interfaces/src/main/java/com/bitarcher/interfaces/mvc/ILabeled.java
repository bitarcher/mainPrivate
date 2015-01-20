package com.bitarcher.interfaces.mvc;

/**
 * Created by michel on 20/01/15.
 */
public interface ILabeled {
    String getTranslatedLabel();

    void addLabeledListener(ILabeledListener labeled);
    void removeLabeledListener(ILabeledListener labeled);
}
