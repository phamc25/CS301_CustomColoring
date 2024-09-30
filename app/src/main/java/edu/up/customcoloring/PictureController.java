package edu.up.customcoloring;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 *  @author: Chloe Pham
 *  @date: September 29, 2024
 *  @description: This class defines the controller class
 *
 *  CS301 Programming Assignment
 */

public class PictureController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    // Instance variables
    private DrawableElements latestElement = null;
    private PictureView picView;
    private PictureModel picModel;
    private TextView currElement;
    private TextView redSeekText;
    private TextView blueSeekText;
    private TextView greenSeekText;
    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;

    // Constructor
    public PictureController(PictureView initView, TextView initCurrText, TextView initRed, TextView initGreen, TextView initBlue,
                             SeekBar initRedSeek, SeekBar initGreenSeek, SeekBar initBlueSeek) {
        this.picView = initView;
        this.picModel = initView.getModel();
        this.currElement = initCurrText;
        this.redSeekText = initRed;
        this.greenSeekText = initGreen;
        this.blueSeekText = initBlue;
        this.redSeek = initRedSeek;
        this.greenSeek = initGreenSeek;
        this.blueSeek = initBlueSeek;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        // Get x and y from user touch
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();

        // Set to model variables
        picModel.xLoc = x;
        picModel.yLoc = y;
        picView.performClick();

        // Loop through arraylist, if the touch is a specific element,
        // call the updateCurrElement to change the text view
        for (int i = picModel.shapes.size() - 1; i >= 0; i--) {
            DrawableElements element = picModel.shapes.get(i);
            if (element.touchElement(x, y)) {
                // Get name
                picModel.currText = element.getName();
                updateCurrElement();

                // Loop through the array of elements, if there are other elements with the
                // same name, change those shapes' textviews and seekbar progress
                for (DrawableElements chosenElement : picModel.shapes) {
                    if (chosenElement.getName().equals(picModel.currText)) {
                        latestElement = chosenElement;
                        int color = latestElement.getColor();
                        int red = Color.red(color);
                        int green = Color.green(color);
                        int blue = Color.blue(color);

                        redSeek.setProgress(Color.red(color));
                        greenSeek.setProgress(Color.green(color));
                        blueSeek.setProgress(Color.blue(color));

                        // Set the textview for the seekbar to reflect the RGB values
                        redSeekText.setText("Red: " + Color.red(color));
                        greenSeekText.setText("Green: " + Color.green(color));
                        blueSeekText.setText("Blue: " + Color.blue(color));
                    }
                }
                // Break out of loop when it finds the shape/element that was touched
                break;
            }
        }
        return picModel.screenTouched = true;
    }

    // This method calls setText on the TextView to change its content on the screen
    private void updateCurrElement() {
        currElement.setText("Current Drawing Element: " + picModel.currText);
    }

    // The methods are implemented of the seek bar change view. The progress changed function
    // changes the textview for the RGB seekbars from 0 - 255
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        if (latestElement != null) {
            int red = redSeek.getProgress();
            int green = greenSeek.getProgress();
            int blue = blueSeek.getProgress();

            // Update the paint color
            int newColor = Color.rgb(red, green, blue);

            // Change and set the color for all of the elements that share the same name
            for (DrawableElements chosenElement : picModel.shapes) {
                if (chosenElement.getName().equals(picModel.currText)) {
                    chosenElement.paint.setColor(newColor);
                }
            }

            // Update the textviews based on the new color
            redSeekText.setText("Red: " + red);
            greenSeekText.setText("Green: " + green);
            blueSeekText.setText("Blue: " + blue);

            // Redraw the view to have the new color
            picView.invalidate();
        }
        else {
            // If an element has not been picked, warn the user and do not change any color
            redSeekText.setText("Red: CHOOSE SHAPE FIRST TO CHANGE COLOR");
            greenSeekText.setText("Green: CHOOSE SHAPE FIRST TO CHANGE COLOR");
            blueSeekText.setText("Blue: CHOOSE SHAPE FIRST TO CHANGE COLOR");
        }
    }

    // Empty methods for seekbar
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}

    // Method for what the reset button does when it is clicked
    @Override
    public void onClick(View view) {
        // Reset the drawing back to the original, reset the seekbar progresses,
        // reset the current drawing element.
        picView.originalDrawing();
        latestElement = null;
        currElement.setText("Current Drawing Element: ");
        redSeek.setProgress(0);
        greenSeek.setProgress(0);
        blueSeek.setProgress(0);

        // Redraw the view
        picView.invalidate();
    }
}

/**
 *  External citation
 *  Date: September 27, 2024
 *  Problem: Updating a text view
 *  Resource:
 *  https://stackoverflow.com/questions/13452991/change-textview-text
 *  Usage: Used to get the name of the drawable element that was touched and then update the text of the textview
 */

/**
 *  External citation
 *  Date: September 29, 2024
 *  Problem: Getting RGB values
 *  Resource:
 *  https://stackoverflow.com/questions/20326784/how-can-i-get-red-value-from-rgb-value-android
 *  Usage: Used to get the individual RGB values of a color
 */

/**
 *  External citation
 *  Date: September 29, 2024
 *  Problem: Looping through elements in an array list
 *  Resource:
 *  https://learning.up.edu/pluginfile.php/2567634/mod_folder/content/0/LizardCanvas.java?forcedownload=1
 *  Usage: In-class drawing code used to setup an array list for the objects
 */
