package com.stdmar.fcleanarchprj.di.app;

import android.content.Context;
import android.content.SharedPreferences;

import com.sma.data.rest.IApplicationApi;
import com.sma.data.utils.INetworkUtils;
import com.stdmar.domain.IPostExecutionThread;
import com.stdmar.fcleanarchprj.di.app.modules.ApplicationApiModule;
import com.stdmar.fcleanarchprj.di.app.modules.ApplicationModule;
import com.stdmar.fcleanarchprj.di.app.modules.NavigationModule;
import com.stdmar.fcleanarchprj.di.app.modules.ScheduleMainThreadModule;
import com.stdmar.fcleanarchprj.di.app.modules.UtilsModule;
import com.stdmar.fcleanarchprj.login.LoginActivity;
import com.stdmar.fcleanarchprj.utils.image.IImageLoader;

import javax.inject.Singleton;

import dagger.Component;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 07.09.17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ApplicationApiModule.class,
        ScheduleMainThreadModule.class,
        UtilsModule.class,
        NavigationModule.class
})
public interface MyApplicationComponent {

    void inject(LoginActivity loginActivity);

    Context context();

    IApplicationApi applicationApi();

    IPostExecutionThread uiThread();

    INetworkUtils networkUtils();

    IImageLoader imageLoader();

    SharedPreferences sharedPreferences();

    Router router();

    NavigatorHolder navigatorHolder();
}
