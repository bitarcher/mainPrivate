package com.bitarcher.abc.selectPlayer;


import com.bitarcher.abc.animals.EnumAnimal;
import com.bitarcher.abcbllorm.BLL.Player;
import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.speaker.AlternativeSpeeches;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

public class ChooseAvatarMenu extends ChoosersAbstractMenu {
	public ChooseAvatarMenu(ITSceneManager sceneManager) {
        super(sceneManager);
	}

	@Override
    public void onLoadScene() {

        super.onLoadScene();

        EnumAnimal[] proposedAnimals = this.getProposedAnimals();

        List<Player> players = null;
        try {
            Dao<Player, Integer> dao = this.getMainMenu().getDatabaseHelper().getDao(Player.class);

            players = dao.queryForAll();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(int i = 0 ; i < this.imageButtons.length ; i++)
        {
            final EnumAnimal animal = proposedAnimals[i];

            String animalStr = animal.name();

            boolean alreadyExist = false;

            for(Player player : players)
            {
                String animalAvatarName = player.getAnimalAvatarName().toLowerCase();

                if(animalAvatarName.contentEquals(animalStr))
                {
                    alreadyExist = true;
                    break;
                }
            }

            if(!alreadyExist) {
                com.bitarcher.aeFun.interfaces.mvc.IImage image = this.getMainMenu().getAnimalResourceInfos().make(animal);
                this.imageButtons[i] = new ChooseAvatarImageButton(this, this.getSceneManager().getTheme(), 0, 0, 10, 10, image, animal);

                this.table.attachChild(this.imageButtons[i]);
            }
        }


        AlternativeSpeeches alternativeSpeeches = new AlternativeSpeeches();
        alternativeSpeeches.addAlternativeSpeech("Choisis ton animal préféré");
        alternativeSpeeches.addAlternativeSpeech("Choisis l'animal qui doit te représenter");
        this.getMainMenu().getSpeaker().say(alternativeSpeeches);
    }


    @Override
    protected String getTranslatedTitle() {
        return "Choisis ton animal préféré";
    }
}
