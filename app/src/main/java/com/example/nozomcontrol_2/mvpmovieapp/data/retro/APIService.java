package com.example.nozomcontrol_2.mvpmovieapp.data.retro;

import com.example.nozomcontrol_2.mvpmovieapp.data.MovieTrailerList;
import com.example.nozomcontrol_2.mvpmovieapp.data.MoviesList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 25/03/2018.
 */

public interface APIService {
    @GET("{sortType}")
    Call<MoviesList> getMoviesList(@Path("sortType") String sortType, @Query("api_key") String apiKey);

    @GET("{movieID}/videos")
    Call<MovieTrailerList> getMovieTrailers(@Path("movieID") String movieID, @Query("api_key") String apiKey);
}
