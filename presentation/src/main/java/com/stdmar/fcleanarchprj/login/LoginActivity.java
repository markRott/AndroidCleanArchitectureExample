package com.stdmar.fcleanarchprj.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.stdmar.domain.models.LoginDomainModel;
import com.stdmar.fcleanarchprj.Const;
import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseActivity;
import com.stdmar.fcleanarchprj.di.ComponentsHelper;
import com.stdmar.fcleanarchprj.di.IHasComponent;
import com.stdmar.fcleanarchprj.di.login.LoginComponent;
import com.stdmar.fcleanarchprj.ui.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

public class LoginActivity extends BaseActivity implements ILoginView, IHasComponent<LoginComponent> {

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

    private LoginComponent loginComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initializeInjector();
        setLoginPresenterData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        loginPresenter.onBackPressed();
    }

    @OnClick(R.id.btn_login)
    public void clickOnLogin() {
        if (loginPresenter == null) return;
        loginPresenter.runLoginRequest();
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
        enableOrDisableView(true, edtLogin, edtPassword, btnLogin);
        pbLogin.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
        System.out.println("errorMsg = " + errorMsg);
    }

    @Override
    public LoginComponent getComponent() {

        return loginComponent;
    }

    private void initializeInjector() {
        loginComponent = ComponentsHelper.initAndGetLoginComponent(getMyApplicationComponent());
        getMyApplicationComponent().inject(this);
    }

    private void setLoginPresenterData() {
        loginPresenter
                .setLoginUseCase(loginComponent.loginUseCase())
                .setRouter(loginComponent.router());
    }

    private void enableOrDisableView(boolean state, View... views) {
        for (int i = 0; i < views.length; i++) {
            views[i].setEnabled(state);
        }
    }

    private Navigator navigator = new Navigator() {
        @Override
        public void applyCommand(Command command) {
            if (command instanceof Forward) {
                forward((Forward) command);
            } else if (command instanceof Back) {
                back();
            } else {
                Log.e("Cicerone", "Illegal command for this screen: "
                        + command.getClass().getSimpleName());
            }
        }
    };

    private void back() {

        finish();
    }

    private void forward(Forward command) {
        switch (command.getScreenKey()) {
            case Const.ScreenKey.MAIN_ACTIVITY_SCREEN:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case Const.ScreenKey.SIGNUP_ACTIVITY_SCREEN:
//                startActivity(new Intent(this, MainActivity.class));
                break;
            default:
                Log.e("Cicerone", "Unknown screen: " + command.getScreenKey());
                break;
        }
    }
}
