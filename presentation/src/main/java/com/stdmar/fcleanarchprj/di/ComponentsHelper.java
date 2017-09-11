package com.stdmar.fcleanarchprj.di;

import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.di.app.DaggerMyApplicationComponent;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;
import com.stdmar.fcleanarchprj.di.app.modules.ApplicationModule;
import com.stdmar.fcleanarchprj.di.app.modules.NavigationModule;
import com.stdmar.fcleanarchprj.di.app.modules.UtilsModule;
import com.stdmar.fcleanarchprj.di.login.DaggerLoginComponent;
import com.stdmar.fcleanarchprj.di.login.LoginComponent;
import com.stdmar.fcleanarchprj.di.login.LoginModule;
import com.stdmar.fcleanarchprj.di.users.detail.DaggerDetailUserComponent;
import com.stdmar.fcleanarchprj.di.users.detail.DetailUserComponent;
import com.stdmar.fcleanarchprj.di.users.detail.modules.DetailUserRepositoryModule;
import com.stdmar.fcleanarchprj.di.users.detail.modules.DetailUserUseCaseModule;
import com.stdmar.fcleanarchprj.di.users.list.DaggerUsersListComponent;
import com.stdmar.fcleanarchprj.di.users.list.UsersListComponent;
import com.stdmar.fcleanarchprj.di.users.list.modules.RepositoryModule;
import com.stdmar.fcleanarchprj.di.users.list.modules.UsersUseCaseModule;

/**
 * Created by sma on 06.09.17.
 */

public final class ComponentsHelper {

    private ComponentsHelper() {
    }

    public static MyApplicationComponent initMyApplicationComponent(MyApplication myApplication) {
        MyApplicationComponent component = null;
        component = DaggerMyApplicationComponent
                .builder()
                .applicationModule(getApplicationModule(myApplication))
                .utilsModule(getUtilsModule())
                .navigationModule(new NavigationModule())
                .build();

        return component;
    }

    public static LoginComponent initAndGetLoginComponent(MyApplicationComponent component) {
        LoginComponent loginComponent = null;
        loginComponent = DaggerLoginComponent
                .builder()
                .myApplicationComponent(component)
                .loginModule(new LoginModule())
                .build();
        return loginComponent;
    }

    public static UsersListComponent initAndGetUsersListComponent(MyApplicationComponent component) {
        UsersListComponent usersListComponent = null;
        usersListComponent = DaggerUsersListComponent
                .builder()
                .myApplicationComponent(component)
                .usersUseCaseModule(new UsersUseCaseModule())
                .repositoryModule(new RepositoryModule())
                .build();

        return usersListComponent;
    }

    public static DetailUserComponent initAndGetDetailUserComponent(MyApplicationComponent component) {
        DetailUserComponent detailUserComponent = null;
        detailUserComponent = DaggerDetailUserComponent
                .builder()
                .myApplicationComponent(component)
                .detailUserUseCaseModule(new DetailUserUseCaseModule())
                .detailUserRepositoryModule(new DetailUserRepositoryModule())
                .build();

        return detailUserComponent;
    }

    private static UtilsModule getUtilsModule() {
        return new UtilsModule();
    }

    private static ApplicationModule getApplicationModule(MyApplication myApplication) {
        return new ApplicationModule(myApplication);
    }
}
