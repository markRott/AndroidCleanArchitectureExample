package com.stdmar.fcleanarchprj.userlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sma on 09.09.17.
 */

public class UsersFragment extends BaseFragment implements IBackButtonListener, ILoadUsersView {

    @InjectPresenter
    UsersPresenter usersPresenter;

    public static UsersFragment newInstance() {
        return new UsersFragment();
    }

    @Override
    protected void inject() {
        MyApplication.COMPONENTS_HELPER.initUsersListComponent();
        usersPresenter.inject();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.frg_users, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public boolean onBackPressed() {
        usersPresenter.onBackPressed();
        return true;
    }

    @Override
    public void showLoadLabel() {

    }

    @Override
    public void hideLoadLabel() {

    }

    @OnClick(R.id.btn_stub_detail)
    public void clickOnOpenDetail(){
        usersPresenter.onOpenDetailScreen();
    }
}
