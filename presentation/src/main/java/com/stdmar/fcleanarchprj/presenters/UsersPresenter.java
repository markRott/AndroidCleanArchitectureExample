package com.stdmar.fcleanarchprj.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.stdmar.domain.interactors.user.UsersUseCase;
import com.stdmar.domain.models.UserDomainModel;
import com.stdmar.fcleanarchprj.CustomDisposableSubscriber;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.viewsinterface.ILoadUsers;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sma on 06.09.17.
 */

@InjectViewState
public class UsersPresenter extends MvpPresenter<ILoadUsers> {

    @Inject
    UsersUseCase usersUseCase;

    public UsersPresenter() {
        MyApplication.getComponentsHelper().getApplicationComponent().injectUsersPresenter(this);
    }

    public void fetchUsers() {
        if (usersUseCase == null) return;
        getViewState().showLoadLabel();
        usersUseCase.execute(new UsersObserver(), null);
    }

    private final class UsersObserver extends CustomDisposableSubscriber<List<UserDomainModel>> {

        @Override
        public void onNext(List<UserDomainModel> userDomainModelList) {

            System.out.println("userDomainModelList = " + userDomainModelList);
        }

        @Override
        public void onError(Throwable t) {

            System.out.println("Throwable = " + t);
            UsersPresenter.this.getViewState().hideLoadLabel();
        }

        @Override
        public void onComplete() {

            UsersPresenter.this.getViewState().hideLoadLabel();
        }
    }

}
