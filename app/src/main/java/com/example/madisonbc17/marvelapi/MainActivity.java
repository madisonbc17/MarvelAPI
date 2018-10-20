package com.example.madisonbc17.marvelapi;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    Button click1;
    Button click2;
    private ProgressBar wait;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set progress bar for when info takes a while to load
        wait = (ProgressBar) findViewById(R.id.progressBar1);

        //make sure it disappears until we want something to load or run in background
        wait.setVisibility(View.GONE);

        //configure functions that handle event listeners on click for each button
        configureCharacterButton();
        configureEventButton();
    }
    private void configureCharacterButton() {
        click1 = (Button) findViewById(R.id.button1);
        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //once the button is clicked, take the user to the character page
                wait.setVisibility(View.VISIBLE);
                startActivity(new Intent(MainActivity.this, characterPage.class));
                wait.setVisibility(View.GONE);
            }
        });
    }
    private void configureEventButton() {
        click2 = (Button) findViewById(R.id.button2);
        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wait.setVisibility(View.VISIBLE);
                //once the button is clicked, take user to the events page
                startActivity(new Intent(MainActivity.this, eventPage.class));
                wait.setVisibility(View.GONE);
            }
        });
    }
}

//did this update get on Github?