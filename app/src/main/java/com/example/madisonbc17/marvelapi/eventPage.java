package com.example.madisonbc17.marvelapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class eventPage extends AppCompatActivity {
    public static TextView data;
    public static ProgressBar wait;

    Button clickHome;
    Button getEventData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);

        //set up the data for the text view
        data = (TextView) findViewById(R.id.eventData);
        //set up a progress bar
        wait = (ProgressBar) findViewById(R.id.progressBar1);
        //set set the progress bar to be invisible
        wait.setVisibility(View.GONE);

        //configure functions for the buttons
        configureHomeButton();
        configureGetEventDataButton();
    }

    private void configureHomeButton() {
        clickHome = (Button) findViewById(R.id.backButton);
        //when this button is clicked, take user back to home page
        clickHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configureGetEventDataButton() {
        getEventData = (Button) findViewById(R.id.getEvents);
        getEventData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when clicked get data for the text view
                //set progress bar to show
                wait.setVisibility(View.VISIBLE);
                getEventData process = new getEventData();
                process.execute();
            }
        });
    }
}
