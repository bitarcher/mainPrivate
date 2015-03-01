package com.bitarcher.resourcemanagement.MapValues;

import com.bitarcher.interfacesOpenSource.basicioc.ITValue;

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
