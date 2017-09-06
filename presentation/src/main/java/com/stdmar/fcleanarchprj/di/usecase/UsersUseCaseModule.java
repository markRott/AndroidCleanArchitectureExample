package com.stdmar.fcleanarchprj.di.usecase;

import com.stdmar.domain.IRepository;
import com.stdmar.domain.IPostExecutionThread;
import com.stdmar.domain.interactors.UsersUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 06.09.17.
 */

@Module
public class UsersUseCaseModule {

    public UsersUseCaseModule() {
    }

    @Provides
    @Singleton
    public UsersUseCase provideUsersUseCase(
            IPostExecutionThread thread,
            IRepository repository) {

        return new UsersUseCase(thread, repository);
    }

}
