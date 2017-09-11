package com.stdmar.fcleanarchprj;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
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

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public MyApplicationComponent getMyApplicationComponent() {
        return myApplicationComponent;
    }

    private void initComponentsHelper() {
        myApplicationComponent = ComponentsHelper.initMyApplicationComponent(this);
    }
}
