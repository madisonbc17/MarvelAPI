package com.example.madisonbc17.marvelapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class characterPage extends AppCompatActivity {
    public static TextView data;
    public static ProgressBar wait;

    Button clickHome;
    Button getCharacterData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_page);

        //set textview data
        data = (TextView) findViewById(R.id.characterData);

        //set up progress bar
        wait = (ProgressBar) findViewById(R.id.progressBar1);
        wait.setVisibility(View.GONE);

        //set up functions to address when buttons are listened to
        configureHomeButton();
        configureGetCharacterDataButton();

    }

    private void configureHomeButton() {
        clickHome = (Button) findViewById(R.id.backButton);
        //when clicked, take the user back to the home page and finish the start activity
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
                //when the button is clicked, get the character data and fill the text view
                wait.setVisibility(View.VISIBLE);
                getCharacterData process = new getCharacterData();
                process.execute();
            }
        });
    }
}
