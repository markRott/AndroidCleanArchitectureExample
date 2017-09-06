package com.stdmar.fcleanarchprj.di.repository;

import com.sma.data.entity.mapper.UserEntityDataMapper;
import com.sma.data.repository.datasource.UserDataStoreFactory;
import com.sma.data.rest.IApplicationApi;
import com.sma.data.repository.UserRepositoryImpl;
import com.stdmar.domain.IRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 06.09.17.
 */

@Module
public class RepositoryModule {

    public RepositoryModule() {
    }

    @Singleton
    @Provides
    public IRepository provideRepository(
            IApplicationApi applicationApi,
            UserDataStoreFactory factory,
            UserEntityDataMapper mapper) {

        return new UserRepositoryImpl(factory, mapper);
    }

    @Singleton
    @Provides
    public UserDataStoreFactory provideUserDataStoreFactory(IApplicationApi applicationApi) {

        return new UserDataStoreFactory(applicationApi);
    }

    @Singleton
    @Provides
    public UserEntityDataMapper provideUserEntityDataMapper() {

        return new UserEntityDataMapper();
    }

}
