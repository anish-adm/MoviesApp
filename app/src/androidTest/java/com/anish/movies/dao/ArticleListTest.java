package com.anish.movies.dao;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.anish.movies.R;
import com.anish.movies.view.activity.MainActivity;
import com.anish.movies.view.fragment.MovieListFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class MovieListTest {

    @Rule
    //Activity Test Rule for the activity which contains my login fragment
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init() {
        //Initail setup method to load my fragment in the activity before beginning to test
        mActivityRule.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, new MovieListFragment()).commit();
    }

    @Test
    public void OnRecyclerViewClick() throws InterruptedException {
        //Perform type action on the view with id as email
        Espresso.onView(withId(R.id.recyclerView)).perform(click());

    }

}