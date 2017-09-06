package com.stdmar.domain;

import com.stdmar.domain.models.UserDomainModel;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 05.09.17.
 */

public interface IRepository {

    Flowable<List<UserDomainModel>> getUsers();

}
