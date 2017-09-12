package com.stdmar.fcleanarchprj.user.userlist;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.stdmar.domain.models.UserDomainModel;

import java.util.List;

/**
 * Created by sma on 06.09.17.
 */

public interface ILoadUsersView extends MvpView{

    void showProgressBar();

    void hideProgressBar();

    void renderUsersList(List<UserDomainModel> userDomainModelList);

    @StateStrategyType(value = AddToEndSingleStrategy.class)
    void showError(String error);
}
