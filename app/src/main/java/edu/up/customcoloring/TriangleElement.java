package edu.up.customcoloring;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 *  @author: Chloe Pham
 *  @description: This class defines the triangle element
 *
 *  CS301 Programming Assignment
 */

public class TriangleElement extends DrawableElements {

    // Protected path triangle
    protected Path triangle;

    // Non-default constructor
    public TriangleElement(String initName, int initColor, int x1, int y1, int x2, int y2, int x3, int y3) {
        super(initName, initColor);

        // Plot the triangle points
        triangle = new Path();
        triangle.moveTo(x1, y1);
        triangle.lineTo(x2, y2);
        triangle.lineTo(x3, y3);
        triangle.close();
    }

    // Draw triangle
    @Override
    public void drawCanvas(Canvas canvas) {
        canvas.drawPath(triangle, paint);
    }
}

/**
 *  External citation
 *  Date: September 23, 2024
 *  Problem: Did not know how to draw a triangle
 *  Resource:
 *  https://stackoverflow.com/questions/3501126/how-to-draw-a-filled-triangle-in-android-canvas
 *  Usage: Used path class to define triangle shape
 */
