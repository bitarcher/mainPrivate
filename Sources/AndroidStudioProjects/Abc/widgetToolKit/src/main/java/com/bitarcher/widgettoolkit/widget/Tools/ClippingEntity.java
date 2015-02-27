/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

package com.bitarcher.widgettoolkit.widget.Tools;

import android.graphics.PointF;
import android.opengl.GLES20;

import com.bitarcher.interfaces.gui.theme.ITheme;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.util.GLState;


/**
 * Created by michel on 27/02/15.
 */
public class ClippingEntity extends Entity  {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    protected float clipX;
    protected float clipY;
    protected float clipW;
    protected float clipH;

    protected float changedX;
    protected float changedY;
    protected Boolean isChangedPosition = false;

    protected int cameraH;
    protected float screenRatioX;
    protected float screenRatioY;

    // ===========================================================
    // Constructors
    // ===========================================================

    public ClippingEntity(ITheme theme, Scene scene, float clipX, float clipY, float clipW, float clipH) {
        super(clipX, clipY, clipW, clipH);
        this.clipX = clipX;
        this.clipY = clipY;
        this.clipW = clipW;
        this.clipH = clipH;

        setWidth(clipW);
        setHeight(clipH);


        cameraH = (int)theme.getThemeManager().getResourceManager().getEngine().getCamera().getHeight();
        screenRatioX = 1.0f; // TODO app.getScreenRatioX();
        screenRatioY = 1.0f; // TODO app.getScreenRatioY();
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onManagedDraw(GLState pGL, Camera pCamera) {
        super.onManagedDraw(pGL, pCamera);

        float[] sceneCoordinates = this.convertLocalCoordinatesToSceneCoordinates(this.getX(), this.getY());
        PointF point = new PointF(sceneCoordinates[0], sceneCoordinates[1]);

        pGL.pushModelViewGLMatrix();
        //pGL.glEnable(GL10.GL_SCISSOR_TEST);
        pGL.enableScissorTest();

        // Calculation for y position
        // 1. clip y + global y = global clip y
        // 2. global clip y + clip height = bottom of clip
        // 3. camera height - bottom of clip = y position from bottom edge
        // 4. y position from bottom edge * ratio = y position in display size for glScissor()

        GLES20.glScissor(Math.round(((clipX + point.x)) * screenRatioX),
                Math.round((cameraH - ((clipY + point.y) + clipH)) * screenRatioY),
                Math.round(clipW * screenRatioX),
                Math.round(clipH * screenRatioY));

        super.onManagedDraw(pGL, pCamera);

        //pGL.glDisable(GL10.GL_SCISSOR_TEST);
        pGL.disableScissorTest();
        //pGL.glPopMatrix();
        pGL.popModelViewGLMatrix();
    }



/*
    @Override
    protected void onManagedDraw(GL10 pGL, Camera pCamera) {


    }*/

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}