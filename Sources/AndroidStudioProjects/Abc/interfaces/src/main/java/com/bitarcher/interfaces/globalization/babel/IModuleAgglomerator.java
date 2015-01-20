package com.bitarcher.interfaces.globalization.babel;

import com.bitarcher.interfaces.basicioc.ITModuleAgglomerator;

import java.util.Objects;

/**
 * Created by michel on 20/01/15.
 */
public interface IModuleAgglomerator extends ITModuleAgglomerator<IModuleAgglomerator> {
    String translate(Object applicant, String fmt, Object ... args);

    void addBabelModuleAgglomeratorListener(IBabelModuleAgglomeratorListener babelModuleAgglomeratorListener);
    void removeBabelModuleAgglomeratorListener(IBabelModuleAgglomeratorListener babelModuleAgglomeratorListener);
}
