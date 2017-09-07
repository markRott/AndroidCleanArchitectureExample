package com.stdmar.fcleanarchprj.di.login;

import com.sma.data.entity.mapper.LoginEntityDataMapper;
import com.sma.data.repository.LoginRepositoryImpl;
import com.sma.data.rest.IApplicationApi;
import com.stdmar.domain.ILoginRepository;
import com.stdmar.domain.IPostExecutionThread;
import com.stdmar.domain.interactors.login.LoginUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 07.09.17.
 */

@Module
public class LoginModule {

    @Provides
    @LoginScope
    public LoginEntityDataMapper provideLoginEntityDataMapper() {

        return new LoginEntityDataMapper();
    }

    @Provides
    @LoginScope
    public ILoginRepository provideLoginRepository(IApplicationApi api, LoginEntityDataMapper mapper) {
        ILoginRepository loginRepository = new LoginRepositoryImpl(api, mapper);
        return loginRepository;
    }

    @Provides
    @LoginScope
    public LoginUseCase provideLoginUseCase(IPostExecutionThread thread, ILoginRepository repo) {
        final LoginUseCase useCase = new LoginUseCase(thread, repo);
        return useCase;
    }

}
