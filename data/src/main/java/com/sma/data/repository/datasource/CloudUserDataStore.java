package com.sma.data.repository.datasource;

import com.sma.data.entity.UserEntity;
import com.sma.data.rest.IApplicationApi;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 06.09.17.
 */

public class CloudUserDataStore implements IUserDataStore {

    private IApplicationApi applicationApi;

    public CloudUserDataStore(IApplicationApi applicationApi) {

        this.applicationApi = applicationApi;
    }

    @Override
    public Flowable<List<UserEntity>> userEntityList() {

        return applicationApi.fetchUsers();
    }

    @Override
    public Flowable<UserEntity> userEntityDetails(int userId) {

        return null;
    }
}
