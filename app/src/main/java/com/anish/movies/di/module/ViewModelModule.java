package com.anish.movies.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.anish.movies.viewmodel.MovieDetailsViewModel;
import com.anish.movies.viewmodel.MovieListViewModel;
import com.anish.movies.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Alloes us to inject dependencies via constructor injection
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsMovieListViewModel(MovieListViewModel movieListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsMovieDetailsiewModel(MovieDetailsViewModel movieDetailsViewModel);


    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
