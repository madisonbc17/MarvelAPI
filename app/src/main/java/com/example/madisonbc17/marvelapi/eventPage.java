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
        data = (TextView) findViewById(R.id.eventData);
        wait = (ProgressBar) findViewById(R.id.progressBar1);
        wait.setVisibility(View.GONE);
        configureHomeButton();
        configureGetEventDataButton();
    }

    private void configureHomeButton() {
        clickHome = (Button) findViewById(R.id.backButton);
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
                //get the event data
                wait.setVisibility(View.VISIBLE);
                getEventData process = new getEventData();
                process.execute();
                //wait.setVisibility(View.GONE);
            }
        });
    }
}
