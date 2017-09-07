package com.stdmar.fcleanarchprj.login;

import com.arellomobile.mvp.MvpView;
import com.stdmar.domain.models.LoginDomainModel;

/**
 * Created by sma on 07.09.17.
 */

public interface ILoginView extends MvpView {

    void showProgressBar();

    void hideProgressBar();

    void disableViews();

    void enableViews();

    void successLogin(LoginDomainModel loginDomainModel);

    void showErrorMessage(String errorMsg);

}
