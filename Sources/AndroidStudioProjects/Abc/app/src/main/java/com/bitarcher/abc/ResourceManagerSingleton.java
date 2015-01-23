/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abc;

import com.bitarcher.resourcemanagement.ResourceManager;

/**
 * Created by michel on 23/01/15.
 */
public class ResourceManagerSingleton extends ResourceManager {
    private static ResourceManagerSingleton ourInstance = new ResourceManagerSingleton();

    public static ResourceManagerSingleton getInstance() {
        return ourInstance;
    }

    private ResourceManagerSingleton() {
    }


}
