package com.bitarcher.dog;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 16/03/15.
 */
public class ResourceInfosSingleton {
    private static ResourceInfosSingleton ourInstance = new ResourceInfosSingleton();

    public static ResourceInfosSingleton getInstance() {
        return ourInstance;
    }

    private ResourceInfosSingleton() {
    }


}
