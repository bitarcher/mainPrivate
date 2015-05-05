package com.bitarcher.abc.SelectPlayer;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import android.util.Log;

import com.bitarcher.abc.animals.EnumAnimal;
import com.bitarcher.abcbllorm.BLL.Player;
import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.mvc.IImage;
import com.bitarcher.aeFun.widgetToolkit.widget.ImageButton;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by michel on 05/05/15.
 */
public class ChooseAvatarImageButton  extends ImageButton {
    ChooseAvatarMenu chooseAvatarMenu;
    EnumAnimal avatar;

    public ChooseAvatarImageButton(ChooseAvatarMenu chooseAvatarMenu, ITheme theme, float pX, float pY, float pWidth, float pHeight, IImage image, EnumAnimal avatar) {
        super(theme, pX, pY, pWidth, pHeight, image);

        this.chooseAvatarMenu = chooseAvatarMenu;
        this.avatar = avatar;
    }

    @Override
    protected void onClicked() {
        super.onClicked();
        try {
            Dao<Player, Integer> dao = this.chooseAvatarMenu.getMainMenu().getDatabaseHelper().getDao(Player.class);

            Player player = new Player(this.avatar.name());

            player.setDao(dao);
            player.i_create();

            this.chooseAvatarMenu.getMainMenu().setPlayer(player);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
