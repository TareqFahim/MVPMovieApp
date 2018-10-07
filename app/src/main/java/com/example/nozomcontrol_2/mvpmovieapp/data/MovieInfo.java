package com.example.nozomcontrol_2.mvpmovieapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 25/03/2018.
 */

public class MovieInfo {
    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    @SerializedName("original_title")
    @Expose
    private String title;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @SerializedName("vote_average")
    @Expose
    private String voteAverage;

    @SerializedName("id")
    @Expose
    private String id;

    public String getPosterPath(){
        return posterPath;
    }
    public void setPosterPath(String posterPath){
        this.posterPath = posterPath;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getOverview(){
        return overview;
    }
    public void setOverview(String overview){
        this.overview = overview;
    }

    public String getReleaseDate(){
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public String getVoteAverage(){ return voteAverage;}
    public void setVoteAverage(String voteAverage) { this.voteAverage = voteAverage; }

    public String getId() { return id; }
    public void setId(String id){this.id = id;}
}
