package com.bitarcher.aeFunExamplesShowRoom.widgetToolkit.widget;


import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.ENoLayoutFound;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.theme.context.ITextButtonContext;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.gui.widgets.ITextButton;
import com.bitarcher.aeFunExamplesShowRoom.interfaces.mvc.ILabeledListener;
import com.bitarcher.aeFunExamplesShowRoom.widgetToolkit.widget.Tools.Button;

import java.util.ArrayList;

/**-
 * Created by michel on 22/01/15.
 */
public class TextButton extends Button<ITextButtonContext> implements ITextButton {
    protected String translatedLabel;
    ArrayList<ILabeledListener> labeledListenerArrayList = new ArrayList<>();



    public TextButton(ITheme theme, float pX, float pY, float pWidth, float pHeight, String translatedLabel) {
        super(theme, pX, pY, pWidth, pHeight);
        this.translatedLabel = translatedLabel;


        if(this.getLayout() != null)
        {
            this.getLayout().onInit();
        }
        else
        {
            throw new ENoLayoutFound(this);
        }
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
        if(this.getLayout() != null)
        {
            this.getLayout().getContext().setTranslatedLabel(this.getTranslatedLabel());
        }

    }

    @Override
    public String getTranslatedLabel() {
        return this.translatedLabel;
    }

    @Override
    public void dispose() {
        super.dispose();

        this.labeledListenerArrayList.clear();
    }
}
