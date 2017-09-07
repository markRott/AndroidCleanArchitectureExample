package com.sma.data.rest;

import com.sma.data.entity.LoginEntity;
import com.sma.data.entity.UserEntity;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by sma on 05.09.17.
 */

public interface IApplicationApi {

    String baseUrl = "https://raw.githubusercontent.com/android10/" +
            "Sample-Data/master/Android-CleanArchitecture/";

    @GET(baseUrl + "users.json")
    Flowable<List<UserEntity>> fetchUsers();

    @GET("http://www.mocky.io/v2/59b12fe32600009305287ef9")
    Flowable<LoginEntity> login(final String login, final String password);
}
