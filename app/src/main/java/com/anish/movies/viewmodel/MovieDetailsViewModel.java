package com.anish.movies.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.anish.movies.data.local.entity.MovieEntity;
import com.anish.movies.data.remote.repository.MovieRepository;
import com.anish.movies.utils.SingleLiveEvent;

import javax.inject.Inject;

/**
 * THIS CLASS IS NOT USED
 * MovieDetails view model
 */

public class MovieDetailsViewModel extends ViewModel {

    private String url;

    private MovieRepository movieRepository;

    private MutableLiveData<MovieEntity> movieEntityMutableLiveData = new MutableLiveData<>();

    private SingleLiveEvent<Void> errorMessageRecieved = new SingleLiveEvent<>();

    public SingleLiveEvent<Void> getErrorMessageRecieved() {
        return errorMessageRecieved;
    }


    @Inject
    MovieDetailsViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


}
