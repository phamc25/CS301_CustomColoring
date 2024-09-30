package edu.up.customcoloring;

import android.graphics.Canvas;

/**
 *  @author: Chloe Pham
 *  @date: September 29, 2024
 *  @description: This class defines the circle element
 *
 *  CS301 Programming Assignment
 */

public class CircleElement extends DrawableElements
{
    // Instance variables for circle
    private int x;
    private int y;
    private int radius;

    public CircleElement(String initName, int initColor, int initX, int initY, int initRadius) {
        super(initName, initColor);

        // Assign instance variables to parameters
        this.x = initX;
        this.y = initY;
        this.radius = initRadius;

    }

    // Draw circle
    @Override
    public void drawCanvas(Canvas canvas) {
        canvas.drawCircle(x, y, radius, paint);
    }

    // Returns a boolean if a touch corresponds to the circle
    @Override
    public boolean touchElement(int xLoc, int yLoc) {
        int circleX = xLoc - x;
        int circleY = yLoc - y;
        double pythDistance = Math.sqrt((circleX * circleX) + (circleY * circleY));
        return pythDistance <= radius;
    }
}

/**
 *  External citation
 *  Date: September 23, 2024
 *  Problem: Drawing a circle
 *  Resource:
 *  Nux's Optional helper code
 *  https://learning.up.edu/mod/resource/view.php?id=1851731
 *  Usage: Used to implement a circle element
 */
