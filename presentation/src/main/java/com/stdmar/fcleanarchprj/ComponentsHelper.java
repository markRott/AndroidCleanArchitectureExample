package com.stdmar.fcleanarchprj;

import com.stdmar.fcleanarchprj.di.app.ApplicationModule;
import com.stdmar.fcleanarchprj.di.app.DaggerMyApplicationComponent;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;
import com.stdmar.fcleanarchprj.di.login.DaggerLoginComponent;
import com.stdmar.fcleanarchprj.di.login.LoginComponent;
import com.stdmar.fcleanarchprj.di.login.LoginModule;

/**
 * Created by sma on 06.09.17.
 */

public class ComponentsHelper {

    private LoginComponent loginComponent;
    private MyApplicationComponent myApplicationComponent;

    public void initMyApplicationComponent(MyApplication myApplication) {
        if (myApplicationComponent == null) {
            final ApplicationModule module = new ApplicationModule(myApplication);
            myApplicationComponent = DaggerMyApplicationComponent
                    .builder()
                    .applicationModule(module)
                    .build();
        }
    }

    public void initLoginComponent() {
        if (loginComponent == null) {
            loginComponent = DaggerLoginComponent
                    .builder()
                    .myApplicationComponent(myApplicationComponent)
                    .loginModule(new LoginModule())
                    .build();
        }
    }

    public LoginComponent getLoginComponent() {

        return loginComponent;
    }

    public MyApplicationComponent getMyApplicationComponent() {
        return myApplicationComponent;
    }
}
