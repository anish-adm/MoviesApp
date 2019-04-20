package com.anish.movies.data.remote;


/**
 * Keep all the service related constants here.
 */
public class ApiConstants {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String RESOURCE_BASE_URL = "https://image.tmdb.org/t/p/w500";
    public static final long CONNECT_TIMEOUT = 30000;
    public static final long READ_TIMEOUT = 30000;
    public static final long WRITE_TIMEOUT = 30000;
    public static final String API_KEY = "55f5debf49256b09323951d922046b29";

    private ApiConstants(){
        // Private constructor to hide the implicit one
    }

}
