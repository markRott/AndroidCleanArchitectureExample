package com.sma.data.repository;

import com.sma.data.entity.LoginEntity;
import com.sma.data.entity.mapper.LoginEntityDataMapper;
import com.sma.data.rest.IApplicationApi;
import com.stdmar.domain.interfaces.ILoginRepository;
import com.stdmar.domain.models.LoginDomainModel;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by sma on 07.09.17.
 */

public class LoginRepositoryImpl implements ILoginRepository {

    private IApplicationApi applicationApi;
    private LoginEntityDataMapper dataMapper;

    public LoginRepositoryImpl(IApplicationApi applicationApi, LoginEntityDataMapper dataMapper) {
        this.applicationApi = applicationApi;
        this.dataMapper = dataMapper;
    }

    @Override
    public Flowable<LoginDomainModel> login() {

        return applicationApi.login().map(new MapOperator());
    }

    private class MapOperator implements Function<LoginEntity, LoginDomainModel>{

        @Override
        public LoginDomainModel apply(@NonNull LoginEntity loginEntity) throws Exception {

            return dataMapper.transform(loginEntity);
        }
    }

}
