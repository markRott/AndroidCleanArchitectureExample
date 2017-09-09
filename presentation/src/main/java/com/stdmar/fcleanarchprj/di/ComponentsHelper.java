package com.stdmar.fcleanarchprj.di;

import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.di.app.modules.ApplicationModule;
import com.stdmar.fcleanarchprj.di.app.DaggerMyApplicationComponent;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;
import com.stdmar.fcleanarchprj.di.app.modules.NavigationModule;
import com.stdmar.fcleanarchprj.di.login.DaggerLoginComponent;
import com.stdmar.fcleanarchprj.di.login.LoginComponent;
import com.stdmar.fcleanarchprj.di.login.LoginModule;
import com.stdmar.fcleanarchprj.di.app.modules.UtilsModule;
import com.stdmar.fcleanarchprj.di.users.DaggerUsersListComponent;
import com.stdmar.fcleanarchprj.di.users.UsersListComponent;
import com.stdmar.fcleanarchprj.di.users.modules.RepositoryModule;
import com.stdmar.fcleanarchprj.di.users.modules.UsersUseCaseModule;

/**
 * Created by sma on 06.09.17.
 */

public class ComponentsHelper {

    private LoginComponent loginComponent;
    private UsersListComponent usersListComponent;
    private MyApplicationComponent myApplicationComponent;

    public void initMyApplicationComponent(MyApplication myApplication) {
        if (myApplicationComponent == null) {
            myApplicationComponent = DaggerMyApplicationComponent
                    .builder()
                    .applicationModule(getApplicationModule(myApplication))
                    .utilsModule(getUtilsModule())
                    .navigationModule(new NavigationModule())
                    .build();
        }
    }

    public void initLoginComponent() {
        if (loginComponent == null) {
            loginComponent = DaggerLoginComponent
                    .builder()
                    .myApplicationComponent(myApplicationComponent)
                    .loginModule(new LoginModule())
                    .build();
        }
    }

    public void initUsersListComponent() {
        if (usersListComponent == null) {
            usersListComponent = DaggerUsersListComponent
                    .builder()
                    .myApplicationComponent(myApplicationComponent)
                    .usersUseCaseModule(new UsersUseCaseModule())
                    .repositoryModule(new RepositoryModule())
                    .build();
        }
    }

    public MyApplicationComponent getMyApplicationComponent() {
        return myApplicationComponent;
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

    public UsersListComponent getUsersListComponent() {
        return usersListComponent;
    }

    private UtilsModule getUtilsModule() {
        return new UtilsModule();
    }

    private ApplicationModule getApplicationModule(MyApplication myApplication) {
        return new ApplicationModule(myApplication);
    }
}
