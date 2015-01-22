package com.bitarcher.widgettoolkit.widget;

import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.gui.widgets.IWidget;
import com.bitarcher.interfaces.gui.widgets.IWidgetListener;
import com.bitarcher.interfaces.resourcemanagement.EResourceNotFound;

import org.andengine.entity.Entity;

import java.util.ArrayList;

/**
 * Created by michel on 22/01/15.
 */
public abstract class Widget extends Entity implements IWidget {

    ITheme theme;
    boolean areResourcesLoaded = false;
    protected ArrayList<IWidgetListener> widgetListenerArrayList = new ArrayList<>();

    protected Widget(float pX, float pY, float pWidth, float pHeight, ITheme theme) {
        super(pX, pY, pWidth, pHeight);
        this.theme = theme;
    }

    @Override
    public void addWidgetListener(IWidgetListener widgetListener) {
        this.widgetListenerArrayList.add(widgetListener);
    }

    @Override
    public void removeWidgetListener(IWidgetListener widgetListener) {
        this.widgetListenerArrayList.remove(widgetListener);
    }

    @Override
    public ITheme getTheme()
    {
        return this.theme;
    }

    @Override
    public void onAttached() {
        super.onAttached();

        if(!this.areResourcesLoaded)
        {
            try
            {
                this.pushResourceRequirements();
            }
            finally {
                this.areResourcesLoaded = true;
            }
        }
    }

    @Override
    public void onDetached() {
        super.onDetached();

        if(this.areResourcesLoaded)
        {
            try
            {
                this.popResourceRequirements();
            }
            catch(EResourceNotFound eResourceNotFound)
            {
                eResourceNotFound.printStackTrace();
            }
            finally {
                this.areResourcesLoaded = false;
            }
        }
    }

    protected void pushResourceRequirements()
    {
    }

    protected void popResourceRequirements() throws EResourceNotFound
    {
    }


}
