package com.anish.movies.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.anish.movies.data.local.MovieDatabase;
import com.anish.movies.data.local.entity.MovieEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(AndroidJUnit4.class)
public class MovieDaosTest {

    private MovieDatabase movieDatabase;

    @Before
    public void init(){
        movieDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), MovieDatabase.class).build();
    }

    @After
    public void uninit(){
        movieDatabase.close();
    }
    @Test
    public void testLoadPopularMovies(){
        List<MovieEntity> movieEntities = new ArrayList<>();
        MovieEntity entity = new MovieEntity();
        entity.setId(1000);
        entity.setTitle("test");
        movieEntities.add(entity);
        movieDatabase.movieDao().saveMovies(movieEntities);
        LiveData<List<MovieEntity>> moviesList =  movieDatabase.movieDao().loadPopularMovies();
        assertNotNull(moviesList);
    }

}
