package com.stdmar.fcleanarchprj.di.users.list.modules;

import com.stdmar.domain.interfaces.IPostExecutionThread;
import com.stdmar.domain.interfaces.IUserRepository;
import com.stdmar.domain.interactors.user.UsersUseCase;
import com.stdmar.fcleanarchprj.di.users.list.UsersListScope;

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
            IUserRepository repository) {

        return new UsersUseCase(thread, repository);
    }
}
