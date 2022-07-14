package com.example.asynctaskdep;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
    public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar mProgressBar;
    public DownloadTask(ProgressBar progressBar) {
        mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override //this method will execute on a background thread
    protected Bitmap doInBackground(String... strings) {
        Log.i(TAG, "downloading--" + strings[0]);
        for (int i = 1; i < 21; i++){
            publishProgress(i*5);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mProgressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        mProgressBar.setVisibility(View.INVISIBLE);
    }
}