package com.stdmar.fcleanarchprj.user.userlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.stdmar.domain.models.UserDomainModel;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sma on 09.09.17.
 */

public class UsersFragment extends BaseFragment implements ILoadUsersView, IBackButtonListener {

    @InjectPresenter
    UsersPresenter usersPresenter;

    @BindView(R.id.pb_load_users)
    ProgressBar pbLoadUsers;
    @BindView(R.id.rcv_users)
    RecyclerView rcvUsers;

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
        setupRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rcvUsers.setAdapter(null);
    }

    @Override
    public boolean onBackPressed() {
        usersPresenter.onBackPressed();
        return true;
    }

    @Override
    public void showProgressBar() {
        pbLoadUsers.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbLoadUsers.setVisibility(View.GONE);
    }

    @Override
    public void renderUsersList(List<UserDomainModel> userDomainModelList) {

    }

    @OnClick(R.id.btn_stub_detail)
    public void clickOnOpenDetail() {
        usersPresenter.onOpenDetailScreen();
    }

    private void setupRecyclerView() {
        rcvUsers.setLayoutManager(new LinearLayoutManager(getContext()));
//        this.rv_users.setAdapter(usersAdapter);
    }
}