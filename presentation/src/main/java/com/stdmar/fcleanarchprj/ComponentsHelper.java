package com.stdmar.fcleanarchprj;

import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.di.app.ApplicationComponent;
import com.stdmar.fcleanarchprj.di.app.ApplicationModule;
import com.stdmar.fcleanarchprj.di.app.DaggerApplicationComponent;
import com.stdmar.fcleanarchprj.di.network.ApplicationApiModule;
import com.stdmar.fcleanarchprj.di.repository.RepositoryModule;
import com.stdmar.fcleanarchprj.di.schedulemainthread.ScheduleMainThreadModule;
import com.stdmar.fcleanarchprj.di.usecase.UsersUseCaseModule;

/**
 * Created by sma on 06.09.17.
 */

public class ComponentsHelper {

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

    public ApplicationComponent getApplicationComponent() {

        return applicationComponent;
    }
}
