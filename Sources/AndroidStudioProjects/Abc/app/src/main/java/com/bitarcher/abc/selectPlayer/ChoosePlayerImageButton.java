package com.bitarcher.abc.selectPlayer;

import com.bitarcher.abcbllorm.BLL.Player;
import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.mvc.IImage;
import com.bitarcher.aeFun.widgetToolkit.widget.ImageButton;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 05/05/15.
 */
public class ChoosePlayerImageButton extends ImageButton {
    ChoosePlayerMenu choosePlayerMenu;
    Player player;

    public ChoosePlayerImageButton(ChoosePlayerMenu choosePlayerMenu, ITheme theme, float pX, float pY, float pWidth, float pHeight, IImage image, Player player) {
        super(theme, pX, pY, pWidth, pHeight, image);

        this.choosePlayerMenu = choosePlayerMenu;
        this.player = player;
    }

    @Override
    protected void onClicked() {
        super.onClicked();

        this.choosePlayerMenu.getMainMenu().setPlayer(player);

        // TODO
    }
}
