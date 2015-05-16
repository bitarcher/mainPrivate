package com.bitarcher.abc.selectPlayer;


import com.bitarcher.abc.animals.EnumAnimal;
import com.bitarcher.abcbllorm.BLL.Player;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButtonListener;
import com.bitarcher.aeFun.interfaces.sceneManagement.IGoBackSceneCapable;
import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFun.widgetToolkit.widget.TextButton;
import com.bitarcher.speaker.AlternativeSpeeches;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

public class ChoosePlayerMenu extends ChoosersAbstractMenu implements IGoBackSceneCapable{

    TextButton newPlayerTextButton;

    @Override
    public void goBackToPreviousScene() {
        this.getSceneManager().showMainMenu();
    }

    public ChoosePlayerMenu(ITSceneManager sceneManager) {
        super(sceneManager);
	}


	@Override
    public void onLoadScene() {
        super.onLoadScene();

        List<Player> players = null;
        try {
            Dao<Player, Integer> dao = this.getMainMenu().getDatabaseHelper().getDao(Player.class);

            players = dao.queryForAll();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        boolean quotaReached = players.size() >= 4;

        if(!quotaReached) {
            this.newPlayerTextButton = new TextButton(this.getSceneManager().getTheme(), 0, 0, 10, 10, "Nouveau joueur");
            this.newPlayerTextButton.addButtonListener(new IButtonListener() {
                @Override
                public void onClicked(IButton button) {
                    getSceneManager().showScene(new ChooseAvatarMenu(getSceneManager()));
                }
            });
            this.table.attachChild(this.newPlayerTextButton, 1, 1);

        }

        int i = 0;
        for(Player player : players)
        {
            EnumAnimal animal = EnumAnimal.valueOf(player.getAnimalAvatarName());

            com.bitarcher.aeFun.interfaces.mvc.IImage image = this.getMainMenu().getAnimalResourceInfos().make(animal);
            this.imageButtons[i] = new ChoosePlayerImageButton(this, this.getSceneManager().getTheme(), 0, 0, 10, 10, image, player);

            this.table.attachChild(this.imageButtons[i]);
            i++;
        }

        AlternativeSpeeches alternativeSpeeches = new AlternativeSpeeches();

        if(!quotaReached) {
            alternativeSpeeches.addAlternativeSpeech("Choisis ton joueur ou appuie sur le bouton en bas à droite pour en créer un nouveau");
            alternativeSpeeches.addAlternativeSpeech("Appuie sur ton animal préféré ou bien appuie sur le bouton en bas à droite s'il n'est pas là");
        }
        else
        {
            alternativeSpeeches.addAlternativeSpeech("Choisis ton joueur s'il te plaît.");
            alternativeSpeeches.addAlternativeSpeech("Appuie sur ton animal préféré");
        }
        this.getMainMenu().getSpeaker().say(alternativeSpeeches);

    }

    @Override
    protected String getTranslatedTitle() {
        return "Choisis ton joueur";
    }
}