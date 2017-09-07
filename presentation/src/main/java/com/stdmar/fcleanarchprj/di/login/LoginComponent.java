package com.stdmar.fcleanarchprj.di.login;

import com.sma.data.entity.mapper.LoginEntityDataMapper;
import com.stdmar.domain.ILoginRepository;
import com.stdmar.domain.interactors.login.LoginUseCase;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;
import com.stdmar.fcleanarchprj.login.LoginPresenter;

import dagger.Component;

/**
 * Created by sma on 07.09.17.
 */

@Component(dependencies = {MyApplicationComponent.class}, modules = {LoginModule.class})
@LoginScope
public interface LoginComponent {

    void injectToLoginPresenter(LoginPresenter loginPresenter);

    LoginEntityDataMapper mapper();

    ILoginRepository loginRepository();

    LoginUseCase loginUseCase();
}
