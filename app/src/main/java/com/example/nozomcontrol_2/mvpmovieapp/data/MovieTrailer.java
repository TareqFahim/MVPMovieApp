package com.example.nozomcontrol_2.mvpmovieapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by M.Dhemy on 15/10/2018.
 */

public class MovieTrailer implements Parcelable {
    @SerializedName("key")
    @Expose
    private String trailer_key;

    protected MovieTrailer(Parcel in) {
        trailer_key = in.readString();
    }

    public static final Creator<MovieTrailer> CREATOR = new Creator<MovieTrailer>() {
        @Override
        public MovieTrailer createFromParcel(Parcel in) {
            return new MovieTrailer(in);
        }

        @Override
        public MovieTrailer[] newArray(int size) {
            return new MovieTrailer[size];
        }
    };

    public void setTrailerKey(String trailer_key){
        this.trailer_key = trailer_key;
    }

    public String getTrailer_key(){
        return trailer_key;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(trailer_key);
    }
}
