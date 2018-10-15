package com.example.nozomcontrol_2.mvpmovieapp.ui.presenters;

import android.content.Context;
import android.content.Intent;

import com.example.nozomcontrol_2.mvpmovieapp.BuildConfig;
import com.example.nozomcontrol_2.mvpmovieapp.R;
import com.example.nozomcontrol_2.mvpmovieapp.data.MovieInfo;
import com.example.nozomcontrol_2.mvpmovieapp.data.MovieTrailer;
import com.example.nozomcontrol_2.mvpmovieapp.data.MovieTrailerList;
import com.example.nozomcontrol_2.mvpmovieapp.data.retro.APIService;
import com.example.nozomcontrol_2.mvpmovieapp.data.retro.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by M.Dhemy on 09/10/2018.
 */

public class MovieDetailsPresenter {
    private Context mContext;
    private ViewUpdateCallback mViewUpdateCallback;
    private String API_KEY = BuildConfig.API_KEY;
    private List<MovieTrailer> movieTrailers;
    private String TRAILERS_BASE_URL;
    private List<String> movieTrailersUrlList;

    public MovieDetailsPresenter(Context context, ViewUpdateCallback viewUpdateCallback) {
        this.mContext = context;
        this.mViewUpdateCallback = viewUpdateCallback;
        this.TRAILERS_BASE_URL = context.getResources().getString(R.string.TrailersYoutubeBaseURL);
    }

    public void getMovieDetailsInfo(Intent intent){
        if(intent.hasExtra(mContext.getString(R.string.MovieDetailsIntentExtra))){
            MovieInfo movieInfo = intent.getParcelableExtra(mContext.getString(R.string.MovieDetailsIntentExtra));
            mViewUpdateCallback.updateMovieDetailsView(movieInfo);
            loadMoviesTrailersFromServer(movieInfo.getId());
        }
    }

    public void loadMoviesTrailersFromServer(String movieID){
        APIService apiService = ApiClient.getApiService();
        Call<MovieTrailerList> call = apiService.getMovieTrailers(movieID, API_KEY);
        call.enqueue(new Callback<MovieTrailerList>() {
            @Override
            public void onResponse(Call<MovieTrailerList> call, Response<MovieTrailerList> response) {
                movieTrailers = response.body().getMovieTrailers();
                fillTrailersUrlList();
            }

            @Override
            public void onFailure(Call<MovieTrailerList> call, Throwable t) {

            }
        });
    }

    private void fillTrailersUrlList(){
        movieTrailersUrlList = new ArrayList<>();
        for (int i = 0; i < movieTrailers.size(); i++) {
            movieTrailersUrlList.add(TRAILERS_BASE_URL + movieTrailers.get(i).getTrailer_key());
        }
    }

    public void setMenuTitle(){

    }

    public interface ViewUpdateCallback {
        void updateMovieDetailsView(MovieInfo movieInfo);
    }
}
