package com.stdmar.fcleanarchprj.di.app;

import android.content.Context;

import com.sma.data.rest.IApplicationApi;
import com.stdmar.domain.IPostExecutionThread;
import com.stdmar.fcleanarchprj.di.network.ApplicationApiModule;
import com.stdmar.fcleanarchprj.di.schedulemainthread.ScheduleMainThreadModule;
import com.stdmar.fcleanarchprj.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sma on 07.09.17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ApplicationApiModule.class,
        ScheduleMainThreadModule.class
})
public interface MyApplicationComponent {

    void inject(LoginActivity loginActivity);

    Context context();

    IApplicationApi applicationApi();

    IPostExecutionThread uiThread();
}
