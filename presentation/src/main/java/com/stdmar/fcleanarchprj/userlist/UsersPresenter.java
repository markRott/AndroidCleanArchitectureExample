package com.stdmar.fcleanarchprj.userlist;

import com.arellomobile.mvp.InjectViewState;
import com.stdmar.domain.interactors.user.UsersUseCase;
import com.stdmar.domain.models.UserDomainModel;
import com.stdmar.fcleanarchprj.Const;
import com.stdmar.fcleanarchprj.CustomDisposableSubscriber;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 06.09.17.
 */

@InjectViewState
public class UsersPresenter extends BasePresenter<ILoadUsersView> {

    @Inject
    UsersUseCase usersUseCase;
    @Inject
    Router router;

    @Override
    public void setRouter(Router router) {

    }

    @Override
    public void inject() {

        MyApplication.COMPONENTS_HELPER.getUsersListComponent().injectInUsersPresenter(this);
    }

    public void fetchUsers() {
        if (usersUseCase == null) return;
        getViewState().showLoadLabel();
        usersUseCase.execute(new UsersObserver(), null);
    }

    public void onBackPressed() {
        router.exit();
    }

    public void onOpenDetailScreen(){
        router.navigateTo(Const.ScreenKey.DETAIL_USER_FRAGMENT_SCREEN);
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
    }

}
