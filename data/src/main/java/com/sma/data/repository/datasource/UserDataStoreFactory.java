package com.sma.data.repository.datasource;

import com.sma.data.rest.IApplicationApi;

/**
 * Created by sma on 06.09.17.
 */

public class UserDataStoreFactory  {

    private IApplicationApi applicationApi;

    public UserDataStoreFactory(IApplicationApi applicationApi) {

        this.applicationApi = applicationApi;
    }

    public IUserDataStore createCloudDataStore() {

        return new CloudUserDataStore(applicationApi);
    }

    public IUserDataStore createDiscDataStore() {

        return new DiscUserDataStore();
    }
}
