package com.stdmar.fcleanarchprj.di.login;

import com.stdmar.fcleanarchprj.di.app.ApplicationComponent;
import com.stdmar.fcleanarchprj.login.LoginPresenter;

import dagger.Component;

/**
 * Created by sma on 07.09.17.
 */

@LoginScope
@Component(
        dependencies = {ApplicationComponent.class},
        modules = {LoginModule.class}
)
public interface LoginComponent {

    void inject(LoginPresenter loginPresenter);

}
