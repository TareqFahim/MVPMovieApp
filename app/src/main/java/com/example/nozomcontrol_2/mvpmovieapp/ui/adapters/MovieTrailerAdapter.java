package com.example.nozomcontrol_2.mvpmovieapp.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nozomcontrol_2.mvpmovieapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M.Dhemy on 16/10/2018.
 */

public class MovieTrailerAdapter extends RecyclerView.Adapter<MovieTrailerAdapter.MovieTrailerViewHolder> {
    private Context context;
    private List<String> mMovieTrailersThumbnail;
    private MovieTrailersGridClickListner mMovieTrailersGridClickListner;

    public MovieTrailerAdapter(Context context, List<String> movieTrailerThumbnail, MovieTrailersGridClickListner mMovieTrailersGridClickListner) {
        this.context = context;
        this.mMovieTrailersThumbnail = movieTrailerThumbnail;
        this.mMovieTrailersGridClickListner = mMovieTrailersGridClickListner;
    }

    @NonNull
    @Override
    public MovieTrailerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int listItemLayoutID = R.layout.movie_details_trailer_grid_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachImedialtelytoParent = false;

        View view = inflater.inflate(listItemLayoutID, viewGroup, shouldAttachImedialtelytoParent);
        MovieTrailerViewHolder viewHolder = new MovieTrailerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieTrailerViewHolder movieTrailerViewHolder, int i) {
        Picasso.get().load(mMovieTrailersThumbnail.get(i)).into(movieTrailerViewHolder.movieTrailerImageview);
    }

    @Override
    public int getItemCount() {
        return mMovieTrailersThumbnail.size();
    }

    public class MovieTrailerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.movie_details_trailer_imageview)
        ImageView movieTrailerImageview;

        public MovieTrailerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedItemPosition = getAdapterPosition();
            mMovieTrailersGridClickListner.onTrailerGridItemClick(clickedItemPosition);
        }
    }

    public interface MovieTrailersGridClickListner{
        public void onTrailerGridItemClick(int itemIndex);
    }
}
