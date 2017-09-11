package com.stdmar.fcleanarchprj.base;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;

/**
 * Created by sma on 09.09.17.
 */

public abstract class BaseFragment extends MvpAppCompatFragment {

//    protected abstract void inject();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        inject();
    }

    public MyApplicationComponent getMyApplicationComponent() {
        return ((MyApplication) getActivity().getApplication()).getMyApplicationComponent();
    }

}
