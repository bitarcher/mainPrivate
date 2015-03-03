package com.bitarcher.abc;

import com.bitarcher.aeFun.interfaces.gui.andEngine.IScene;
import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneAssetSvgTexture;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SvgTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFun.sceneManagement.ManagedGameScene;
import com.bitarcher.aeFun.sceneManagement.ManagedScene;
import com.bitarcher.aeFun.widgetToolkit.widget.LayoutManagement.HBox;
import com.bitarcher.aeFun.widgetToolkit.widget.LayoutManagement.PercentSpaceUsage;
import com.bitarcher.aeFun.widgetToolkit.widget.LayoutManagement.VBox;
import com.bitarcher.aeFun.widgetToolkit.widget.TextButton;


public class GameLevel extends ManagedGameScene {

    SvgTexturesSetFromAssetResourceInfo animalsTexturesSet = new SvgTexturesSetFromAssetResourceInfo("animals", 1024, 256, "gfx/Animals/");

    public GameLevel(ITSceneManager sceneManager) {

        super(sceneManager, 0);

        int width = 240,height = 240;
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("abeille", "abeille.svg", width, height));
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("chat", "chat.svg", width, height));
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("dauphin", "dauphin.svg", width, height));
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("éléphant", "elephant.svg", width, height));
    }

    // BEGIN since Managed scene
/*
    @Override
    public IScene onLoadingScreenLoadAndShown() {
        return null;
    }

    @Override
    public void onLoadingScreenUnloadAndHidden() {

    }

    @Override
    public void onUnloadScene() {

    }

    @Override
    public void onShowScene() {

    }


    @Override
    public void onHideScene() {

    }
*/
    // END since Managed scene

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

        int margin = 10;
        //float cw = this.getSceneManager().getResourceManager().getCameraWidth() - margin;
        //float ch = this.getSceneManager().getResourceManager().getCameraHeight() - margin;

        float w = this.getSceneManager().getResourceManager().getCameraWidth();
        float h = this.getSceneManager().getResourceManager().getCameraHeight();
        float cw = w - 2* margin;
        float ch = h - 2*margin;

        /*

        ScrollingMenu scrollingMenu = new ScrollingMenu(this.getSceneManager().getTheme(),
                cw / 2 + (margin / 2),
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
        */


        VBox hbox = new VBox(this.getSceneManager().getTheme(),
                w / 2,
                h / 2,
                800, 400);

        TextButton tb1 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "tb1");
        TextButton tb2 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "tb2");

        hbox.packStart(tb1, new PercentSpaceUsage(40, 100f));

        hbox.packStart(tb2, new PercentSpaceUsage(0, 100f));


        this.attachChild(hbox);
        /*
        TextButton tb1 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "hello");
        //TextButton tb1 = new TextButton(this.getSceneManager().getTheme(), w/2, h/2, cw, ch, "hello");
        tb1.setPosition(w / 2, h / 2);
        tb1.setSize(cw, ch);
        this.attachChild(tb1);
        */


	}
}