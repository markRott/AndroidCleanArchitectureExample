package com.stdmar.fcleanarchprj.user.detailuser;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.stdmar.domain.models.UserDomainModel;

/**
 * Created by sma on 10.09.17.
 */

public interface IDetailUserView extends MvpView {

    void showProgressBar();

    void hideProgressBar();

    void renderUser(UserDomainModel userDomainModel);

    @StateStrategyType(value = AddToEndSingleStrategy.class)
    void showError(String error);
}
