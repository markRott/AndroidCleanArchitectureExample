package com.sma.data.entity.mapper;

import com.sma.data.entity.LoginEntity;
import com.stdmar.domain.models.LoginDomainModel;

/**
 * Created by sma on 07.09.17.
 */

public class LoginEntityDataMapper {

    public LoginDomainModel transform(LoginEntity entity) {
        LoginDomainModel loginDomainModel = null;
        if (entity != null) {
            loginDomainModel = new LoginDomainModel();
            loginDomainModel.setToken(entity.getToken());
            loginDomainModel.setFirstName(entity.getFirstName());
            loginDomainModel.setLastName(entity.getLastName());
            loginDomainModel.setEmail(entity.getEmail());
            loginDomainModel.setAvatarUrl(entity.getAvatarUrl());
            loginDomainModel.setPhoneNumber(entity.getPhoneNumber());
        }
        return loginDomainModel;
    }
}
