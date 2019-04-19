package com.anish.movies.entity;

import com.anish.movies.data.local.entity.MovieEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class EntityUnitTest {

    @Test
    public void testId(){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(1000);
        assertEquals(movieEntity.getId(), 1000);
    }

    @Test
    public void testTitle(){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle("test");
        assertEquals(movieEntity.getTitle(), "test");
    }

    @Test
    public void testContent(){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setContent("test");
        assertEquals(movieEntity.getContent(), "test");
    }

    @Test
    public void testPublishDate(){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setPublishedDate("test");
        assertEquals(movieEntity.getPublishedDate(), "test");
    }

    @Test
    public void testAuthors(){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setAuthors("test");
        assertEquals(movieEntity.getAuthors(), "test");
    }
}
