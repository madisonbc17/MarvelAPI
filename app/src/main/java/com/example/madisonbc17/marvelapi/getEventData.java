package com.example.madisonbc17.marvelapi;

import android.os.AsyncTask;
import android.view.View;

import com.example.madisonbc17.marvelapi.MainActivity;

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

public class getEventData extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";

    //background thread
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //set the API call url
            URL url = new URL("https://gateway.marvel.com/v1/public/events?ts=1&apikey=a2a791839ba4018cf95f2136f9f6f7f0&hash=321c1b276a3a68506b1c3506e06501dd");
            //make the API call
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //get the data from the API call
            InputStream inputStream = httpURLConnection.getInputStream();
            //read the API data into a buffer
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            StringBuffer response = new StringBuffer();
            while((line = bufferedReader.readLine())  != null) {
                response.append(line);
            } bufferedReader.close();

            //filter the API call data into the JSON Array you want- we want "results" array
            JSONObject marvel_api = new JSONObject(response.toString());
            JSONObject marvel_data = (JSONObject) marvel_api.get("data");
            JSONArray marvel_results = marvel_data.getJSONArray("results");

            //get JSON array into a readable format
            for(int i = 0; i < marvel_results.length(); i++) {
                JSONObject event = (JSONObject) marvel_results.get(i);
                singleParsed = "Title: " + event.get("title") + "\n\n" +
                        "Description: " + event.get("description") + "\n\n\n";
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

        //set the text view to the readable data we got from the API
        eventPage.data.setText(this.dataParsed);
        //make the progress bar invisible
        eventPage.wait.setVisibility(View.GONE);
    }
}
