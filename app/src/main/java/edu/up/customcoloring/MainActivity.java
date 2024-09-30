package edu.up.customcoloring;

/**
 *  @author: Chloe Pham
 *  @date: September 29, 2024
 *  @description: This class is the Main Activity where views are being
 *  registered with controllers
 *
 *  CS301 Programming Assignment
 */

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Set view to the activity_main XML
        setContentView(R.layout.activity_main);

        // Find views
        SeekBar red = findViewById(R.id.seekBar);   // Red text and seekbar
        TextView redSeekText = findViewById(R.id.red_text_view);

        SeekBar green = findViewById(R.id.seekBar2);    // Green text and seekbar
        TextView greenSeekText = findViewById(R.id.green_text_view);

        SeekBar blue = findViewById(R.id.seekBar3);     // Blue text and seekbar
        TextView blueSeekText = findViewById(R.id.blue_text_view);

        TextView currElement = findViewById(R.id.textView4);
        PictureView picView = findViewById(R.id.surfaceView);

        Button reset = findViewById(R.id.button);   // Reset Color Button

        // Set the textviews for the seekbars
        redSeekText.setText("Red: " + red.getProgress());
        greenSeekText.setText("Green: " + green.getProgress());
        blueSeekText.setText("Blue: " + blue.getProgress());

        // Instantiate a new controller
        PictureController picCont = new PictureController(picView, currElement, redSeekText, greenSeekText, blueSeekText, red, green, blue);

        // Initialize the RGB sliders
        redSeekText.setText("Red: CHOOSE SHAPE FIRST TO CHANGE COLOR");
        greenSeekText.setText("Green: CHOOSE SHAPE FIRST TO CHANGE COLOR");
        blueSeekText.setText("Blue: CHOOSE SHAPE FIRST TO CHANGE COLOR");

        // Register views with the controller
        picView.setOnTouchListener(picCont);
        reset.setOnClickListener(picCont);
        red.setOnSeekBarChangeListener(picCont);
        blue.setOnSeekBarChangeListener(picCont);
        green.setOnSeekBarChangeListener(picCont);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//
//

    }
}