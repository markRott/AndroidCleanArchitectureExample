package com.stdmar.fcleanarchprj.di.users.list.modules;

import com.sma.data.entity.mapper.UserEntityDataMapper;
import com.sma.data.repository.UserRepositoryImpl;
import com.sma.data.repository.datasource.UserDataStoreFactory;
import com.sma.data.rest.IApplicationApi;
import com.stdmar.domain.interfaces.IUserRepository;
import com.stdmar.fcleanarchprj.di.customqualifier.UsersListQualifier;
import com.stdmar.fcleanarchprj.di.users.list.UsersListScope;

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
    @UsersListQualifier
    public UserEntityDataMapper provideUserEntityDataMapper() {

        return new UserEntityDataMapper();
    }

    @Provides
    @UsersListScope
    public IUserRepository provideRepository(
            UserDataStoreFactory factory,
            @UsersListQualifier
                    UserEntityDataMapper mapper
    ) {

        return new UserRepositoryImpl(factory, mapper);
    }

}
