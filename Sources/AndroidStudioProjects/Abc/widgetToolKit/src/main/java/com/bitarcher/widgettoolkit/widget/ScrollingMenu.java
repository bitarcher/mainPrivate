/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.widgettoolkit.widget;

import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.gui.widgets.IScrollingMenu;
import com.bitarcher.interfaces.gui.widgets.IScrollingMenuListener;
import com.bitarcher.interfaces.mvc.IImagedAndLabeled;
import com.bitarcher.interfaces.resourcemanagement.EResourceNotFound;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 23/02/15.
 * adapted from https://github.com/gorlok/AndEngineMenuScrollDemo/blob/master/src/com/example/menuscrolldemo/MenuScrollDemo.java
 * which is also adapted from
 * @see <a href="http://www.andengine.org/forums/tutorials/menu-scroll-example-t5740.html">original source</a>
 */
public class ScrollingMenu extends Widget implements IScrollingMenu {

    ArrayList<IImagedAndLabeled> imagedAndLabeledList = new ArrayList<>();
    ArrayList<IScrollingMenuListener> scrollingMenuListenersList = new ArrayList<>();

    @Override
    public List<IImagedAndLabeled> getImagedAndLabeledList() {
        return this.imagedAndLabeledList;
    }

    @Override
    public void addScrollingMenuListener(IScrollingMenuListener scrollingMenuListener) {
        this.scrollingMenuListenersList.add(scrollingMenuListener);
    }

    @Override
    public void removeScrollingMenuListener(IScrollingMenuListener scrollingMenuListener) {
        this.scrollingMenuListenersList.remove(scrollingMenuListener);
    }

    public ScrollingMenu(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(theme, pX, pY, pWidth, pHeight);
    }

    @Override
    protected void pushResourceRequirements() {
        super.pushResourceRequirements();
    }

    @Override
    protected void popResourceRequirements() throws EResourceNotFound {
        super.popResourceRequirements();
    }
}
