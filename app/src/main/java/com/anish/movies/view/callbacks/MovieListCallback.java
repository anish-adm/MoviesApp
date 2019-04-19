package com.anish.movies.view.callbacks;

import com.anish.movies.data.local.entity.MovieEntity;

public interface MovieListCallback {
    void onMovieClicked(MovieEntity movieEntity);
}

