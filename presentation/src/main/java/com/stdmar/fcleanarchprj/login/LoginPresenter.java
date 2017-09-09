package com.stdmar.fcleanarchprj.login;

import com.arellomobile.mvp.InjectViewState;
import com.stdmar.domain.interactors.login.LoginUseCase;
import com.stdmar.domain.models.LoginDomainModel;
import com.stdmar.fcleanarchprj.Const;
import com.stdmar.fcleanarchprj.CustomDisposableSubscriber;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.base.BasePresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 07.09.17.
 */

@InjectViewState
public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginNavigationCommands {

    @Inject
    LoginUseCase loginUseCase;

    private Router router;

    @Override
    public void setRouter(Router router) {
        this.router = router;
    }

    @Override
    public void onBackPressed() {
        router.exit();
    }

    @Override
    public void openMainScreen() {
        router.navigateTo(Const.ScreenKey.MAIN_ACTIVITY_SCREEN);
    }

    public void inject() {

        MyApplication.COMPONENTS_HELPER.getLoginComponent().injectToLoginPresenter(this);
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

    private void loginErrorState(String errorMsg) {
        getViewState().showErrorMessage(errorMsg);
        getViewState().enableViews();
        getViewState().hideProgressBar();
    }

    private class LoginFlowable extends CustomDisposableSubscriber<LoginDomainModel> {

        @Override
        public void onNext(LoginDomainModel loginDomainModel) {
            loginSuccessState(loginDomainModel);
            openMainScreen();
            System.out.println("loginDomainModel = " + loginDomainModel);
        }

        @Override
        public void onError(Throwable t) {
            getViewState().enableViews();
            loginErrorState(t.getMessage());
        }
    }

}
