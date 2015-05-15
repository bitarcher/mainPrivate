package com.bitarcher.abc.gameLevels.consonantAndVowel.vowel;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.basicioc.ITFactory;

/**
 * Created by michel on 15/05/15.
 */
public class VowelPronunciationFactory implements ITFactory<String, EnumVowel> {
    @Override
    public String make(EnumVowel enumVowel) {
        String retval = "";

        switch (enumVowel)
        {
            case a:
                retval = "a";
                break;
            case e:
                retval = "eux";
                break;
            case i:
                retval = "i";
                break;
            case o:
                retval = "o";
                break;
            case u:
                retval = "u";
                break;
            case y:
                retval = "i grec";
                break;
        }

        return retval;
    }
}
