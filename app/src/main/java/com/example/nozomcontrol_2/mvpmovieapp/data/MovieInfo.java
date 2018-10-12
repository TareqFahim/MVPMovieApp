package com.example.nozomcontrol_2.mvpmovieapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 25/03/2018.
 */

public class MovieInfo implements Parcelable {
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

    @SerializedName("backdrop_path")
    private String backdropPath;

    protected MovieInfo(Parcel in) {
        posterPath = in.readString();
        title = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        voteAverage = in.readString();
        id = in.readString();
        backdropPath = in.readString();
    }

    public static final Creator<MovieInfo> CREATOR = new Creator<MovieInfo>() {
        @Override
        public MovieInfo createFromParcel(Parcel in) {
            return new MovieInfo(in);
        }

        @Override
        public MovieInfo[] newArray(int size) {
            return new MovieInfo[size];
        }
    };

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

    public String getBackdropPath() { return backdropPath; }
    public void setBackdropPath(String backdropPath){this.backdropPath = backdropPath;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(posterPath);
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(releaseDate);
        dest.writeString(voteAverage);
        dest.writeString(id);
        dest.writeString(backdropPath);
    }
}
