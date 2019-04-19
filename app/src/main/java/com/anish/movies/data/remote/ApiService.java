package com.anish.movies.data.remote;

import com.anish.movies.data.remote.model.PopularMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * The APIService interface which will contain the semantics of all the REST calls.
 */
public interface ApiService {

    @GET("discover/movie?sort_by=popularity.desc")
    Call<PopularMovieResponse> loadPopularMovies();
}
