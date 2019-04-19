package com.anish.movies.view.callbacks;

import com.anish.movies.data.local.entity.MovieEntity;

public interface ResponseListener {

    void onSuccess(MovieEntity data);
    void onFailure(String message);
}
