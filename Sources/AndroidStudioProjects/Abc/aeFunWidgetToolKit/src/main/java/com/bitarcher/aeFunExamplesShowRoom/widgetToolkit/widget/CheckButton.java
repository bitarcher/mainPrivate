package com.bitarcher.aeFunExamplesShowRoom.widgetToolkit.widget;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.context.ICheckButtonContext;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.ICheckButton;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.mvc.ILabeledListener;
import com.bitarcher.aeFunExamplesShowRoom.widgetToolkit.widget.Tools.Checkable;

import java.util.ArrayList;

/**
 * Created by michel on 20/03/15.
 */
public class CheckButton extends Checkable<ICheckButtonContext> implements ICheckButton {

    String translatedLabel;
    ArrayList<ILabeledListener> labeledListenerArrayList = new ArrayList<>();

    public CheckButton(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(theme, pX, pY, pWidth, pHeight);

    }

    @Override
    public void addLabeledListener(ILabeledListener labeledListener) {
        this.labeledListenerArrayList.add(labeledListener);
    }

    @Override
    public void removeLabeledListener(ILabeledListener labeledListener) {
        this.labeledListenerArrayList.remove(labeledListener);
    }

    @Override
    public String getTranslatedLabel() {
        return translatedLabel;
    }

    @Override
    public void setTranslatedLabel(String translatedLabel) {
        this.translatedLabel = translatedLabel;

        this.onTranslatedLabelChanged();

        for(ILabeledListener labeledListener: this.labeledListenerArrayList)
        {
            labeledListener.onLabelChanged(this);
        }
    }

    protected void onTranslatedLabelChanged()
    {
        if(this.getLayout() != null)
        {
            this.getLayout().getContext().setTranslatedLabel(this.translatedLabel);
        }
    }

    @Override
    public void dispose() {
        super.dispose();

        this.labeledListenerArrayList.clear();
    }
}
