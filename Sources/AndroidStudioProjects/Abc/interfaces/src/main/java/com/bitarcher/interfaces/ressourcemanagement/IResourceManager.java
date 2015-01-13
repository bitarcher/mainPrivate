package com.bitarcher.interfaces.ressourcemanagement;

import android.content.Context;

import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.Font.IFontResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IAnimationResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBitmapAnimationResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBitmapTexturesSetResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IBuildableBitmapTextureAtlasResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IMusicResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.interfaces.ressourcemanagement.ResourceInfo.ISoundResourceInfo;

import org.andengine.audio.music.Music;
import org.andengine.audio.sound.Sound;
import org.andengine.engine.Engine;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 07/01/15.
 */
public interface IResourceManager {
    Engine getEngine();
    Context getContext();
    float getCameraWidth();
    float getCameraHeight();
    float getCameraScaleX();
    float getCameraScaleY();

    void setup(final Engine pEngine, final Context pContext, final float pCameraWidth, final float pCameraHeight, final float pCameraScaleX, final float pCameraScaleY);

    void pushRequirement(IResourceInfo resourceInfo) throws EResourceCreationError;
    void pushRequirement(IResourceInfoListGotter resourceInfoListGotter) throws EResourceCreationError;

    void popRequirement(IResourceInfo resourceInfo) throws EResourceNotFound;

    // popped in reversed order so you can managed dependencies between resources
    void popRequirement(IResourceInfoListGotter resourceInfoListGotter) throws EResourceNotFound;

    org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas getBuildableBitmapTextureAtlas(IBuildableBitmapTextureAtlasResourceInfo buildableBitmapTextureAtlasInfo) throws EResourceNotFound;
    ITextureRegion getTextureRegionFromTextureSetByName(IBitmapTexturesSetResourceInfo textureSetResourceInfo, String textureName) throws EResourceNotFound;
    AnimatedSprite getAnimatedSpriteFromAnimationResourceInfo(IAnimationResourceInfo animationResourceInfo) throws EResourceNotFound;
    Font getFont(IFontResourceInfo fontResourceInfo) throws EResourceNotFound;
    Sound getSound(ISoundResourceInfo soundResourceInfo) throws EResourceNotFound;
    Music getMusic(IMusicResourceInfo musicResourceInfo) throws EResourceNotFound;
}
