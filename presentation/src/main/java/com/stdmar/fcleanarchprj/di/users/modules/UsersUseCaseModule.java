package com.stdmar.fcleanarchprj.di.users.modules;

import com.stdmar.domain.IPostExecutionThread;
import com.stdmar.domain.IRepository;
import com.stdmar.domain.interactors.user.UsersUseCase;
import com.stdmar.fcleanarchprj.di.users.UsersListScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 06.09.17.
 */

@Module
public class UsersUseCaseModule {

    @Provides
    @UsersListScope
    public UsersUseCase provideUsersUseCase(
            IPostExecutionThread thread,
            IRepository repository) {

        return new UsersUseCase(thread, repository);
    }
}
