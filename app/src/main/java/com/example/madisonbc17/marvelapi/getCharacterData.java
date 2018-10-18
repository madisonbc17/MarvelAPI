package com.example.madisonbc17.marvelapi;

import android.os.AsyncTask;
import android.view.View;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class getCharacterData extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    //background thread
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://gateway.marvel.com/v1/public/characters?ts=1&apikey=a2a791839ba4018cf95f2136f9f6f7f0&hash=321c1b276a3a68506b1c3506e06501dd");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            StringBuffer response = new StringBuffer();
            while((line = bufferedReader.readLine())  != null) {
                //line = bufferedReader.readLine();
                //data = data + line;
                response.append(line);
            } bufferedReader.close();

            JSONObject marvel_api = new JSONObject(response.toString());
            JSONObject marvel_data = (JSONObject) marvel_api.get("data");
            JSONArray marvel_results = marvel_data.getJSONArray("results");

            for(int i = 0; i < marvel_results.length(); i++) {
                JSONObject character = (JSONObject) marvel_results.get(i);
                singleParsed = "Name: " + character.get("name") + "\n\n" +
                        "Description: " + character.get("description") + "\n";
                dataParsed = dataParsed + singleParsed + "\n\n";
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    //UI thread
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        characterPage.data.setText(this.dataParsed);
        characterPage.wait.setVisibility(View.GONE);;
    }
}
