package com.stdmar.fcleanarchprj.login;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.stdmar.domain.interactors.login.LoginUseCase;
import com.stdmar.domain.models.LoginDomainModel;
import com.stdmar.fcleanarchprj.CustomDisposableSubscriber;

/**
 * Created by sma on 07.09.17.
 */

@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginView> {

    private LoginUseCase loginUseCase;

    public void runLoginUseCase(final String login, final String password) {
        if (loginUseCase == null) return;
        actionWithViewBeforeLogin();
        loginUseCase.execute(new LoginFlowable(),
                LoginUseCase.Params.initParams(login, password));
    }

    private void actionWithViewBeforeLogin() {
        getViewState().disableViews();
        getViewState().showProgressBar();
    }

    private void loginSuccessState(final LoginDomainModel loginDomainModel) {

        getViewState().successLogin(loginDomainModel);
    }

    private void loginCompleteState() {

        getViewState().hideProgressBar();
    }

    private void loginErrorState(String errorMsg) {
        getViewState().showErrorMessage(errorMsg);
        getViewState().enableViews();
        getViewState().hideProgressBar();
    }

    private class LoginFlowable extends CustomDisposableSubscriber<LoginDomainModel> {

        @Override
        public void onNext(LoginDomainModel loginDomainModel) {
            loginSuccessState(loginDomainModel);
            System.out.println("loginDomainModel = " + loginDomainModel);
        }

        @Override
        public void onError(Throwable t) {
            loginErrorState(t.getMessage());
        }

        @Override
        public void onComplete() {
            loginCompleteState();
        }
    }

}
