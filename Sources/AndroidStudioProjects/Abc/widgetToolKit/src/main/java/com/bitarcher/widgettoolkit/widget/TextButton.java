package com.bitarcher.widgettoolkit.widget;

import com.bitarcher.interfacesProtected.gui.theme.EnumFontSize;
import com.bitarcher.interfacesProtected.gui.theme.ITheme;
import com.bitarcher.interfacesProtected.gui.widgets.IButtonListener;
import com.bitarcher.interfacesProtected.gui.widgets.ITextButton;
import com.bitarcher.interfacesProtected.gui.widgets.ITextButtonListener;
import com.bitarcher.interfacesProtected.mvc.ILabeledListener;
import com.bitarcher.interfacesProtected.resourcemanagement.IResourceManager;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;

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


        float centerX = pWidth / 2;
        float centerY = pHeight / 2;

        final TextButton textButton = this;

        float childX = 0;
        float childY = 0;


        //this.buttonSprite = new ButtonSprite(centerX, centerY,
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
        this.buttonSprite.setWidth(pWidth);
        this.buttonSprite.setHeight(pHeight);


        Font font = this.getTheme().getFontThemeSection().getFont(EnumFontSize.Medium);
        this.text = new Text(childX, childY, font,  translatedLabel, engine.getVertexBufferObjectManager(), DrawType.DYNAMIC);
        //this.text.setWidth(pWidth);
        //this.text.setHeight(pWidth);

        this.attachChild(this.buttonSprite);
        this.attachChild(this.text);


    }

    /*@Override
    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
        if(pSceneTouchEvent.getAction()  == TouchEvent.ACTION_DOWN)
        {
            this.onButtonClicked();
            this.buttonSprite.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
        }
        else if(pSceneTouchEvent.getAction()  == TouchEvent.ACTION_UP)
        {
            this.buttonSprite.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
        }

        return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
    }
*/
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
