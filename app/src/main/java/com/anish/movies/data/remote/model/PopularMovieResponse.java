package com.anish.movies.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.anish.movies.data.local.entity.MovieEntity;

import java.util.List;

public class PopularMovieResponse {

    @SerializedName("results")
    private List<MovieEntity> popularMovies;


    /**
     * This method return the list of movie entities
     * @return List of entities
     */
    public List<MovieEntity> getPopularMovies() {
        return popularMovies;
    }

    /**
     * This method sets the movie entities
     * @param popularMovies - movieslist
     */
    @SuppressWarnings("unused")
    public void setPopularMovies(List<MovieEntity> popularMovies) {
        this.popularMovies = popularMovies;
    }
}
