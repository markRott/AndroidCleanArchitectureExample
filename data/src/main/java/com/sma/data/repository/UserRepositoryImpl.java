package com.sma.data.repository;

import com.sma.data.entity.UserEntity;
import com.sma.data.entity.mapper.UserEntityDataMapper;
import com.sma.data.repository.datasource.IUserDataStore;
import com.sma.data.repository.datasource.UserDataStoreFactory;
import com.stdmar.domain.IRepository;
import com.stdmar.domain.models.LoginDomainModel;
import com.stdmar.domain.models.UserDomainModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by sma on 05.09.17.
 */

public class UserRepositoryImpl implements IRepository {

    private UserDataStoreFactory userDataStoreFactory;
    private UserEntityDataMapper userEntityDataMapper;

    public UserRepositoryImpl(UserDataStoreFactory factory, UserEntityDataMapper mapper) {
        userDataStoreFactory = factory;
        userEntityDataMapper = mapper;
    }

    @Override
    public Flowable<LoginDomainModel> login(String login, String password) {
        return null;
    }

    @Override
    public Flowable<List<UserDomainModel>> getUsers() {
        final IUserDataStore userDataStore = userDataStoreFactory.createCloudDataStore();
        return userDataStore.userEntityList().map(new MapOperator());
    }

    private class MapOperator implements Function<List<UserEntity>, List<UserDomainModel>> {

        @Override
        public List<UserDomainModel> apply(@NonNull List<UserEntity> userEntities) throws Exception {

            return userEntityDataMapper.transform(userEntities);
        }
    }

}
