package com.example.nozomcontrol_2.mvpmovieapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.nozomcontrol_2.mvpmovieapp.R;
import com.example.nozomcontrol_2.mvpmovieapp.data.MovieInfo;
import com.example.nozomcontrol_2.mvpmovieapp.ui.presenters.MovieDetailsPresenter;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M.Dhemy on 08/10/2018.
 */

public class MovieDetailsFragment extends Fragment implements MovieDetailsPresenter.ViewUpdateCallback {
    @BindView(R.id.movie_details_fragment_collapsing_toolbar_imageview)
    ImageView collapsingToolbarImageView;
    @BindView(R.id.movie_details_description_textView)
    TextView movieDetailsFragmentDescriptionTextView;
    @BindView(R.id.movie_details_fragment_collapsing_toolbar)
    CollapsingToolbarLayout movieDetailsCollapsingToolbar;
    @BindView(R.id.movie_details_fragment_title_textView)
    TextView movieDetailsTitleTextView;
    @BindView(R.id.movie_details_fragment_rate_textView)
    TextView movieDetailsRateTextView;
    @BindView(R.id.movie_details_fragment_release_date_textView)
    TextView movieDetailsReleaseDateTextView;
    @BindView(R.id.movie_details_fragment_imageview)
    ImageView movieDetailsPosterImageView;
    @BindView(R.id.movie_details_fragment_toolbar)
    Toolbar movieDetailsToolbar;

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
    }

    @Override
    public void updateMovieDetailsView(MovieInfo movieInfo) {
        Picasso.get().load(movieInfo.getBackdropPath()).into(collapsingToolbarImageView);
        Picasso.get().load(movieInfo.getPosterPath()).into(movieDetailsPosterImageView);
        movieDetailsCollapsingToolbar.setTitle(movieInfo.getTitle());
        movieDetailsCollapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.transparent));
        movieDetailsFragmentDescriptionTextView.setText(movieInfo.getOverview());
        movieDetailsTitleTextView.setText(movieInfo.getTitle());
        movieDetailsRateTextView.setText(movieInfo.getVoteAverage());
        movieDetailsReleaseDateTextView.setText(movieInfo.getReleaseDate());
        movieDetailsToolbar.setNavigationIcon(R.drawable.ic_outline_arrow_back_24px);
        movieDetailsToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }
}
