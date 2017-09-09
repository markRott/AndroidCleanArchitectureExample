package com.stdmar.fcleanarchprj.di.app.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.sma.data.utils.INetworkUtils;
import com.sma.data.utils.NetworkUtilsImpl;
import com.stdmar.fcleanarchprj.utils.image.IImageLoader;
import com.stdmar.fcleanarchprj.utils.image.PicassoImageLoaderImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 09.09.17.
 */

@Module
public class UtilsModule {

    @Singleton
    @Provides
    public INetworkUtils provideNetworkUtils(Context context) {

        return new NetworkUtilsImpl(context);
    }

    @Singleton
    @Provides
    public IImageLoader providePicassoImageLoaders(Context context) {

        return new PicassoImageLoaderImpl(context);
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context context) {

        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
