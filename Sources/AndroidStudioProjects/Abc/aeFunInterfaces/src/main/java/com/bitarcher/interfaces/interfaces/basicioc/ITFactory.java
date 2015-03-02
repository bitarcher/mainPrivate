package com.bitarcher.interfaces.interfaces.basicioc;

/**
 * Created by michel on 08/01/15.
 */
public interface ITFactory<TBuilt, TKey> {
    TBuilt make(TKey key);
}
