package com.stdmar.fcleanarchprj;

import com.stdmar.fcleanarchprj.di.app.ApplicationComponent;
import com.stdmar.fcleanarchprj.di.app.ApplicationModule;
import com.stdmar.fcleanarchprj.di.app.DaggerApplicationComponent;
import com.stdmar.fcleanarchprj.di.login.DaggerLoginComponent;
import com.stdmar.fcleanarchprj.di.login.LoginComponent;
import com.stdmar.fcleanarchprj.di.login.LoginModule;
import com.stdmar.fcleanarchprj.di.network.ApplicationApiModule;
import com.stdmar.fcleanarchprj.di.repository.RepositoryModule;
import com.stdmar.fcleanarchprj.di.schedulemainthread.ScheduleMainThreadModule;
import com.stdmar.fcleanarchprj.di.usecase.UsersUseCaseModule;

/**
 * Created by sma on 06.09.17.
 */

public class ComponentsHelper {

    private LoginComponent loginComponent;
    private ApplicationComponent applicationComponent;

    public void initApplicationComponent(MyApplication myApplication) {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent
                    .builder()
                    .applicationModule(new ApplicationModule(myApplication))
                    .applicationApiModule(new ApplicationApiModule())
                    .scheduleMainThreadModule(new ScheduleMainThreadModule())
                    .repositoryModule(new RepositoryModule())
                    .usersUseCaseModule(new UsersUseCaseModule())
                    .build();
        }
    }

    public void initLoginComponent() {
        if (loginComponent == null) {
            loginComponent = DaggerLoginComponent
                    .builder()
                    .applicationComponent(applicationComponent)
                    .loginModule(new LoginModule())
                    .build();
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }
}
