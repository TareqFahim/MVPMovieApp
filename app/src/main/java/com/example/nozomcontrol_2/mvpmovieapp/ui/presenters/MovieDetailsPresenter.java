package com.example.nozomcontrol_2.mvpmovieapp.ui.presenters;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.nozomcontrol_2.mvpmovieapp.R;
import com.example.nozomcontrol_2.mvpmovieapp.data.MovieInfo;
import com.squareup.picasso.Picasso;

/**
 * Created by M.Dhemy on 09/10/2018.
 */

public class MovieDetailsPresenter {
    private Context mContext;
    private ViewUpdateCallback mViewUpdateCallback;

    public MovieDetailsPresenter(Context context, ViewUpdateCallback viewUpdateCallback) {
        this.mContext = context;
        this.mViewUpdateCallback = viewUpdateCallback;
    }

    public void getMovieDetailsInfo(Intent intent){
        if(intent.hasExtra(mContext.getString(R.string.MovieDetailsIntentExtra))){
            MovieInfo movieInfo = intent.getParcelableExtra(mContext.getString(R.string.MovieDetailsIntentExtra));
            mViewUpdateCallback.updateMovieDetailsView(movieInfo);
        }
    }

    public void setMenuTitle(){

    }

    public interface ViewUpdateCallback {
        void updateMovieDetailsView(MovieInfo movieInfo);
    }
}
