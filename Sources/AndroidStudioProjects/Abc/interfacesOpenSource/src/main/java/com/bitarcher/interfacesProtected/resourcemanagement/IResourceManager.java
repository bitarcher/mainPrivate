package com.bitarcher.interfacesProtected.resourcemanagement;

import android.content.Context;

import com.bitarcher.interfacesProtected.gui.theme.IThemeManager;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.Font.IFontResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IAnimationResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IBuildableBitmapTextureAtlasResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IMusicResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.IResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ISoundResourceInfo;
import com.bitarcher.interfacesProtected.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;

import org.andengine.audio.music.Music;
import org.andengine.audio.sound.Sound;
import org.andengine.engine.Engine;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITextureRegion;

/**
 * Created by michel on 07/01/15.
 */
public interface IResourceManager {
    Engine getEngine();
    Context getContext();
    IThemeManager getThemeManager();
    float getCameraWidth();
    float getCameraHeight();

    void setup(final Engine pEngine, final IContextProvider pContextProvider, IThemeManager themeManager);

    void pushRequirement(IResourceInfo resourceInfo) throws EResourceCreationError;
    void pushRequirement(IResourceInfoListGotter resourceInfoListGotter) throws EResourceCreationError;

    void popRequirement(IResourceInfo resourceInfo) throws EResourceNotFound;

    // popped in reversed order so you can managed dependencies between resources
    void popRequirement(IResourceInfoListGotter resourceInfoListGotter) throws EResourceNotFound;

    BuildableBitmapTextureAtlas getBuildableBitmapTextureAtlas(IBuildableBitmapTextureAtlasResourceInfo buildableBitmapTextureAtlasInfo) throws EResourceNotFound;
    ITextureRegion getTextureRegionFromTextureSetByName(ITexturesSetResourceInfo textureSetResourceInfo, String textureName) throws EResourceNotFound;
    AnimatedSprite getAnimatedSpriteFromAnimationResourceInfo(IAnimationResourceInfo animationResourceInfo) throws EResourceNotFound;
    Font getFont(IFontResourceInfo fontResourceInfo) throws EResourceNotFound;
    Sound getSound(ISoundResourceInfo soundResourceInfo) throws EResourceNotFound;
    Music getMusic(IMusicResourceInfo musicResourceInfo) throws EResourceNotFound;
}

