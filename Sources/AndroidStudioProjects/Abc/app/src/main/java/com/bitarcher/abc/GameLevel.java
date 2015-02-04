package com.bitarcher.abc;

import com.bitarcher.interfaces.resourcemanagement.IResourceManager;
import com.bitarcher.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.scenemanagement.ManagedGameScene;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.util.math.MathUtils;

public class GameLevel extends ManagedGameScene {

    public GameLevel(ITSceneManager sceneManager) {
        super(sceneManager);
    }


    @Override
	public void onLoadScene() {
		super.onLoadScene();
		Rectangle rectangle = new Rectangle(0f,0f,120f,120f, this.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());
		rectangle.setPosition(MathUtils.random(0f + rectangle.getWidth(), (800f - rectangle.getWidth())), MathUtils.random((-240f+rectangle.getHeight()),(240f-rectangle.getHeight())));
		this.attachChild(rectangle);
	}
}