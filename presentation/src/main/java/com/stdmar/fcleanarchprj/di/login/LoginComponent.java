package com.stdmar.fcleanarchprj.di.login;

import com.sma.data.entity.mapper.LoginEntityDataMapper;
import com.stdmar.domain.interactors.login.LoginUseCase;
import com.stdmar.domain.interfaces.ILoginRepository;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;

import dagger.Component;
import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 07.09.17.
 */

@Component(dependencies = {MyApplicationComponent.class}, modules = {LoginModule.class})
@LoginScope
public interface LoginComponent {

//    void injectToLoginActivity(LoginActivity loginActivity);

    LoginEntityDataMapper mapper();

    ILoginRepository loginRepository();

    LoginUseCase loginUseCase();

    Router router();
}
