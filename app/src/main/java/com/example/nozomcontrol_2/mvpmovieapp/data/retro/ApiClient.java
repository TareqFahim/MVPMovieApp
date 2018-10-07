package com.example.nozomcontrol_2.mvpmovieapp.data.retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 25/03/2018.
 */

public class ApiClient {
    public static final String BASE_URL = "http://api.themoviedb.org/3/movie/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }

    public static APIService getApiService() {
        return getRetrofit().create(APIService.class);
    }
}
