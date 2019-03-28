package com.example.kineduexample.ui.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.example.kineduexample.data.network.model.Activities;
import com.example.kineduexample.data.network.model.ArticleDetail;
import com.example.kineduexample.data.network.model.Articles;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DownloadImageFromInternet extends AsyncTask<String, Void, List<Bitmap>> {
    OnBitmapCreatedListener mListener;
    List<?> list;

    public DownloadImageFromInternet(OnBitmapCreatedListener mListener, List<?> list) {
        this.mListener = mListener;
        this.list = list;
    }

    protected List<Bitmap> doInBackground(String... urls) {
        List<Bitmap> activitiesThumbnails = new ArrayList<>();
        if(list.get(0) instanceof Activities) {
            for (Activities activity :(List<Activities>) list) {
                Bitmap bimage;
                try {
                    InputStream in = new java.net.URL(activity.getThumbnail()).openStream();
                    bimage = BitmapFactory.decodeStream(in);
                    activitiesThumbnails.add(bimage);
                } catch (Exception e) {
                    Log.e("Error Message", e.getMessage());
                    e.printStackTrace();
                }
            }
        }else if(list.get(0) instanceof Articles){
            for (Articles articles :(List<Articles>) list) {
                Bitmap bimage;
                try {
                    InputStream in = new java.net.URL(articles.getPicture()).openStream();
                    bimage = BitmapFactory.decodeStream(in);
                    activitiesThumbnails.add(bimage);
                } catch (Exception e) {
                    Log.e("Error Message", e.getMessage());
                    e.printStackTrace();
                }
            }
        }else{
            ArticleDetail articleDetail =  (ArticleDetail) list.get(0);
            Bitmap bimage;
            try {
                InputStream in = new java.net.URL(articleDetail.getPicture()).openStream();
                bimage = BitmapFactory.decodeStream(in);
                activitiesThumbnails.add(bimage);
            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
        }
        return activitiesThumbnails;
    }

    protected void onPostExecute(List<Bitmap> result) {
        mListener.onBitmapCreated(result);
        //imageView.setImageBitmap(result);
    }
}
