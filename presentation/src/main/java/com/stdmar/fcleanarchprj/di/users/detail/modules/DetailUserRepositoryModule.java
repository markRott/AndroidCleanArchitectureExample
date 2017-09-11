package com.stdmar.fcleanarchprj.di.users.detail.modules;

import com.sma.data.entity.mapper.UserEntityDataMapper;
import com.sma.data.repository.DetailUserRepositoryImpl;
import com.sma.data.rest.IApplicationApi;
import com.stdmar.domain.interfaces.IDetailUserRepository;
import com.stdmar.fcleanarchprj.di.customqualifier.DetailsQualifier;
import com.stdmar.fcleanarchprj.di.users.detail.DetailUserScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 11.09.17.
 */

@Module
public class DetailUserRepositoryModule {

    @Provides
    @DetailUserScope
    @DetailsQualifier
    public UserEntityDataMapper provideUserEntityDataMapper() {

        return new UserEntityDataMapper();
    }

    @Provides
    @DetailUserScope
    public IDetailUserRepository provideDetailUserRepository(
            IApplicationApi api,
            @DetailsQualifier
            UserEntityDataMapper mapper) {

        return new DetailUserRepositoryImpl(api, mapper);
    }

}
