package com.sma.data.entity.mapper;

import com.sma.data.entity.UserEntity;
import com.stdmar.domain.models.UserDomainModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sma on 06.09.17.
 */

public class UserEntityDataMapper {

    public UserDomainModel transform(UserEntity userEntity) {
        UserDomainModel user = null;
        if (userEntity != null) {
            user = new UserDomainModel(userEntity.getUserId());
            user.setCoverUrl(userEntity.getCoverUrl());
            user.setFullName(userEntity.getFullName());
            user.setDescription(userEntity.getDescription());
            user.setFollowers(userEntity.getFollowers());
            user.setEmail(userEntity.getEmail());
        }
        return user;
    }

    public List<UserDomainModel> transform(Collection<UserEntity> userEntityCollection) {
        final List<UserDomainModel> userList = new ArrayList<>();
        for (UserEntity userEntity : userEntityCollection) {
            final UserDomainModel user = transform(userEntity);
            if (user == null) continue;
            userList.add(user);
        }
        return userList;
    }
}
