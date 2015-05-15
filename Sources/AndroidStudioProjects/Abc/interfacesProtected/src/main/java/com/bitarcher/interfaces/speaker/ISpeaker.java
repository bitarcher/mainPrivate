package com.bitarcher.interfaces.speaker;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 03/05/15.
 */
public interface ISpeaker {
    void say(IAlternativeSpeeches alternativeSpeeches, Object... args);
    void say(int queueMode, IAlternativeSpeeches alternativeSpeeches, Object... args);

}
