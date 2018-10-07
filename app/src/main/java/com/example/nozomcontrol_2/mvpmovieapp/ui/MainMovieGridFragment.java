package com.example.nozomcontrol_2.mvpmovieapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nozomcontrol_2.mvpmovieapp.R;
import com.example.nozomcontrol_2.mvpmovieapp.ui.adapters.MainMovieGridAdapter;
import com.example.nozomcontrol_2.mvpmovieapp.ui.presenters.MainMovieGridPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainMovieGridFragment extends Fragment implements MainMovieGridAdapter.GridItemClickListner, MainMovieGridPresenter.ViewUpdateCallback {

    private MainMovieGridAdapter mMainMovieGridAdapter;
    private MainMovieGridPresenter mMainMovieGridPresenter;

    @BindView(R.id.main_movie_grid_rv)
    RecyclerView mainMovieGridRV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_movie_grid_fragment,container, false);
        ButterKnife.bind(this, rootView);
        LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mainMovieGridRV.setLayoutManager(layoutManager);
        mainMovieGridRV.setHasFixedSize(true);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mMainMovieGridPresenter = new MainMovieGridPresenter(this);
        mMainMovieGridPresenter.loadMoviesFromServer();
    }

    @Override
    public void onGridItemClick(int itemIndex) {
        mMainMovieGridPresenter.viewMovieDetails(itemIndex, getActivity());
    }

    @Override
    public void updateMainGrid(List<String> postersURL) {
        mMainMovieGridAdapter = new MainMovieGridAdapter(getActivity(), postersURL, this);
        mainMovieGridRV.setAdapter(mMainMovieGridAdapter);
    }
}
