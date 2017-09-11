package com.stdmar.fcleanarchprj.di.users.detail.modules;

import com.stdmar.domain.interactors.user.DetailUserUseCase;
import com.stdmar.domain.interfaces.IDetailUserRepository;
import com.stdmar.domain.interfaces.IPostExecutionThread;
import com.stdmar.fcleanarchprj.di.users.detail.DetailUserScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 11.09.17.
 */

@Module
public class DetailUserUseCaseModule {

    @Provides
    @DetailUserScope
    public DetailUserUseCase provideDetailUserUseCase(
            IPostExecutionThread thread,
            IDetailUserRepository detailUserRepository) {

        return new DetailUserUseCase(thread, detailUserRepository);
    }

}
