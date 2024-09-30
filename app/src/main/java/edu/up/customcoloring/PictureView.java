package edu.up.customcoloring;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author: Chloe Pham
 *  @description: This class calls the drawings on DrawableElements to
 *  to draw on the SurfaceView
 *
 *  CS301 Programming Assignment
 */

public class PictureView extends SurfaceView {

    // Instance variables
    private PictureModel picModel = new PictureModel();
    private List<DrawableElements> elements;

    // Colors for the elements
    private int darkPurple = 0xFF260e42;
    private int purple = 0xFF3d0191;
    private int darkBlue = 0xFF000c2e;
    private int yellow = 0xFFefeb00;
    private int black = 0xFF000000;
    private int brown = 0xFF4a2c27;
    private int white = 0xFFFFFFFF;

    // Constructor
    public PictureView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Draws the canvas at the correct time
        setWillNotDraw(false);

        // Instantiates the new arraylist for the drawable elements
        elements = new ArrayList<>();
        originalDrawing();
    }

    // On Draw method
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(darkBlue);
        // Loops through the list and draws the objects recently put into the model array on the canvas
        for (DrawableElements element : picModel.shapes) {
            element.drawCanvas(canvas);
        }
    }

    //  Getter for the model
    public PictureModel getModel() {
        return this.picModel;
    }

    // This method draws the picture with original color
    public void originalDrawing () {
        picModel.shapes.clear();
        elements.clear();
        // Draw ghost
        elements.add(new CircleElement("Ghost", white, 200, 400, 80));
        elements.add(new TriangleElement("Ghost", white, 120, 410, 280, 410, 200, 600));
        elements.add(new CircleElement("Ghost Face", black, 150, 380, 10));
        elements.add(new CircleElement("Ghost Face", black, 250, 380, 10));
        elements.add(new CircleElement("Ghost Face", black, 200, 400, 20));

        // Draw house walls
        elements.add(new RectangleElement("House", purple, 750, 400, 1250, 1000));
        elements.add(new RectangleElement("House", purple, 400, 600, 750, 1000));
        elements.add(new RectangleElement("House", purple, 1250, 600, 1600, 1000));

        // Draw roof
        elements.add(new TriangleElement("Roof", darkPurple, 1000, 100, 700, 400, 1300, 400));
        elements.add(new TriangleElement("Roof", darkPurple, 575, 400, 400, 600, 750, 600));
        elements.add(new TriangleElement("Roof", darkPurple, 1425, 400, 1250, 600, 1600, 600));

        // Draw moon
        elements.add(new CircleElement("Moon", yellow, 1850, 100, 300));

        // Draw windows
        elements.add(new RectangleElement("Window", black, 850, 450, 950, 600));
        elements.add(new RectangleElement("Window", black, 1050, 450, 1150, 600));
        elements.add(new RectangleElement("Window", black, 525, 650, 625, 800));
        elements.add(new RectangleElement("Window", black, 1375, 650, 1475, 800));

        // Draw door
        elements.add(new RectangleElement("Door", brown, 900, 700, 1100, 1000));
        picModel.addAllElements(elements);
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

/**
 *  External citation
 *  Date: September 29, 2024
 *  Problem: Looping through elements in an array list
 *  Resource:
 *  https://learning.up.edu/pluginfile.php/2567634/mod_folder/content/0/LizardCanvas.java?forcedownload=1
 *  Usage: In-class drawing code used to setup an array list for the objects
 */

