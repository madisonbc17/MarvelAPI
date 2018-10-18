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
    //private int status = 0;

    //private Handler waitHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wait = (ProgressBar) findViewById(R.id.progressBar1);

        wait.setVisibility(View.GONE);
        //wait.setVisibility(View.VISIBLE);


        configureCharacterButton();
        configureEventButton();
    }
    private void configureCharacterButton() {
        click1 = (Button) findViewById(R.id.button1);
        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wait.setVisibility(View.VISIBLE);
                //go to the character page
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
                //go to the events page
                startActivity(new Intent(MainActivity.this, eventPage.class));
                wait.setVisibility(View.GONE);
            }
        });
    }
}