package edu.up.customcoloring;

import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author: Chloe Pham
 *  @description: This class defines the model class
 *
 *  CS301 Programming Assignment
 */

public class PictureModel {
    // These variables are shared between the controller and the view
    public List<DrawableElements> shapes = new ArrayList<>();
    public boolean screenTouched;
    public float xLoc;
    public float yLoc;
    public String currText;

    // This method adds the elements that are in the arraylist in the controller in
    // the arraylist here (shapes)
    public void addAllElements(List<DrawableElements> elements) {
        shapes.addAll(elements); // Ensure 'elements' is a List<DrawableElement>
    }
}
