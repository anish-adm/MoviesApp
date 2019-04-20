package com.anish.movies.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.anish.movies.R;
import com.anish.movies.common.Constants;

import com.anish.movies.databinding.FragmentMovieDetailsBinding;
import com.anish.movies.view.base.BaseFragment;
import com.anish.movies.viewmodel.MovieDetailsViewModel;
import com.squareup.picasso.Picasso;


public class MovieDetailFragment extends BaseFragment<MovieDetailsViewModel, FragmentMovieDetailsBinding> {
    @Override
    protected Class<MovieDetailsViewModel> getViewModel() {
        return MovieDetailsViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_movie_details;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if(null != args) {
            Picasso.get().load(args.getString(Constants.BUNDLE_KEY_MOVIE_POSTER_IMAGE_URL)).into(dataBinding.imgPoster);
            dataBinding.textTitle.setText(args.getString(Constants.BUNDLE_KEY_MOVIE_TITLE));
            dataBinding.textReleaseDate.setText(getString(R.string.released)+": "+args.getString(Constants.BUNDLE_KEY_MOVIE_RELEASED_DATE));
            dataBinding.textVote.setText(args.getString(Constants.BUNDLE_KEY_MOVIE_AVERAGE_VOTE)+"/10 ("+args.getString(Constants.BUNDLE_KEY_MOVIE_VOTE_COUNT)+")");
            dataBinding.textOverview.setText(args.getString(Constants.BUNDLE_KEY_MOVIE_OVERVIEW));
        }
    }
}
