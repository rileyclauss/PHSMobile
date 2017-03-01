package com.phsapp.phsapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


class RetrieveFeedTask extends AsyncTask<String, Void, Bitmap> {
Bitmap images[] = new Bitmap[6];
    protected Bitmap doInBackground(String... link) {
        try {
            for(int i=0;i<6;i++){
            URL url = new URL(link[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
           //     images[i] = input;
            }
            return images[];
        } catch (Exception e) {
            Exception exception = e;

            return null;
        }
    }

    protected void onPostExecute(Bitmap bm) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}
