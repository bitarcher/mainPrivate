package com.bitarcher.aeFun.widgetToolkit.widget;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.gui.widgets.IRadioButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IRadioButtonGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 08/04/15.
 */
public class RadioButtonGroup implements IRadioButtonGroup {
    ArrayList<IRadioButton> radioButtonArrayList = new ArrayList<>();

    @Override
    public List<IRadioButton> getRadioButtons() {
        return this.radioButtonArrayList;
    }
}
