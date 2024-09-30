package edu.up.customcoloring;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 *  @author: Chloe Pham
 *  @description: This class defines the specifics of custom elements in the
 *  SurfaceView drawing. It is a base class for the other elements
 *
 *  CS301 Programming Assignment
 */

public abstract class DrawableElements {

    // Instance variables
    protected Paint paint = new Paint();
    protected String elementName = "$NO NAME$";
//    protected int ogColor;

    // Non-default Constructor
    public DrawableElements(String initName, int initColor) {
        setColor(initColor);
        this.elementName = initName;
    }

    public void setColor(int color) {
        // If the color is the same
        if (color == paint.getColor())
            return;

        // If not, set the color
        this.paint.setColor(color);
    }

    // Paint getter for changing
    public int getColor() {
        return this.paint.getColor();
    }

    // Name getter
    public String getName() {
        return this.elementName;
    }

    // Abstract methods *Override in subclass drawings*
    // Draws
    public abstract void drawCanvas(Canvas canvas);
    // Returns a boolean if a touch corresponds to a shape
    public abstract boolean touchElement(int x, int y);
}

/**
 *  External citation
 *  Date: September 23, 2024
 *  Problem: Setting up the base class for the elements
 *  Resource:
 *  Nux's Optional helper code
 *  https://learning.up.edu/mod/resource/view.php?id=1851731
 *  Usage: Learned to use abstract classes/methods
 */
