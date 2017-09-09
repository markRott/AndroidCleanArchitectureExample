package com.stdmar.fcleanarchprj.base;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 08.09.17.
 */

public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View>{

    public abstract void setRouter(Router router);

    public abstract void inject();

}
