package com.bitarcher.aeFun.interfaces.gui.theme.context;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.geometry.ISizeOwner;
import com.bitarcher.aeFun.interfaces.gui.theme.context.owner.IEnabledOwner;

import com.bitarcher.aeFun.interfaces.gui.theme.context.owner.IPaddingOwner;

/**
 * Created by michel on 09/03/15.
 */
public interface ICommonContext  extends IContext, IEnabledOwner, ISizeOwner, IPaddingOwner {
}
