package edu.up.customcoloring;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 *  @author: Chloe Pham
 *  @date: September 29, 2024
 *  @description: This class defines the rectangle element
 *
 *  CS301 Programming Assignment
 */

public class RectangleElement extends DrawableElements{

    // Protected
    protected Rect rectangle;

    // Non-default constructor
    public RectangleElement(String name, int color, int left, int top, int right, int bottom) {
        super(name, color);
        this.rectangle = new Rect(left, top, right, bottom);
    }

    @Override
    public void drawCanvas(Canvas canvas) {
        // Draws the rectangle
        canvas.drawRect(rectangle, paint);
    }

    // Returns a boolean if a touch corresponds to the rectangle
    @Override
    public boolean touchElement(int x, int y) {
        // Rectangle with these boundaries
        Rect rect = new Rect(this.rectangle.left, this.rectangle.top, this.rectangle.right, this.rectangle.bottom);
        return rect.contains(x, y);
    }
}

/**
 *  External citation
 *  Date: September 23, 2024
 *  Problem: Drawing a rectangle
 *  Resource:
 *  Nux's Optional helper code
 *  https://learning.up.edu/mod/resource/view.php?id=1851731
 *  Usage: Used to implement a rectangle element
 */
