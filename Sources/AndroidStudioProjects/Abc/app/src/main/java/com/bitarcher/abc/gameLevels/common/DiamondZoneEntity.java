package com.bitarcher.abc.gameLevels.common;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceInfoListGotter;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.aeFun.interfaces.resourcemanagement.IResourceRequirementsStackUser;
import com.bitarcher.aeFun.interfaces.resourcemanagement.ResourceInfo.IResourceInfo;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michel on 07/05/15.
 */
public class DiamondZoneEntity extends Entity implements IResourceInfoListGotter, IResourceRequirementsStackUser {
    IResourceManager resourceManager;
    GameLevelCommonResourceInfos gameLevelCommonResourceInfos;

    ArrayList<IDiamondZoneEntityListener> diamondZoneEntityListeners = new ArrayList<>();
    Sprite background;
    Sprite[] diamonds = new Sprite[3];

    int numOfDiamonds = 0;

    public DiamondZoneEntity(IResourceManager resourceManager, GameLevelCommonResourceInfos gameLevelCommonResourceInfos) {
        super(800 - 106 /2, 480 / 2, 106, 203);

        this.resourceManager = resourceManager;
        this.gameLevelCommonResourceInfos = gameLevelCommonResourceInfos;
    }

    @Override
    public List<IResourceInfo> getResourceInfoList() {
        ArrayList<IResourceInfo> retval = new ArrayList<>();

        retval.add(this.gameLevelCommonResourceInfos.bitmapTexturesSetFromAssetResourceInfo);

        return retval;
    }

    @Override
    public void pushResourceRequirements() {
        this.resourceManager.pushRequirement(this);
    }

    @Override
    public void popResourceRequirements() {
        this.resourceManager.popRequirement(this);
    }

    @Override
    public void onAttached() {
        super.onAttached();

        this.pushResourceRequirements();
        this.addEntities();
    }

    @Override
    public void onDetached() {
        this.popResourceRequirements();

        super.onDetached();
    }

    public void addDiamondZoneEntityListener(IDiamondZoneEntityListener diamondZoneEntityListener)
    {
        this.diamondZoneEntityListeners.add(diamondZoneEntityListener);
    }

    public void removeDiamondZoneEntityListener(IDiamondZoneEntityListener diamondZoneEntityListener)
    {
        this.diamondZoneEntityListeners.remove(diamondZoneEntityListener);
    }

    public int getNumOfDiamonds() {
        return numOfDiamonds;
    }

    public void setNumOfDiamonds(int numOfDiamonds) {
        if(numOfDiamonds > 3 || numOfDiamonds < 0)
        {
            throw new IllegalArgumentException("numOfDiamonds > 3 || numOfDiamonds < 0");
        }

        this.numOfDiamonds = numOfDiamonds;

        this.recheckVisibilityOfDiamonds();

        for(IDiamondZoneEntityListener diamondZoneEntityListener : this.diamondZoneEntityListeners)
        {
            diamondZoneEntityListener.onNumOfDiamondsChanged(this, this.numOfDiamonds);
        }
    }

    void clearEntities()
    {
        if(this.background != null)
        {
            this.detachChild(this.background);
            this.background.dispose();
            this.background = null;
        }

        for(int i = 0 ; i < this.diamonds.length ; i++)
        {
            if(this.diamonds[i] != null)
            {
                this.detachChild(this.diamonds[i]);
                this.diamonds[i].dispose();
                this.diamonds[i] = null;
            }
        }
    }

    void addEntities()
    {
        this.clearEntities();

        this.background = new Sprite(106 / 2, 203f / 2f, 106, 203,
                this.resourceManager.getTextureRegionFromTextureSetByName(
                        this.gameLevelCommonResourceInfos.bitmapTexturesSetFromAssetResourceInfo,
                        this.gameLevelCommonResourceInfos.getDiamond_3places_106x203().getName()
                ), this.resourceManager.getEngine().getVertexBufferObjectManager());

        this.background.setAlpha(0.7f);
        this.attachChild(this.background);

        for(int i = 0 ; i < this.diamonds.length ; i++)
        {
            // position will be set later
            this.diamonds[i] = new Sprite(106 / 2, 0, 100, 60,
                    this.resourceManager.getTextureRegionFromTextureSetByName(
                            this.gameLevelCommonResourceInfos.bitmapTexturesSetFromAssetResourceInfo,
                            this.gameLevelCommonResourceInfos.getDiamond_300x179().getName()
                    ), this.resourceManager.getEngine().getVertexBufferObjectManager());

            this.attachChild(this.diamonds[i]);
        }

        this.diamonds[0].setY(40);
        this.diamonds[1].setY(105);
        this.diamonds[2].setY(170);

        this.recheckVisibilityOfDiamonds();
    }

    public void incNumOfDiamonds()
    {
        this.numOfDiamonds++;
        if(this.numOfDiamonds > 3)
        {
            this.numOfDiamonds = 3;
        }
        else
        {
            this.recheckVisibilityOfDiamonds();

            for(IDiamondZoneEntityListener diamondZoneEntityListener : this.diamondZoneEntityListeners)
            {
                diamondZoneEntityListener.onNumOfDiamondsChanged(this, this.numOfDiamonds);
            }
        }
    }

    public void reinit()
    {
        this.numOfDiamonds = 0;

        this.recheckVisibilityOfDiamonds();

        for(IDiamondZoneEntityListener diamondZoneEntityListener : this.diamondZoneEntityListeners)
        {
            diamondZoneEntityListener.onReinit(this);
        }
    }

    void recheckVisibilityOfDiamonds()
    {
        for(int i = 0 ; i < this.diamonds.length ; i++)
        {
            this.diamonds[i].setVisible(this.numOfDiamonds > i);
        }
    }
}
