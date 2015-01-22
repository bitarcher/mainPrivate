package com.bitarcher.widgettoolkit.widget;

import com.bitarcher.interfaces.gui.theme.ITheme;
import com.bitarcher.interfaces.gui.widgets.ITextButton;
import com.bitarcher.interfaces.gui.widgets.ITextButtonListener;
import com.bitarcher.interfaces.mvc.ILabeledListener;
import com.bitarcher.interfaces.resourcemanagement.EResourceNotFound;

import java.util.ArrayList;

/**
 * Created by michel on 22/01/15.
 */
public class TextButton extends  Button implements ITextButton {
    protected String translatedLabel;
    ArrayList<ITextButtonListener> textButtonListenerArrayList = new ArrayList<>();
    ArrayList<ILabeledListener> labeledListenerArrayList = new ArrayList<>();

    public TextButton(ITheme theme, float pX, float pY, float pWidth, float pHeight, String translatedLabel) {
        super(theme, pX, pY, pWidth, pHeight);
        this.translatedLabel = translatedLabel;
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
    protected void pushResourceRequirements() {
        super.pushResourceRequirements();

        this.getTheme().getThemeManager().getResourceManager().pushRequirement(this.getTheme().getTextButtonSection().getTexturesSetResourceInfo());
    }

    @Override
    protected void popResourceRequirements() throws EResourceNotFound {
        super.popResourceRequirements();

        this.getTheme().getThemeManager().getResourceManager().popRequirement(this.getTheme().getTextButtonSection().getTexturesSetResourceInfo());
    }
}
