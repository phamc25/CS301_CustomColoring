package edu.up.customcoloring;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

/**
 *  @author: Chloe Pham
 *  @description: This class calls the drawings on DrawableElements to
 *  to draw on the SurfaceView
 *
 *  CS301 Programming Assignment
 */

public class PictureSurfaceView extends SurfaceView {

    // Instance variables
    private int darkPurple = 0xFF260e42;
    private int purple = 0xFF3d0191;
    private int darkBlue = 0xFF000c2e;
    private int yellow = 0xFFefeb00;
    private int black = 0xFF000000;
    private int brown = 0xFF4a2c27;
    private int white = 0xFFFFFFFF;

    private RectangleElement rect1;
    private RectangleElement rect2;
    private RectangleElement rect3;

    private RectangleElement window1;
    private RectangleElement window2;
    private RectangleElement window3;
    private RectangleElement window4;

    private RectangleElement door;

    private CircleElement moon;

    private TriangleElement roof1;
    private TriangleElement roof2;
    private TriangleElement roof3;

    private CircleElement ghostBody;
    private TriangleElement ghostBottom;
    private CircleElement ghostEye1;
    private CircleElement ghostEye2;
    private CircleElement ghostMouth;

    // Constructor
    public PictureSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Draws the canvas at the correct time
        setWillNotDraw(false);

        // Draw ghost
        ghostBody = new CircleElement("Ghost", white, 200, 400, 80);
        ghostBottom = new TriangleElement("Ghost", white, 120, 410, 280, 410, 200, 600);
        ghostEye1 = new CircleElement("Ghost", black, 150, 380, 10);
        ghostEye2 = new CircleElement("Ghost", black, 250, 380, 10);
        ghostMouth = new CircleElement("Ghost", black, 200, 400, 20);

        // Draw house walls
        rect1 = new RectangleElement("House", purple, 750, 400, 1250, 1000);
        rect2 = new RectangleElement("House", purple, 400, 600, 750, 1000);
        rect3 = new RectangleElement("House", purple, 1250, 600, 1600, 1000);

        // Draw roof
        roof1 = new TriangleElement("Roof", darkPurple, 1000, 100, 700, 400, 1300, 400);
        roof2 = new TriangleElement("Roof", darkPurple, 575, 400, 400, 600, 750, 600);
        roof3 = new TriangleElement("Roof", darkPurple, 1425, 400, 1250, 600, 1600, 600);

        // Draw moon
        moon = new CircleElement("Moon", yellow, 1850, 100, 300);

        // Draw windows
        window1 = new RectangleElement("Window", black, 850, 450, 950, 600);
        window2 = new RectangleElement("Window", black, 1050, 450, 1150, 600);
        window3 = new RectangleElement("Window", black, 525, 650, 625, 800);
        window4 = new RectangleElement("Window", black, 1375, 650, 1475, 800);

        // Draw door
        door = new RectangleElement("Door", brown, 950, 800, 1050, 1000);

        setBackgroundColor(darkBlue);
    }

    // On Draw method
    @Override
    protected void onDraw(Canvas canvas) {
        rect1.drawCanvas(canvas);
        rect2.drawCanvas(canvas);
        rect3.drawCanvas(canvas);
        moon.drawCanvas(canvas);
        roof1.drawCanvas(canvas);
        roof2.drawCanvas(canvas);
        roof3.drawCanvas(canvas);
        window1.drawCanvas(canvas);
        window2.drawCanvas(canvas);
        window3.drawCanvas(canvas);
        window4.drawCanvas(canvas);
        door.drawCanvas(canvas);
        ghostBody.drawCanvas(canvas);
        ghostBottom.drawCanvas(canvas);
        ghostEye1.drawCanvas(canvas);
        ghostEye2.drawCanvas(canvas);
        ghostMouth.drawCanvas(canvas);
    }
}

/**
 *  External citation
 *  Date: September 23, 2024
 *  Problem: Drawing elements
 *  Resource:
 *  https://learning.up.edu/pluginfile.php/2563492/mod_resource/content/1/LizardCanvas.java
 *  Usage: In-class drawing code used to setup this surface view and drawing elements
 */

