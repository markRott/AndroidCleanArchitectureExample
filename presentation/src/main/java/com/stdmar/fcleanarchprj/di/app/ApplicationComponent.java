package com.stdmar.fcleanarchprj.di.app;

import android.content.Context;

import com.sma.data.rest.IApplicationApi;
import com.stdmar.fcleanarchprj.MainActivity;
import com.stdmar.fcleanarchprj.di.network.ApplicationApiModule;
import com.stdmar.fcleanarchprj.di.repository.RepositoryModule;
import com.stdmar.fcleanarchprj.di.schedulemainthread.ScheduleMainThreadModule;
import com.stdmar.fcleanarchprj.di.usecase.UsersUseCaseModule;
import com.stdmar.fcleanarchprj.presenters.UsersPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sma on 06.09.17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ApplicationApiModule.class,
        ScheduleMainThreadModule.class,
        UsersUseCaseModule.class,
        RepositoryModule.class

})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void injectUsersPresenter(UsersPresenter usersPresenter);

    Context context();

    IApplicationApi applicationApi();

}
