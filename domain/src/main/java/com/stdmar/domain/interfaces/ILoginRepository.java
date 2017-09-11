package com.stdmar.domain.interfaces;

import com.stdmar.domain.models.LoginDomainModel;

import io.reactivex.Flowable;

/**
 * Created by sma on 07.09.17.
 */

public interface ILoginRepository {

    Flowable<LoginDomainModel> login();
}
