package com.bitarcher.abc.gameLevels.consonantAndVowel.vowel;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 13/05/15.
 */
public class VowelsResourceInfosSingleton  extends VowelsResourceInfos{
    private static VowelsResourceInfosSingleton ourInstance = new VowelsResourceInfosSingleton();

    public static VowelsResourceInfosSingleton getInstance() {
        return ourInstance;
    }

    private VowelsResourceInfosSingleton() {
    }
}
