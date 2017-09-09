package com.stdmar.fcleanarchprj.di.app.modules;

import android.content.Context;

import com.stdmar.fcleanarchprj.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 06.09.17.
 */

@Module
public class ApplicationModule {

    private MyApplication myApplication;

    public ApplicationModule(MyApplication myApplication) {

        this.myApplication = myApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {

        return this.myApplication;
    }
}
