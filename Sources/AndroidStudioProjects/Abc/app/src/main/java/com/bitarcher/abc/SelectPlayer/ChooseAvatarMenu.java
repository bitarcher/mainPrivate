package com.bitarcher.abc.SelectPlayer;


import android.util.Log;

import com.bitarcher.abc.AbcManagedMenuScene;
import com.bitarcher.abc.animals.EnumAnimal;
import com.bitarcher.abcbllorm.BLL.Player;
import com.bitarcher.aeFun.drawables.animatedMeshed.nature.clouds.CloudSprite;
import com.bitarcher.aeFun.interfaces.gui.andEngine.IScene;
import com.bitarcher.aeFun.interfaces.gui.theme.EnumFontSize;
import com.bitarcher.aeFun.interfaces.gui.theme.ITheme;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButtonListener;
import com.bitarcher.aeFun.interfaces.gui.widgets.IImage;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceInfoListGotter;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.MusicResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneAssetBitmapTexture;
import com.bitarcher.aeFun.widgetToolkit.widget.ImageButton;
import com.bitarcher.aeFun.widgetToolkit.widget.Table;
import com.bitarcher.aeFun.widgetToolkit.widget.TextButton;
import com.bitarcher.speaker.AlternativeSpeeches;
import com.j256.ormlite.dao.Dao;

import org.andengine.audio.music.Music;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;
import org.andengine.opengl.texture.region.ITextureRegion;

import java.sql.SQLException;
import java.util.ArrayList;
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
