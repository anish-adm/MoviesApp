package com.anish.movies.di.components;

import android.app.Application;

import com.anish.movies.MoviesApp;
import com.anish.movies.di.builder.ActivityBuilderModule;
import com.anish.movies.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * The main application component which initializes all the dependent modules
 */
@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MoviesApp moviesApp);
}