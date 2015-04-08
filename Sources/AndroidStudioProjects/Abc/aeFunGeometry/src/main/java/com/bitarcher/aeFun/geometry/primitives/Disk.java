package com.bitarcher.aeFun.geometry.primitives;

import org.andengine.entity.primitive.DrawMode;
import org.andengine.entity.primitive.Mesh;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/*
 * Copyright (c) 2015.
 * Michel Strasser
 * bitarcher.com
 */

/**
 * Created by michel on 08/04/15.
 */
public class Disk extends Mesh {

    public Disk(float x, float y, float width, float height, int numOfFanSectors, VertexBufferObjectManager pVertexBufferObjectManager) {
        super(x, y, width, height, Disk.getCoordinates(width, height, numOfFanSectors), numOfFanSectors + 1, DrawMode.TRIANGLE_FAN, pVertexBufferObjectManager);


        // blue by default, but the color has to be set by the container
        this.setColor(0, 0, 1);
    }

    static float[] getCoordinates(float width, float height, int numOfFanSectors)
    {
        float UNUSED = 0;

        assert(numOfFanSectors >= 3);

        // coordinates for triangle_strip
        float[] retval = new float[(numOfFanSectors + 1) * 3];

        float w2 = width / 2;
        float h2 = height / 2;

        // p0 = center
        retval[0] = w2;
        retval[1] = h2;
        retval[2] = UNUSED;

        for(int i= 1 ; i <= numOfFanSectors ; i++)
        {
            int i3 = i*3;
            double angle = (i - 1) * 2 * Math.PI / numOfFanSectors ;
            retval[i3] = (float)Math.cos(angle) * w2 + w2;
            retval[i3 + 1] = (float)Math.sin(angle) * h2 + h2;
            retval[i3 + 2] = UNUSED;
        }

        return retval;
    }
}
