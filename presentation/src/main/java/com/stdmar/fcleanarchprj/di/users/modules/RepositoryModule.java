package com.stdmar.fcleanarchprj.di.users.modules;

import com.sma.data.entity.mapper.UserEntityDataMapper;
import com.sma.data.repository.UserRepositoryImpl;
import com.sma.data.repository.datasource.UserDataStoreFactory;
import com.sma.data.rest.IApplicationApi;
import com.stdmar.domain.IRepository;
import com.stdmar.fcleanarchprj.di.users.UsersListScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 06.09.17.
 */

@Module
public class RepositoryModule {

    @Provides
    @UsersListScope
    public UserDataStoreFactory provideUserDataStoreFactory(IApplicationApi applicationApi) {

        return new UserDataStoreFactory(applicationApi);
    }

    @Provides
    @UsersListScope
    public UserEntityDataMapper provideUserEntityDataMapper() {

        return new UserEntityDataMapper();
    }

    @Provides
    @UsersListScope
    public IRepository provideRepository(
            UserDataStoreFactory factory,
            UserEntityDataMapper mapper) {

        return new UserRepositoryImpl(factory, mapper);
    }

}
