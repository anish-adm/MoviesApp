package com.anish.movies.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.anish.movies.data.local.dao.MovieDao;
import com.anish.movies.data.local.entity.MovieEntity;

@Database(entities = {MovieEntity.class}, version = 2)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
}