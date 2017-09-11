package com.stdmar.domain.interfaces;

import com.stdmar.domain.models.UserDomainModel;

import io.reactivex.Flowable;

/**
 * Created by sma on 11.09.17.
 */

public interface IDetailUserRepository {

    Flowable<UserDomainModel> getUserById(final int userId);

}
