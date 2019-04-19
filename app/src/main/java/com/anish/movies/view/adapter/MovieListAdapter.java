package com.anish.movies.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.anish.movies.data.local.entity.MovieEntity;
import com.anish.movies.databinding.ItemMovieListBinding;
import com.anish.movies.view.base.BaseAdapter;
import com.anish.movies.view.callbacks.MovieListCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Movie list recyclerview adapter
 */
public class MovieListAdapter extends  BaseAdapter<MovieListAdapter.MovieViewHolder, MovieEntity>
implements Filterable{

    private List<MovieEntity> movieEntities;

    private List<MovieEntity> movieEntitiesFiltered;

    private final MovieListCallback movieListCallback;

    public MovieListAdapter(@NonNull MovieListCallback movieListCallback) {
        movieEntities = new ArrayList<>();
        movieEntitiesFiltered = new ArrayList<>();
        this.movieListCallback = movieListCallback;
    }

    @Override
    public void setData(List<MovieEntity> entities) {
        this.movieEntities = entities;
        this.movieEntitiesFiltered = entities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return MovieViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, movieListCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder viewHolder, int i) {
        viewHolder.onBind(movieEntitiesFiltered.get(i));
    }

    @Override
    public int getItemCount() {
        return movieEntitiesFiltered.size();
    }

    @Override
    public Filter getFilter() {
         return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    movieEntitiesFiltered = movieEntities;
                } else {
                    List<MovieEntity> filteredList = new ArrayList<>();
                    for (MovieEntity row : movieEntities) {

                        // name match condition. this might differ depending on your requirement
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    movieEntitiesFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = movieEntitiesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                movieEntitiesFiltered = (ArrayList<MovieEntity>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        private static MovieViewHolder create(LayoutInflater inflater, ViewGroup parent, MovieListCallback callback) {
            ItemMovieListBinding itemMovieListBinding = ItemMovieListBinding.inflate(inflater, parent, false);
            return new MovieViewHolder(itemMovieListBinding, callback);
        }

        final ItemMovieListBinding binding;

        private MovieViewHolder(ItemMovieListBinding binding, MovieListCallback callback) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(v ->
                    callback.onMovieClicked(binding.getMovie()));
        }

        private void onBind(MovieEntity movieEntity) {
            binding.setMovie(movieEntity);
            binding.executePendingBindings();
        }
    }
}
