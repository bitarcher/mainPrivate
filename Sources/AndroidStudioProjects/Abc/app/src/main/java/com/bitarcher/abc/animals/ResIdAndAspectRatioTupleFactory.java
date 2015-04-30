package com.bitarcher.abc.animals;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.basicioc.ITFactory;

/**
 * Created by michel on 30/04/15.
 */
public class ResIdAndAspectRatioTupleFactory implements ITFactory<ResIdAndAspectRatioTuple,EnumAnimal> {
    @Override
    public ResIdAndAspectRatioTuple make(EnumAnimal enumAnimal) {
        ResIdAndAspectRatioTuple retval = null;

        switch (enumAnimal)
        {
            // TODO

            default:
                throw new RuntimeException("Not implemented animal resIds and aspect ratio " + enumAnimal.name());
        }

        return retval;
    }
}
