/*
 * Copyright (c) 2015. 
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.abc;


import com.bitarcher.abcbllorm.BLL.Player;
import com.bitarcher.abcbllorm.ConfigurationSingleton;
import com.bitarcher.abcbllorm.DAL.DatabaseHelper;
import com.bitarcher.interfaces.gui.theme.IThemeManager;
import com.bitarcher.interfaces.sceneManagement.ISceneManagerConfigurator;
import com.bitarcher.interfaces.sceneManagement.ITSceneManager;
import com.bitarcher.resourcemanagement.ResourceManager;
import com.bitarcher.scenemanagement.SceneManagedActivity;
import com.bitarcher.widgettoolkit.theme.DefaultTheme;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;


public class MainActivity extends SceneManagedActivity<ResourceManager, DefaultTheme, MainMenu, OptionsLayer> {

    // ===========================================================
    // Constants
    // ===========================================================

    DatabaseHelper databaseHelper = null;
    OrmConfigurator ormConfigurator = null;

    @Override
    protected ISceneManagerConfigurator<ResourceManager, DefaultTheme, MainMenu, OptionsLayer> getSceneManagerConfigurator() {
        return new ISceneManagerConfigurator<ResourceManager, DefaultTheme, MainMenu, OptionsLayer>() {
            @Override
            public ResourceManager getNewResourceManager() {
                return new ResourceManager();
            }


            @Override
            public int getCameraWidth() {
                return 800;
            }

            @Override
            public int getCameraHeight() {
                return 480;
            }

            @Override
            public float getCameraScaleFactorX() {
                return 1.0f;
            }

            @Override
            public float getCameraScaleFactorY() {
                return 1.0f;
            }

            @Override
            public DefaultTheme getNewTheme(IThemeManager themeManager) {
                return new DefaultTheme(themeManager, "@Default");
            }

            @Override
            public MainMenu getNewMainMenu(ITSceneManager<ResourceManager, DefaultTheme, MainMenu, OptionsLayer> sceneManager, DefaultTheme theme, ResourceManager resourceManager) {
                return new MainMenu(sceneManager);
            }

            @Override
            public OptionsLayer getNewOptionsLayer(ITSceneManager<ResourceManager, DefaultTheme, MainMenu, OptionsLayer> sceneManager, DefaultTheme theme, ResourceManager resourceManager, MainMenu mainMenu) {
                return new OptionsLayer(sceneManager);
            }
        };
    }


    // ===========================================================


    @Override
    public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) {


        //this.themeManager = new ThemeManager(resourceManager);
        //resourceManager.setup(this.mEngine, this.getApplicationContext(), CAMERA_WIDTH, CAMERA_HEIGHT, 1f, 1f, this.themeManager);

        //SceneManager.getInstance().setup(resourceManager);

        //this.theme = new DefaultTheme(themeManager, "raw/theme/default");
        //themeManager.setCurrentTheme(theme);

        super.onCreateResources(pOnCreateResourcesCallback);

        this.ormConfigurator = new OrmConfigurator(this);

        ConfigurationSingleton.getInstance().setConfigurator(this.ormConfigurator);
    }

    @Override
    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) {
        super.onCreateScene(pOnCreateSceneCallback);

        /*TextButtonScene textButtonScene = new TextButtonScene(this.getSceneManager());
        this.getSceneManager().showScene(textButtonScene);*/

        /*// test
        DatabaseHelper dh = this.getDatabaseHelper();

        try {
            Dao<Player, Integer> dao = dh.getDao(Player.class);

            Player p = new Player("singe");

            p.setDao(dao);
            p.update();

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }

    public DatabaseHelper getDatabaseHelper()
    {
        if (databaseHelper == null) {
            databaseHelper =
                    OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }
}
