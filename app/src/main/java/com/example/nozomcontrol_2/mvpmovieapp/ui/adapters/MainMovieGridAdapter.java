package com.example.nozomcontrol_2.mvpmovieapp.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nozomcontrol_2.mvpmovieapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainMovieGridAdapter extends RecyclerView.Adapter<MainMovieGridAdapter.MoviePosterViewHolder> {
    private Context context;
    private List<String> postersURL;
    private GridItemClickListner mGridItemClickListner;

    public MainMovieGridAdapter(Context c, List<String> postersURL, GridItemClickListner gridItemClickListner) {
        this.context = c;
        this.postersURL = postersURL;
        this.mGridItemClickListner = gridItemClickListner;
    }


    @NonNull
    @Override
    public MoviePosterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int listItemLayoutID = R.layout.main_movie_grid_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachImedialtelytoParent = false;

        View view = inflater.inflate(listItemLayoutID, viewGroup, shouldAttachImedialtelytoParent);
        MoviePosterViewHolder viewHolder = new MoviePosterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviePosterViewHolder moviePosterViewHolder, int i) {
        Picasso.get().load(postersURL.get(i)).into(moviePosterViewHolder.movieGridItemPoster);
    }


    @Override
    public int getItemCount() {
        return postersURL.size();
    }

    public class MoviePosterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.main_movie_grid_imageview)
        ImageView movieGridItemPoster;

        public MoviePosterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedItemPosition = getAdapterPosition();
            mGridItemClickListner.onGridItemClick(clickedItemPosition);
        }
    }

    public interface GridItemClickListner {
        void onGridItemClick(int itemIndex);
    }
}
