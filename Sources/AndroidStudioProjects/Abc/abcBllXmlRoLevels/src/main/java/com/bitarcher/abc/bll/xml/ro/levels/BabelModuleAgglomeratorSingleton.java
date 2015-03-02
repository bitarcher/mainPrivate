package com.bitarcher.abc.bll.xml.ro.levels;

import com.bitarcher.aeFun.interfaces.globalization.babel.IBabelModuleAgglomeratorListener;
import com.bitarcher.aeFun.interfaces.globalization.babel.IModuleAgglomerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 20/01/15.
 */
public class BabelModuleAgglomeratorSingleton implements IModuleAgglomerator {
    ArrayList<IBabelModuleAgglomeratorListener> babelModuleAgglomeratorListeners = new ArrayList<>();

    private static BabelModuleAgglomeratorSingleton ourInstance = new BabelModuleAgglomeratorSingleton();

    public static BabelModuleAgglomeratorSingleton getInstance() {
        return ourInstance;
    }

    private BabelModuleAgglomeratorSingleton() {
    }

    @Override
    public String translate(Object applicant, String fmt, Object... args) {
        // TODO dependency inversion
        return String.format(fmt, args);
    }

    @Override
    public void addBabelModuleAgglomeratorListener(IBabelModuleAgglomeratorListener babelModuleAgglomeratorListener) {
        this.babelModuleAgglomeratorListeners.add(babelModuleAgglomeratorListener);
    }

    @Override
    public void removeBabelModuleAgglomeratorListener(IBabelModuleAgglomeratorListener babelModuleAgglomeratorListener) {
        this.babelModuleAgglomeratorListeners.remove(babelModuleAgglomeratorListener);
    }

    @Override
    public List<IModuleAgglomerator> getSubAgglomerators() {
        ArrayList<IModuleAgglomerator> retval = new ArrayList<>();

        return retval;
    }
}
