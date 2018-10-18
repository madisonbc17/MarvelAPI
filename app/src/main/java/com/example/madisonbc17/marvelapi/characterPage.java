package com.example.madisonbc17.marvelapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class characterPage extends AppCompatActivity {
    public static TextView data;
    //public static int done = 0;
    public static ProgressBar wait;

    Button clickHome;
    Button getCharacterData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_page);
        data = (TextView) findViewById(R.id.characterData);
        wait = (ProgressBar) findViewById(R.id.progressBar1);
        wait.setVisibility(View.GONE);
        //wait.setVisibility(View.VISIBLE);
        configureHomeButton();
        configureGetCharacterDataButton();

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

    private void configureGetCharacterDataButton() {
        getCharacterData = (Button) findViewById(R.id.getCharacters);
        getCharacterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the character data
                wait.setVisibility(View.VISIBLE);
                getCharacterData process = new getCharacterData();
                process.execute();
                //wait.setVisibility(View.GONE);
            }
        });
    }
}
