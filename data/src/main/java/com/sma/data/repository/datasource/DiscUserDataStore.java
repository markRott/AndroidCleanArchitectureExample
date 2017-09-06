package com.sma.data.repository.datasource;

import com.sma.data.entity.UserEntity;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 06.09.17.
 */

public class DiscUserDataStore implements IUserDataStore {

    @Override
    public Flowable<List<UserEntity>> userEntityList() {

        return null;
    }

    @Override
    public Flowable<UserEntity> userEntityDetails(int userId) {

        return null;
    }
}
