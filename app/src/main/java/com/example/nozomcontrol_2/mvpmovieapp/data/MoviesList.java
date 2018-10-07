package com.example.nozomcontrol_2.mvpmovieapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 25/03/2018.
 */

public class MoviesList {
    @SerializedName("results")
    @Expose
    private List<MovieInfo> moviesList = new ArrayList<>();

    public List<MovieInfo> getMovieList(){
        return moviesList;
    }

    public void  setMoviesList(List<MovieInfo> moviesList){
        this.moviesList = moviesList;
    }
}
