package com.stdmar.fcleanarchprj.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseActivity;
import com.stdmar.fcleanarchprj.presenters.UsersPresenter;
import com.stdmar.fcleanarchprj.viewsinterface.ILoadUsers;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements ILoadUsers {

    @BindView(R.id.tv_load_label)
    TextView tvLoadLabel;

    @InjectPresenter
    UsersPresenter usersPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void inject() {

        MyApplication.getComponentsHelper().getApplicationComponent().inject(this);
    }

    @OnClick(R.id.btn_load_users)
    public void clickOnLoadUsers(View view) {

        if (usersPresenter == null) return;
        usersPresenter.fetchUsers();
    }

    @Override
    public void showLoadLabel() {

        tvLoadLabel.setText(R.string.msg_loading);
    }

    @Override
    public void hideLoadLabel() {

        tvLoadLabel.setText(R.string.msg_success);
    }
}
