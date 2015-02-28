package com.bitarcher.interfacesProtected.globalization.babel;

import com.bitarcher.interfacesProtected.basicioc.ITModuleAgglomerator;

/**
 * Created by michel on 20/01/15.
 */
public interface IModuleAgglomerator extends ITModuleAgglomerator<IModuleAgglomerator> {
    String translate(Object applicant, String fmt, Object ... args);

    void addBabelModuleAgglomeratorListener(IBabelModuleAgglomeratorListener babelModuleAgglomeratorListener);
    void removeBabelModuleAgglomeratorListener(IBabelModuleAgglomeratorListener babelModuleAgglomeratorListener);
}
