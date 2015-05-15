package com.bitarcher.speaker;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import android.content.Context;
import android.speech.tts.TextToSpeech;

import com.bitarcher.interfaces.speaker.IAlternativeSpeeches;
import com.bitarcher.interfaces.speaker.ISpeaker;

import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.Random;

/**
 * Created by michel on 03/05/15.
 */
public class Speaker implements ISpeaker, TextToSpeech.OnInitListener {
    Random random;

    @Nullable
    Locale locale;

    @Nullable
    IAlternativeSpeeches initAlternativeSpeeches;

    TextToSpeech ttsEngine;
    Context context;

    public Speaker(Context context) {
        this(context, null, null);
    }

    public Speaker(Context context, Locale locale, IAlternativeSpeeches initAlternativeSpeeches) {
        this.random = new Random();
        this.locale = locale;
        this.initAlternativeSpeeches = initAlternativeSpeeches;
        this.context = context;

        this.ttsEngine = new TextToSpeech(context, this);
    }

    @Override
    public void say(IAlternativeSpeeches alternativeSpeeches, Object... args) {
        this.say(TextToSpeech.QUEUE_FLUSH, alternativeSpeeches, args);
    }

    @Override
    public void say(int queueMode, IAlternativeSpeeches alternativeSpeeches, Object... args) {

        int ind = this.random.nextInt(alternativeSpeeches.getTranslatedFormatsList().size());
        String fmt = alternativeSpeeches.getTranslatedFormatsList().get(ind);
        String formated = String.format(fmt, args);

        this.ttsEngine.speak(formated, queueMode, null);
    }


    @Override
    public void onInit(int status) {

        if(this.locale != null) {
            this.ttsEngine.setLanguage(this.locale);
        }

        if(this.initAlternativeSpeeches != null) {
            this.say(this.initAlternativeSpeeches);
        }
    }
}
