package com.stdmar.fcleanarchprj.user.detailuser;

import com.arellomobile.mvp.InjectViewState;
import com.stdmar.domain.interactors.user.DetailUserUseCase;
import com.stdmar.domain.models.UserDomainModel;
import com.stdmar.fcleanarchprj.CustomDisposableSubscriber;
import com.stdmar.fcleanarchprj.base.BasePresenter;

/**
 * Created by sma on 10.09.17.
 */

@InjectViewState
public class DetailUserPresenter extends BasePresenter<IDetailUserView> {

    private DetailUserUseCase detailUserUseCase;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void fetchUserById(final int userId) {
        getViewState().showProgressBar();
        DetailUserUseCase.Params params = DetailUserUseCase.Params.buildParams(userId);
        detailUserUseCase.execute(new DetailUserFlowable(), params);
    }

    public void setDetailUserUseCase(DetailUserUseCase detailUserUseCase){
        this.detailUserUseCase = detailUserUseCase;
    }

    private class DetailUserFlowable extends CustomDisposableSubscriber<UserDomainModel> {
        @Override
        public void onNext(UserDomainModel o) {
            getViewState().hideProgressBar();
            getViewState().renderUser(o);
        }

        @Override
        public void onError(Throwable t) {
            getViewState().hideProgressBar();
        }
    }
}
