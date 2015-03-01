package com.bitarcher.abc;

import com.bitarcher.interfacesOpenSource.mvc.IImagedAndLabeled;
import com.bitarcher.interfacesOpenSource.mvc.ILabeledListener;
import com.bitarcher.interfacesOpenSource.resourcemanagement.ResourceInfo.ITexturesSetResourceInfo;
import com.bitarcher.interfacesOpenSource.sceneManagement.ITSceneManager;
import com.bitarcher.resourcemanagement.ResourcesInfos.SubInfos.OneAssetSvgTexture;
import com.bitarcher.resourcemanagement.ResourcesInfos.SvgTexturesSetFromAssetResourceInfo;
import com.bitarcher.scenemanagement.ManagedGameScene;
import com.bitarcher.widgettoolkit.widget.ScrollingMenu;

public class GameLevel extends ManagedGameScene {

    SvgTexturesSetFromAssetResourceInfo animalsTexturesSet = new SvgTexturesSetFromAssetResourceInfo("animals", 1024, 256, "gfx/Animals/");

    public GameLevel(ITSceneManager sceneManager) {

        super(sceneManager);

        int width = 240,height = 240;
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("abeille", "abeille.svg", width, height));
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("chat", "chat.svg", width, height));
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("dauphin", "dauphin.svg", width, height));
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("éléphant", "elephant.svg", width, height));
    }




    @Override
    public void onLoadManagedScene() {
        super.onLoadManagedScene();

        this.getSceneManager().getResourceManager().pushRequirement(animalsTexturesSet);
    }

    @Override
    public void onUnloadManagedScene() {
        super.onUnloadManagedScene();

        this.getSceneManager().getResourceManager().popRequirement(animalsTexturesSet);
    }

    @Override
	public void onLoadScene() {
		super.onLoadScene();
		/*Rectangle rectangle = new Rectangle(0f,0f,120f,120f, this.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());
		rectangle.setPosition(MathUtils.random(0f + rectangle.getWidth(), (800f - rectangle.getWidth())), MathUtils.random((-240f+rectangle.getHeight()),(240f-rectangle.getHeight())));
		this.attachChild(rectangle);*/

        int padding = 40;
        //float cw = this.getSceneManager().getResourceManager().getCameraWidth() - padding;
        //float ch = this.getSceneManager().getResourceManager().getCameraHeight() - padding;

        float cw = this.getSceneManager().getResourceManager().getCameraWidth() - padding;
        float ch = this.getSceneManager().getResourceManager().getCameraHeight() - padding;



        ScrollingMenu scrollingMenu = new ScrollingMenu(this.getSceneManager().getTheme(),
                cw / 2 + (padding / 2),
                0,
                cw, ch);

        for(final String name : new String[]{"abeille", "chat", "dauphin", "éléphant"}) {

            scrollingMenu.getImagedAndLabeledList().add(new IImagedAndLabeled() {
                @Override
                public ITexturesSetResourceInfo getTextureSetResourceInfo() {
                    return animalsTexturesSet;
                }

                @Override
                public String getTextureName() {
                    return name;
                }

                @Override
                public String getTranslatedLabel() {
                    return name;
                }

                @Override
                public void addLabeledListener(ILabeledListener labeledListener) {

                }

                @Override
                public void removeLabeledListener(ILabeledListener labeledListener) {

                }
            });
        }

        this.attachChild(scrollingMenu);
	}
}