package com.example.nozomcontrol_2.mvpmovieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nozomcontrol_2.mvpmovieapp.R;
import com.example.nozomcontrol_2.mvpmovieapp.data.MovieInfo;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent = getIntent();
        MovieInfo movieInfo = intent.getParcelableExtra(getString(R.string.MovieDetailsIntentExtra));
//        if(intent.hasExtra(getString(R.string.MovieDetailsIntentExtra))){
//            String itemIndex = intent.getStringExtra(getString(R.string.MovieDetailsIntentExtra));
//            Toast.makeText(this, itemIndex, Toast.LENGTH_SHORT).show();
//        }else
//            Toast.makeText(this, "Wrbna Fady", Toast.LENGTH_SHORT).show();
    }
}
