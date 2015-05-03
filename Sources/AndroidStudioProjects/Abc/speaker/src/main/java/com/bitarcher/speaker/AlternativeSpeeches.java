package com.bitarcher.speaker;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.interfaces.speaker.IAlternativeSpeeches;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 03/05/15.
 */
public class AlternativeSpeeches implements IAlternativeSpeeches{

    ArrayList<String> translatedFormatsList = new ArrayList<>();

    @Override
    public List<String> getTranslatedFormatsList() {
        return this.translatedFormatsList;
    }

    @Override
    public void addAlternativeSpeech(String translatedFmt) {
        this.translatedFormatsList.add(translatedFmt);
    }
}
