package com.bitarcher.widgettoolkit.widget;

import com.bitarcher.interfacesOpenSource.gui.theme.EnumFontSize;
import com.bitarcher.interfacesOpenSource.gui.theme.ITheme;
import com.bitarcher.interfacesOpenSource.gui.widgets.IButtonListener;
import com.bitarcher.interfacesOpenSource.gui.widgets.ITextButton;
import com.bitarcher.interfacesOpenSource.gui.widgets.ITextButtonListener;
import com.bitarcher.interfacesOpenSource.mvc.ILabeledListener;
import com.bitarcher.interfacesOpenSource.resourcemanagement.IResourceManager;
import com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;

import org.andengine.engine.Engine;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.vbo.DrawType;

import java.util.ArrayList;

/**
 * Created by michel on 22/01/15.
 */
public class TextButton extends  Button implements ITextButton {
    protected String translatedLabel;
    ArrayList<ITextButtonListener> textButtonListenerArrayList = new ArrayList<>();
    ArrayList<ILabeledListener> labeledListenerArrayList = new ArrayList<>();
    ButtonSprite buttonSprite;
    Text text;
    boolean isTouchAreaRegistered = false;

    public TextButton(ITheme theme, float pX, float pY, float pWidth, float pHeight, String translatedLabel) {
        super(theme, pX, pY, pWidth, pHeight);
        this.translatedLabel = translatedLabel;

        IResourceManager resourceManager =this.getTheme().getThemeManager().getResourceManager();
        ITexturesSetResourceInfo texturesSetResourceInfo = this.getTheme().getTextButtonSection().getTexturesSetResourceInfo();
        resourceManager.pushRequirement(texturesSetResourceInfo);

        Engine engine = resourceManager.getEngine();




        final TextButton textButton = this;

        //float childX = 0;
        //float childY = 0;
        float childX = pWidth / 2;
        float childY = pHeight / 2;


        this.buttonSprite = new ButtonSprite(childX, childY,
                resourceManager.getTextureRegionFromTextureSetByName(texturesSetResourceInfo, "normal"),
                resourceManager.getTextureRegionFromTextureSetByName(texturesSetResourceInfo, "pressed"),
                resourceManager.getTextureRegionFromTextureSetByName(texturesSetResourceInfo, "disabled"),
                engine.getVertexBufferObjectManager(), new ButtonSprite.OnClickListener() {
                        @Override
                        public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                            textButton.onButtonClicked();
                        }
                    }
                );


        Font font = this.getTheme().getFontThemeSection().getTextButtonFont();
        this.text = new Text(childX, childY, font,  translatedLabel, engine.getVertexBufferObjectManager(), DrawType.DYNAMIC);
        //this.text.setWidth(pWidth);
        //this.text.setHeight(pWidth);

        this.attachChild(this.buttonSprite);
        this.attachChild(this.text);
    }

    void setButtonSpriteWidthAndHeight()
    {
        this.buttonSprite.setWidth(this.getWidth() - 2 * this.getPadding());
        this.buttonSprite.setHeight(this.getHeight() - 2 * this.getPadding());
    }

    @Override
    protected void onPaddingChanged() {
        super.onPaddingChanged();

        this.setButtonSpriteWidthAndHeight();
    }

    @Override
    protected void onSizeChanged() {
        super.onSizeChanged();


        this.setButtonSpriteWidthAndHeight();
    }


    private void onButtonClicked()
    {
        if(this.isEnabled())
        {
            for(IButtonListener buttonListener : this.buttonListenerArrayList)
            {
                buttonListener.onClicked(this);
            }


            this.onClicked();
        }
    }

    protected void onClicked()
    {

    }

    @Override
    public void onAttached() {
        super.onAttached();

        if(!this.isTouchAreaRegistered)
        {
            Scene scene = this.getTheme().getThemeManager().getResourceManager().getEngine().getScene();

            scene.registerTouchArea(this.buttonSprite);
            this.isTouchAreaRegistered = true;
        }
    }

    @Override
    public void onDetached() {
        super.onDetached();

        if(this.isTouchAreaRegistered)
        {
            Scene scene = this.getTheme().getThemeManager().getResourceManager().getEngine().getScene();

            scene.unregisterTouchArea(this.buttonSprite);

            this.isTouchAreaRegistered = false;
        }
    }

    @Override
    public void dispose() {
        if(!this.isDisposed()) {
            this.getTheme().getThemeManager().getResourceManager().popRequirement(this.getTheme().getTextButtonSection().getTexturesSetResourceInfo());
        }

        super.dispose();
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
    public void addTextButtonListener(ITextButtonListener textButtonListener) {
        this.textButtonListenerArrayList.add(textButtonListener);
    }

    @Override
    public void removeTextButtonListener(ITextButtonListener textButtonListener) {
        this.textButtonListenerArrayList.remove(textButtonListener);
    }

    @Override
    public void setTranslatedLabel(String translatedLabel) {
        this.translatedLabel = translatedLabel;

        for(ILabeledListener labeledListener : this.labeledListenerArrayList)
        {
            labeledListener.onLabelChanged(this);
        }

        this.onTranslatedLabelChanged(translatedLabel);
    }

    protected void onTranslatedLabelChanged(String translatedLabel)
    {
    }

    @Override
    public String getTranslatedLabel() {
        return this.translatedLabel;
    }

    @Override
    protected void onEnabledChanged(boolean enabled) {
        super.onEnabledChanged(enabled);

        this.buttonSprite.setEnabled(enabled);
    }


}
