package com.bitarcher.widgettoolkit.widget;

import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidget;
import com.bitarcher.aeFun.interfaces.gui.widgets.IWidgetListener;
import com.bitarcher.aeFun.interfaces.resourcemanagement.EResourceNotFound;
import com.bitarcher.widgettoolkit.widget.Tools.WidgetManagerSingleton;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.util.adt.color.Color;

import java.util.ArrayList;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */
public abstract class Widget extends Entity implements IWidget {

    private ITheme theme;
    private boolean areResourcesLoaded = false;
    protected ArrayList<IWidgetListener> widgetListenerArrayList = new ArrayList<>();
    private boolean enabled = true;
    private float padding = 0f;

    private float originalWidth;
    private float originalHeight;

    Rectangle debugRectangle;

    protected float getOriginalWidth() {
        return originalWidth;
    }

    protected float getOriginalHeight() {
        return originalHeight;
    }


    protected void setOriginalWidth(float originalWidth) {
        this.originalWidth = originalWidth;
    }

    protected void setOriginalHeight(float originalHeight) {
        this.originalHeight = originalHeight;
    }


    @Override
    public float getPadding() {
        return this.padding;
    }

    @Override
    public void setPadding(float padding) {
        this.padding = padding;

        this.onPaddingChanged();

        for(IWidgetListener widgetListener : this.widgetListenerArrayList)
        {
            widgetListener.onPaddingChanged(this);
        }
    }

    protected void onPaddingChanged()
    {

    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        this.onEnabledChanged(enabled);

        for(IWidgetListener widgetListener : this.widgetListenerArrayList)
        {
            widgetListener.onEnabledChanged(this, enabled);
        }
    }

    protected void onEnabledChanged(boolean enabled)
    {

    }

    protected Widget(ITheme theme, float pX, float pY, float pWidth, float pHeight) {
        super(pX, pY, pWidth, pHeight);
        this.theme = theme;

        this.originalWidth = pWidth;
        this.originalHeight = pHeight;
        this.debugRectangle = new Rectangle(pWidth/2, pHeight/2, pWidth, pHeight, this.theme.getThemeManager().getResourceManager().getEngine().getVertexBufferObjectManager());

        this.debugRectangle.setColor(this.getDebugColor());
        this.debugRectangle.setAlpha(0.5f);
        this.debugRectangle.setZIndex(3000);
        this.sortChildren();

        this.attachChild(this.debugRectangle);
    }

    void recomputeDebugRectangleSizeAndPosition()
    {
        this.debugRectangle.setPosition(this.getWidth() / 2, this.getHeight() / 2);
        this.debugRectangle.setSize(this.getWidth(), this.getHeight());
    }

    Color getDebugColor()
    {
        Color retval;

        int hashCode = this.hashCode();

        int[] somePrimeNumbers = new int[]{97, 317, 829};
        int[] modulos = new int[somePrimeNumbers.length];

        for(int i =0; i < somePrimeNumbers.length ; i++)
        {
            modulos[i] = hashCode % somePrimeNumbers[i];
        }

        float[] fVars = new float[3];

        for(int i =0; i < somePrimeNumbers.length ; i++)
        {
            fVars[i] = (float) modulos[i] / (float) somePrimeNumbers[i];
        }

        retval = new Color(fVars[0], fVars[1], fVars[2]);

        return retval;
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

        WidgetManagerSingleton.getInstance().refWidget(this);
        this.configureDebugMode(WidgetManagerSingleton.getInstance().isDebugModeEnabled());

    }

    private void configureDebugMode(boolean debugModeEnabled)
    {
        this.debugRectangle.setVisible(debugModeEnabled);
    }

    @Override
    public void onDebugModeChanged(boolean debugModeEnabled) {
        this.configureDebugMode(debugModeEnabled);
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

        WidgetManagerSingleton.getInstance().unRefWidget(this);
    }

    protected void pushResourceRequirements()
    {
    }

    protected void popResourceRequirements() throws EResourceNotFound
    {
    }

    @Override
    public void setWidth(float pWidth) {
        super.setWidth(pWidth);

        this.raiseSizeChanged();
    }

    @Override
    public void setHeight(float pHeight) {
        super.setHeight(pHeight);

        this.raiseSizeChanged();
    }

    @Override
    public void setSize(float pWidth, float pHeight) {
        super.setSize(pWidth, pHeight);

        this.raiseSizeChanged();
    }

    private void raiseSizeChanged()
    {
        this.recomputeDebugRectangleSizeAndPosition();
        this.onSizeChanged();

        for(IWidgetListener widgetListener : this.widgetListenerArrayList)
        {
            widgetListener.onSizeChanged(this);
        }
    }

    protected void onSizeChanged()
    {

    }

    @Override
    public void setX(float pX) {
        super.setX(pX);

        this.raisePositionChanged();
    }

    @Override
    public void setY(float pY) {
        super.setY(pY);

        this.raisePositionChanged();
    }

    @Override
    public void setPosition(IEntity pOtherEntity) {
        super.setPosition(pOtherEntity);

        this.raisePositionChanged();
    }

    @Override
    public void setPosition(float pX, float pY) {
        super.setPosition(pX, pY);

        this.raisePositionChanged();
    }

    private void raisePositionChanged()
    {
        this.onPositionChanged();

        for(IWidgetListener widgetListener : this.widgetListenerArrayList)
        {
            widgetListener.onPositionChanged(this);
        }
    }

    protected void onPositionChanged()
    {
    }

    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);

        if(WidgetManagerSingleton.getInstance().isDebugModeEnabled())
        {
            this.sortChildren();
        }
    }
}
