package com.stdmar.fcleanarchprj.login;

import android.content.SharedPreferences;

import com.arellomobile.mvp.InjectViewState;
import com.stdmar.domain.interactors.login.LoginUseCase;
import com.stdmar.domain.models.LoginDomainModel;
import com.stdmar.fcleanarchprj.CustomDisposableSubscriber;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.base.BasePresenter;
import com.stdmar.fcleanarchprj.utils.image.IImageLoader;

import javax.inject.Inject;

/**
 * Created by sma on 07.09.17.
 */

@InjectViewState
public class LoginPresenter extends BasePresenter<ILoginView> {

    @Inject
    LoginUseCase loginUseCase;
    @Inject
    IImageLoader imageLoader;
    @Inject
    SharedPreferences sharedPreferences;

    public void inject() {

        MyApplication.getComponentsHelper().getLoginComponent().injectToLoginPresenter(this);
    }

    public void runLoginUseCase() {
        if (loginUseCase == null) return;
        actionWithViewBeforeLogin();
        loginUseCase.execute(new LoginFlowable(), null);
    }

    private void actionWithViewBeforeLogin() {
        getViewState().disableViews();
        getViewState().showProgressBar();
    }

    private void loginSuccessState(final LoginDomainModel loginDomainModel) {

        getViewState().successLogin(loginDomainModel);
    }

    private void loginCompleteState() {

        getViewState().enableViews();
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
            getViewState().enableViews();
            loginErrorState(t.getMessage());
        }

        @Override
        public void onComplete() {

            loginCompleteState();
        }
    }

}
