package com.sma.data.repository;

import com.sma.data.entity.UserEntity;
import com.sma.data.entity.mapper.UserEntityDataMapper;
import com.sma.data.rest.IApplicationApi;
import com.stdmar.domain.interfaces.IDetailUserRepository;
import com.stdmar.domain.models.UserDomainModel;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by sma on 11.09.17.
 */

public class DetailUserRepositoryImpl implements IDetailUserRepository {

    private IApplicationApi api;
    private UserEntityDataMapper userEntityDataMapper;

    public DetailUserRepositoryImpl(
            IApplicationApi api,
            UserEntityDataMapper userEntityDataMapper) {

        this.api = api;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override
    public Flowable<UserDomainModel> getUserById(int userId) {
        return api.fetchUserById(userId).map(new MapOperator());
    }

    private class MapOperator implements Function<UserEntity, UserDomainModel> {

        @Override
        public UserDomainModel apply(@NonNull UserEntity userEntity) throws Exception {
            return userEntityDataMapper.transform(userEntity);
        }
    }
}
