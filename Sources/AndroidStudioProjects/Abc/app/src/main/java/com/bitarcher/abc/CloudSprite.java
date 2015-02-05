/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abc;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.math.MathUtils;

/**
 * Created by michel on 05/02/15.
 */
public class CloudSprite extends Sprite {
    MainMenu mainMenu;

    private float XSpeed = MathUtils.random(0.2f, 2f);
    private boolean initialized = false;

    public CloudSprite(MainMenu mainMenu, ITextureRegion cloudTextureRegion)
    {
        super(
                MathUtils.random(-(mainMenu.getWidth() * mainMenu.getScaleX()) / 2, mainMenu.getSceneManager().getResourceManager().getCameraWidth() + (mainMenu.getWidth() * mainMenu.getScaleX()) / 2),
                MathUtils.random(-(mainMenu.getHeight()*mainMenu.getScaleY())/2, mainMenu.getSceneManager().getResourceManager().getCameraHeight() + (mainMenu.getHeight()*mainMenu.getScaleY())/2),,
                cloudTextureRegion, mainMenu.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());

        this.mainMenu = mainMenu;



    }

    @Override
    protected void onManagedUpdate(final float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);
        if(!initialized) {
            initialized = true;
            this.setScale(XSpeed/2);
            this.setZIndex(-4000+Math.round(XSpeed*1000f));
            mainMenu.sortChildren();
        }
        if(this.getX()<-(this.getWidth()*this.getScaleX())/2) {
            XSpeed = MathUtils.random(0.2f, 2f);
            this.setScale(XSpeed/2);
            this.setPosition(mainMenu.getSceneManager().getResourceManager().getCameraWidth()+(this.getWidth()*this.getScaleX())/2,
                    MathUtils.random(-(this.getHeight()*this.getScaleY())/2, mainMenu.getSceneManager().getResourceManager().getCameraHeight() + (this.getHeight()*this.getScaleY())/2));

            this.setZIndex(-4000+Math.round(XSpeed*1000f));
            mainMenu.sortChildren();
        }
        this.setPosition(this.getX()-(XSpeed*(pSecondsElapsed/0.016666f)), this.getY());
    }
}
