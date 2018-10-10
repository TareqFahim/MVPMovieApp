package com.example.nozomcontrol_2.mvpmovieapp.ui;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.nozomcontrol_2.mvpmovieapp.R;
import com.example.nozomcontrol_2.mvpmovieapp.data.MovieInfo;
import com.example.nozomcontrol_2.mvpmovieapp.ui.presenters.MovieDetailsPresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M.Dhemy on 08/10/2018.
 */

public class MovieDetailsFragment extends Fragment implements MovieDetailsPresenter.ViewUpdateCallback {
    @BindView(R.id.movie_details_fragment_imageview)
    ImageView imageView;
//    @BindView(R.id.toolbar)
//    Toolbar toolbar;

    MovieDetailsPresenter movieDetailsPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.movie_details_fragment, container);
        ButterKnife.bind(this, rootview);
        movieDetailsPresenter = new MovieDetailsPresenter(getActivity(), this);
        return rootview;
    }

    @Override
    public void onStart() {
        super.onStart();
        Intent intent = getActivity().getIntent();
        movieDetailsPresenter.getMovieDetailsInfo(intent);
//        toolbar.setTitle("Venom");
    }

    @Override
    public void updateMovieDetailsView(MovieInfo movieInfo) {
        Picasso.get().load(movieInfo.getPosterPath()).into(imageView);
        getActivity().setTitle(movieInfo.getTitle());
    }
}
