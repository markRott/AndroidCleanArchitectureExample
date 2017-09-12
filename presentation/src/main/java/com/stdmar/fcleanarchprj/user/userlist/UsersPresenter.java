package com.stdmar.fcleanarchprj.user.userlist;

import com.arellomobile.mvp.InjectViewState;
import com.stdmar.domain.interactors.user.UsersUseCase;
import com.stdmar.domain.models.UserDomainModel;
import com.stdmar.fcleanarchprj.Const;
import com.stdmar.fcleanarchprj.CustomDisposableSubscriber;
import com.stdmar.fcleanarchprj.base.BasePresenter;

import java.util.List;

import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 06.09.17.
 */

@InjectViewState
public class UsersPresenter extends BasePresenter<ILoadUsersView> {

    Router router;
    UsersUseCase usersUseCase;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        fetchUsers();
    }

    @Override
    public void attachView(ILoadUsersView view) {
        super.attachView(view);
    }

    @Override
    public void detachView(ILoadUsersView view) {
        super.detachView(view);
    }

    @Override
    public void destroyView(ILoadUsersView view) {
        super.destroyView(view);
    }

    public void fetchUsers() {
        if (usersUseCase == null) return;
        getViewState().showProgressBar();
        usersUseCase.execute(new UsersObserver(), null);
    }

    public void onBackPressed() {
        router.exit();
    }

    public void onOpenDetailScreen(final int userId) {

        router.navigateTo(Const.ScreenKey.DETAIL_USER_FRAGMENT_SCREEN, userId);
    }

    public UsersPresenter setRouter(Router localRouter) {
        this.router = localRouter;
        return this;
    }

    public UsersPresenter setUsersUseCase(UsersUseCase localUsersUseCase) {
        this.usersUseCase = localUsersUseCase;
        return this;
    }

    private final class UsersObserver extends CustomDisposableSubscriber<List<UserDomainModel>> {
        @Override
        public void onNext(List<UserDomainModel> userDomainModelList) {
            getViewState().hideProgressBar();
            getViewState().renderUsersList(userDomainModelList);
        }

        @Override
        public void onError(Throwable t) {
            getViewState().hideProgressBar();
            getViewState().showError(t.getMessage());
        }
    }

}
