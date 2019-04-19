package com.anish.movies.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;


import com.anish.movies.data.local.entity.MovieEntity;
import com.anish.movies.data.remote.Resource;
import com.anish.movies.data.remote.repository.MovieRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Movie List view model
 */
public class MovieListViewModel extends ViewModel {
    private final LiveData<Resource<List<MovieEntity>>> popularMovies;

    @Inject
    public MovieListViewModel(MovieRepository movieRepository) {
        popularMovies = movieRepository.loadPopularMovies(7);
    }

    public LiveData<Resource<List<MovieEntity>>> getPopularMovies() {
        return popularMovies;
    }
}
