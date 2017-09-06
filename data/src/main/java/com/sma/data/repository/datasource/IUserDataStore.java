package com.sma.data.repository.datasource;

import com.sma.data.entity.UserEntity;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 06.09.17.
 */

public interface IUserDataStore {

    Flowable<List<UserEntity>> userEntityList();

    Flowable<UserEntity> userEntityDetails(final int userId);
}
