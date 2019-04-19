package com.anish.movies.data.remote.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.anish.movies.data.local.dao.MovieDao;
import com.anish.movies.data.local.entity.MovieEntity;
import com.anish.movies.data.remote.ApiService;
import com.anish.movies.data.remote.NetworkBoundResource;
import com.anish.movies.data.remote.Resource;
import com.anish.movies.data.remote.model.PopularMovieResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class MovieRepository {

    private final MovieDao movieDao;
    private final ApiService apiService;

    @Inject
    MovieRepository(MovieDao dao, ApiService service) {
        this.movieDao = dao;
        this.apiService = service;
    }

    /**
     * This method fetches the popular movies from the service.
     * Once the fetching is done the data is cached to local db so that the app can even work offline
     * @param howfarback index indicating how far back
     * @return List of movies
     */
    public LiveData<Resource<List<MovieEntity>>> loadPopularMovies(int howfarback) {
        return new NetworkBoundResource<List<MovieEntity>, PopularMovieResponse>() {

            @Override
            protected void saveCallResult(PopularMovieResponse item) {
                if(null != item)
                    movieDao.saveMovies(item.getPopularMovies());
            }

            @NonNull
            @Override
            protected LiveData<List<MovieEntity>> loadFromDb() {
                return movieDao.loadPopularMovies();
            }

            @NonNull
            @Override
            protected Call<PopularMovieResponse> createCall() {
                return apiService.loadPopularMovies();
            }
        }.getAsLiveData();
    }


}
