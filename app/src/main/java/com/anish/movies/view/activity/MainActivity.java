package com.anish.movies.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.anish.movies.R;
import com.anish.movies.databinding.ActivityMainBinding;
import com.anish.movies.utils.FragmentUtils;
import com.anish.movies.view.base.BaseActivity;
import com.anish.movies.view.fragment.MovieListFragment;

import static com.anish.movies.utils.FragmentUtils.TRANSITION_NONE;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtils.replaceFragment(this, MovieListFragment.newInstance(), R.id.fragContainer, false, TRANSITION_NONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
