package com.stdmar.fcleanarchprj.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.stdmar.domain.models.LoginDomainModel;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

    //    @BindView(R.id.ll_login_data_container)
//    LinearLayout llLoginDataContainer;
    @BindView(R.id.edt_login)
    EditText edtLogin;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.pb_login)
    ProgressBar pbLogin;

    @InjectPresenter
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void inject() {

        MyApplication.getComponentsHelper().initLoginComponent();
        loginPresenter.inject();
    }

    @OnClick(R.id.btn_login)
    public void clickOnLogin() {
        if (loginPresenter == null) return;
//        final String login = getText(edtLogin);
//        final String password = getText(edtPassword);
        loginPresenter.runLoginUseCase(/*login, password*/);
    }

    @Override
    public void showProgressBar() {

        pbLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {

        pbLogin.setVisibility(View.GONE);
    }

    @Override
    public void disableViews() {

        enableOrDisableView(false, edtLogin, edtPassword, btnLogin);
    }

    @Override
    public void enableViews() {

        enableOrDisableView(true, edtLogin, edtPassword, btnLogin);
    }

    @Override
    public void successLogin(LoginDomainModel loginDomainModel) {

    }

    @Override
    public void showErrorMessage(String errorMsg) {

        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    private void enableOrDisableView(boolean state, View... views) {
        for (int i = 0; i < views.length; i++) {
            views[i].setEnabled(state);
        }
    }

    private String getText(final EditText edt) {

        return edt.getText().toString().trim();
    }
}
