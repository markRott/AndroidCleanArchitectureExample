package com.stdmar.fcleanarchprj.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.stdmar.domain.models.LoginDomainModel;
import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.ll_login_data_container)
    LinearLayout llLoginDataContainer;
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

    }

    @OnClick(R.id.btn_login)
    public void clickOnLogin() {
        if (loginPresenter == null) return;
        final String login = getText(edtLogin);
        final String password = getText(edtPassword);
        loginPresenter.runLoginUseCase(login, password);
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

        llLoginDataContainer.setEnabled(false);
    }

    @Override
    public void enableViews() {

        llLoginDataContainer.setEnabled(true);
    }

    @Override
    public void successLogin(LoginDomainModel loginDomainModel) {

    }

    @Override
    public void showErrorMessage(String errorMsg) {

    }

    private String getText(final EditText edt) {

        return edt.getText().toString().trim();
    }
}
