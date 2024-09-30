package edu.up.customcoloring;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;

/**
 *  @author: Chloe Pham
 *  @description: This class defines the triangle element
 *
 *  CS301 Programming Assignment
 */

public class TriangleElement extends DrawableElements {

    // Protected path triangle
    protected Path triangle;
    private Region triRegion;

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

    // Returns a boolean if a touch corresponds to the triangle
    @Override
    public boolean touchElement(int x, int y) {
        // In order to see if the x and y has touched the triangle, create a new region from a rect object
        // and set the path for the triangle
        RectF rect = new RectF();
        triangle.computeBounds(rect, true);
        triRegion = new Region();
        triRegion.setPath(triangle, new Region((int) rect.left, (int) rect.top, (int) rect.right, (int) rect.bottom));
        return triRegion.contains(x, y);

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

/**
 *  External citation
 *  Date: September 27, 2024
 *  Problem: Did not know how the functions to detect if a touch was inside of a triangle (path)
 *  Resource:
 *  https://stackoverflow.com/questions/2597590/how-can-i-tell-if-a-closed-path-contains-a-given-point
 *  Usage: Used new region object to find the points x and y that the triangle contains
 */
