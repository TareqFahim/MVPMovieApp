package com.example.nozomcontrol_2.mvpmovieapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Dhemy on 15/10/2018.
 */

public class MovieTrailerList {
    @SerializedName("results")
    @Expose
    private List<MovieTrailer> movieTrailers = new ArrayList<>();

    public List<MovieTrailer> getMovieTrailers(){
        return movieTrailers;
    }

    public void setMovieTrailers(List<MovieTrailer> movieTrailers){
        this.movieTrailers = movieTrailers;
    }
}
