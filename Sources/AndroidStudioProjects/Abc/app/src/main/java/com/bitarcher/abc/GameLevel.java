package com.bitarcher.abc;

import com.bitarcher.abc.gameLevels.common.GameLevelBase;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButton;
import com.bitarcher.aeFun.interfaces.gui.widgets.IButtonListener;
import com.bitarcher.aeFun.interfaces.mvc.IImage;
import com.bitarcher.aeFun.interfaces.mvc.MvcImageTuple;
import com.bitarcher.aeFun.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromAssetResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.BitmapTexturesSetFromResIdsResourceInfo;
import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneAssetBitmapTexture;

import com.bitarcher.aeFun.resourceManagement.ResourcesInfos.SubInfos.OneResBitmapTexture;
import com.bitarcher.aeFun.sceneManagement.ManagedGameScene;

import com.bitarcher.aeFun.widgetToolkit.widget.ImageButton;
import com.bitarcher.aeFun.widgetToolkit.widget.Table;
import com.bitarcher.aeFun.widgetToolkit.widget.Tools.Containers.PercentSpaceUsage;
import com.bitarcher.aeFun.widgetToolkit.widget.TextButton;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;


public class GameLevel extends GameLevelBase {

    BitmapTexturesSetFromAssetResourceInfo bitmapTexturesSetFromAssetResourceInfo;
    //SvgTexturesSetFromResIdsResourceInfo animalsTexturesSet = new SvgTexturesSetFromResIdsResourceInfo("animals", this.getSceneManager().getResourceManager().getContext(), 1024, 256);
    //SvgTexturesSetFromAssetResourceInfo animalsTexturesSet = new SvgTexturesSetFromAssetResourceInfo("animals", 1024, 256, "");
    BitmapTexturesSetFromResIdsResourceInfo animalsTexturesSet = new BitmapTexturesSetFromResIdsResourceInfo("animals", 1024, 1024, BitmapTextureFormat.RGBA_4444, null, this.getSceneManager().getResourceManager().getContext());
    IImage cat;

    public GameLevel(MainMenu mainMenu) {

        super(mainMenu, 0);

        int width = 240,height = 240;

        //animalsTexturesSet.addOneTexture(new OneResBitmapTexture("abeille", R.drawable.svg_animal_abeille));
        animalsTexturesSet.addOneTexture(new OneResBitmapTexture("chat", R.drawable.svg_animal_chat));
        //animalsTexturesSet.addOneTexture(new OneResBitmapTexture("dauphin", R.drawable.svg_animal_dauphin));
        //animalsTexturesSet.addOneTexture(new OneResBitmapTexture("éléphant", R.drawable.svg_animal_elephant));
        /*animalsTexturesSet.addOneTexture(new OneResSvgTexture("abeille", R.raw.svg_animal_abeille, width, height));
        animalsTexturesSet.addOneTexture(new OneResSvgTexture("chat", R.raw.svg_animal_chat, width, height));
        animalsTexturesSet.addOneTexture(new OneResSvgTexture("dauphin", R.raw.svg_animal_dauphin, width, height));
        animalsTexturesSet.addOneTexture(new OneResSvgTexture("éléphant", R.raw.svg_animal_elephant, width, height));
*/
      /*  animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("abeille", "svg_animal_abeille.svg", width, height));
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("chat", "svg_animal_chat.svg", width, height));
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("dauphin", "svg_animal_dauphin.svg", width, height));
        animalsTexturesSet.addOneTexture(new OneAssetSvgTexture("éléphant", "svg_animal_elephant.svg", width, height));
*/
        this.bitmapTexturesSetFromAssetResourceInfo = new BitmapTexturesSetFromAssetResourceInfo("gameLevel", 1024, 512, BitmapTextureFormat.RGBA_4444, null, "gfx/MainMenu/");
        this.bitmapTexturesSetFromAssetResourceInfo.addOneTexture((new OneAssetBitmapTexture("cloud", "cloud.png")));

        this.getSceneManager().getResourceManager().pushRequirement(this.animalsTexturesSet);
        this.cat = new MvcImageTuple(this.animalsTexturesSet,  "chat", 1);
        //this.cat = new WImage(this.bitmapTexturesSetFromAssetResourceInfo,  "cloud");




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

        //this.getSceneManager().getResourceManager().pushRequirement(animalsTexturesSet);
    }

    @Override
    public void onUnloadManagedScene() {
        super.onUnloadManagedScene();

        //this.getSceneManager().getResourceManager().popRequirement(animalsTexturesSet);
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

        final TextButton tb1 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "tb1");
        final ImageButton tb2 = new ImageButton(this.getSceneManager().getTheme(), 0,0,100, 100, this.cat);
        final TextButton tb3 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "tb3");
        final TextButton tb4 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "tb4");
        final TextButton tb5 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "tb5");
        final TextButton tb6 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "tb6");
        final TextButton tb7 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "tb7");
        final TextButton tb8 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "tb8");
        final TextButton tb9 = new TextButton(this.getSceneManager().getTheme(), 0,0,100, 100, "tb9");

        tb1.setPadding(2);
        tb3.setPadding(4);

        

        /*
        final HBox container = new HBox(this.getSceneManager().getTheme(),
                w / 2,
                h / 2,
                800, 400);



        container.packStart(tb1, new FixedSpaceUsage(0, 50f));

        container.packStart(tb2, new PercentSpaceUsage(0, 100f));
        container.packStart(tb3, new PercentSpaceUsage(0, 200f));

        this.attachChild(container);
        */


        final Table container = new Table(this.getSceneManager().getTheme(),
                w / 3,
                h / 2,
                200, 200);

        //container.addHomogeneousColumnsAndRows(3, 3, 5);

        container.addColumn(new PercentSpaceUsage(0, 100));
        container.addColumn(new PercentSpaceUsage(0, 200));
        container.addColumn(new PercentSpaceUsage(0, 300));

        container.addRow(new PercentSpaceUsage(0, 100));
        container.addRow(new PercentSpaceUsage(0, 200));
        container.addRow(new PercentSpaceUsage(0, 300));

        container.attachChild(tb1, 0, 0);
        container.attachChild(tb2, 1, 0, 2, 2);
        container.attachChild(tb3);
        container.attachChild(tb4);
        container.attachChild(tb5);
        container.attachChild(tb6);
        //container.attachChild(tb7);
        //container.attachChild(tb8);
        //container.attachChild(tb9);
        this.attachChild(container);


        
        tb1.addButtonListener(new IButtonListener() {
            @Override
            public void onClicked(IButton button) {
                container.detachChild(tb1);
            }
        });

        tb2.addButtonListener(new IButtonListener() {
            @Override
            public void onClicked(IButton button) {
                container.detachChild(tb2);
            }
        });



        Sprite catSprite = new Sprite(30, 30, 60, 60, this.getSceneManager().getResourceManager().getTextureRegionFromTextureSetByName(this.animalsTexturesSet, "chat"), this.getSceneManager().getResourceManager().getEngine().getVertexBufferObjectManager());
        this.attachChild(catSprite);


    }
}

