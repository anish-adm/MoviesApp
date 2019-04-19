package com.anish.movies.view.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anish.movies.R;
import com.anish.movies.common.Constants;
import com.anish.movies.data.local.entity.MovieEntity;
import com.anish.movies.data.remote.ApiConstants;
import com.anish.movies.data.remote.Status;
import com.anish.movies.databinding.FragmentListMoviesBinding;
import com.anish.movies.utils.FragmentUtils;
import com.anish.movies.view.adapter.MovieListAdapter;
import com.anish.movies.view.base.BaseFragment;
import com.anish.movies.view.callbacks.MovieListCallback;
import com.anish.movies.viewmodel.MovieListViewModel;


/**
 * The movie list fragment which will list the popular movies
 */
public class MovieListFragment extends BaseFragment<MovieListViewModel, FragmentListMoviesBinding> implements MovieListCallback {

    public static MovieListFragment newInstance() {
        Bundle args = new Bundle();
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Class<MovieListViewModel> getViewModel() {
        return MovieListViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_list_movies;
    }

    @Override
    public void onMovieClicked(MovieEntity movieEntity) {
        if(null != getActivity()){
            Bundle args = new Bundle();
            args.putString(Constants.BUNDLE_KEY_MOVIE_TITLE, movieEntity.getTitle());
            args.putString(Constants.BUNDLE_KEY_MOVIE_POSTER_IMAGE_URL, ApiConstants.RESOURCE_BASE_URL+movieEntity.getPosterPath());
            args.putString(Constants.BUNDLE_KEY_MOVIE_AVERAGE_VOTE, String.valueOf(movieEntity.getVoteAverage()));
            args.putString(Constants.BUNDLE_KEY_MOVIE_VOTE_COUNT, String.valueOf(movieEntity.getVoteCount()));
            args.putString(Constants.BUNDLE_KEY_MOVIE_OVERVIEW, movieEntity.getOverview());
            args.putString(Constants.BUNDLE_KEY_MOVIE_RELEASED_DATE, movieEntity.getReleaseDate());

            MovieDetailFragment detailFragment = new MovieDetailFragment();
            detailFragment.setArguments(args);
            FragmentUtils.replaceFragment((AppCompatActivity) getActivity(), detailFragment, R.id.fragContainer, true, FragmentUtils.TRANSITION_SLIDE_LEFT_RIGHT);
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);
        dataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBinding.recyclerView.setAdapter(new MovieListAdapter(this));
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        viewModel.getPopularMovies()
                .observe(this, listResource -> {
                    if(null != listResource && (listResource.status == Status.ERROR || listResource.status == Status.SUCCESS)){
                        dataBinding.loginProgress.setVisibility(View.GONE);
                    }
                    dataBinding.setResource(listResource);

                    // If the cached data is already showing then no need to show the error
                    if(null != dataBinding.recyclerView.getAdapter() && dataBinding.recyclerView.getAdapter().getItemCount() > 0){
                        dataBinding.errorText.setVisibility(View.GONE);
                    }
                });

    }

}
