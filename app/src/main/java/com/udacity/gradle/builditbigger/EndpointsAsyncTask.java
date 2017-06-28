package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import com.msaenz424.backend.myJokeApi.MyJokeApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyJokeApi myApiService = null;
    private Context mContext;
    public OnTaskCompleted mOnTaskCompleted = null;

    public EndpointsAsyncTask(Context context){
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... context) {
        if(myApiService == null) {  // Only do this once
            MyJokeApi.Builder builder = new MyJokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    //.setRootUrl("http://192.168.8.101:8080/_ah/api/")
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    //.setRootUrl("https://finaljokes-161017.appspot.com/_ah/api/") --> use this for deploying
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        String result = null;
        try {
            result = myApiService.sayRandomJoke().execute().getData();
        } catch (IOException e) {
            Log.e("myApiService error", e.toString());
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        mOnTaskCompleted.onTaskCompleted(result);
    }
}
