package com.bitarcher.interfaces.speaker;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 03/05/15.
 */
public interface IAlternativeSpeeches {
    List<String> getTranslatedFormatsList();

    void addAlternativeSpeech(String translatedFmt);
}
