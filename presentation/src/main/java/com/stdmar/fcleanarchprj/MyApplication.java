package com.stdmar.fcleanarchprj;

import android.app.Application;

import com.stdmar.fcleanarchprj.di.ComponentsHelper;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;

/**
 * Created by sma on 06.09.17.
 */

public class MyApplication extends Application {

    private MyApplicationComponent myApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponentsHelper();
    }

    public MyApplicationComponent getMyApplicationComponent() {
        return myApplicationComponent;
    }

    private void initComponentsHelper() {
        myApplicationComponent = ComponentsHelper.initMyApplicationComponent(this);
    }
}
