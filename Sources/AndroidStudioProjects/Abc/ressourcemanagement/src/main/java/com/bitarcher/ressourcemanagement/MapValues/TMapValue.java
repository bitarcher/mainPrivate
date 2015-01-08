package com.bitarcher.ressourcemanagement.MapValues;

import com.bitarcher.interfaces.basicioc.ITValue;

/**
 * Created by michel on 08/01/15.
 */
public abstract class TMapValue<T> extends MapValue implements ITValue<T> {

    protected T _tObj;

    @Override
    public T getTValue() {
        return this._tObj;
    }
}
