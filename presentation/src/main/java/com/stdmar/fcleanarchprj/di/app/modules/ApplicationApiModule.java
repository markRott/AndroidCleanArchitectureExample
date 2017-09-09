package com.stdmar.fcleanarchprj.di.app.modules;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sma.data.rest.IApplicationApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sma on 06.09.17.
 */

@Module
public class ApplicationApiModule {

    @Singleton
    @Provides
    public IApplicationApi provideApplicationApi() {
        final Retrofit retrofit = initRetrofit();
        return retrofit.create(IApplicationApi.class);
    }

    private Retrofit initRetrofit() {
        final Retrofit.Builder retrofitBuilder =
                new Retrofit.Builder()
                        .baseUrl("https://github.com")
                        .addConverterFactory(initConverterFactory())
                        .addCallAdapterFactory(initCallAdapterFactory())
                        .client(initOkHttpClient());

        return retrofitBuilder.build();
    }

    private Converter.Factory initConverterFactory() {

        return GsonConverterFactory.create();
    }

    private CallAdapter.Factory initCallAdapterFactory() {

        return RxJava2CallAdapterFactory.create();
    }

    private OkHttpClient initOkHttpClient() {

        return new OkHttpClient();
    }
}
