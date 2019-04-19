package com.anish.movies.di.builder;

import com.anish.movies.view.fragment.MovieDetailFragment;
import com.anish.movies.view.fragment.MovieListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * This builder provides android injector service to fragments
 */
@Module
public abstract class FragmentBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract MovieListFragment contributeMovieListFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract MovieDetailFragment contributeMovieDetailFragment();

}
