package com.example.nozomcontrol_2.mvpmovieapp.ui.presenters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import com.example.nozomcontrol_2.mvpmovieapp.BuildConfig;
import com.example.nozomcontrol_2.mvpmovieapp.R;
import com.example.nozomcontrol_2.mvpmovieapp.data.MovieInfo;
import com.example.nozomcontrol_2.mvpmovieapp.data.MoviesList;
import com.example.nozomcontrol_2.mvpmovieapp.data.retro.APIService;
import com.example.nozomcontrol_2.mvpmovieapp.data.retro.ApiClient;
import com.example.nozomcontrol_2.mvpmovieapp.ui.MainMovieGridFragment;
import com.example.nozomcontrol_2.mvpmovieapp.ui.MovieDetailActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainMovieGridPresenter  {
    private String API_KEY = BuildConfig.API_KEY;
    private List<MovieInfo> movieList;
    private ViewUpdateCallback mViewUpdateCallback;
    private List<String> postersURL;

    public MainMovieGridPresenter(ViewUpdateCallback viewUpdateCallback){
        this.mViewUpdateCallback = viewUpdateCallback;
        postersURL = new ArrayList();
    }

    public void viewMovieDetails(int gridItemIndex, Context context){
        Intent movieDetailsActivityIntent = new Intent(context, MovieDetailActivity.class);
        movieDetailsActivityIntent.putExtra(context.getString(R.string.MovieDetailsIntentExtra), movieList.get(gridItemIndex));
        context.startActivity(movieDetailsActivityIntent);
    }

    public void loadMoviesFromServer(){
        APIService apiService = ApiClient.getApiService();
        Call<MoviesList> call = apiService.getMoviesList("popular", API_KEY);
        call.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                movieList = response.body().getMovieList();
                fillPostersURLList();
                mViewUpdateCallback.updateMainGrid(postersURL);
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {

            }
        });
    }

    private void fillPostersURLList(){
        for (int i = 0; i < movieList.size(); i++) {
            postersURL.add("http://image.tmdb.org/t/p/w185" + movieList.get(i).getPosterPath() + "?api_key=" + API_KEY);
            movieList.get(i).setPosterPath("http://image.tmdb.org/t/p/w185" + movieList.get(i).getPosterPath() + "?api_key=" + API_KEY);
        }
    }

    public interface ViewUpdateCallback{
        void updateMainGrid(List<String> postersURL);
    }
}
