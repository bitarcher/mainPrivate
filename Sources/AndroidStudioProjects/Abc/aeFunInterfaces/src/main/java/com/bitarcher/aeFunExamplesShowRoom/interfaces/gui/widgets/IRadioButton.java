package com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets;

import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.context.IRadioButtonContext;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.mvc.ILabeled_Edit;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 20/03/15.
 */
public interface IRadioButton extends ICheckable<IRadioButtonContext>, ILabeled_Edit {
    IRadioButtonGroup getRadioButtonGroup();
}
