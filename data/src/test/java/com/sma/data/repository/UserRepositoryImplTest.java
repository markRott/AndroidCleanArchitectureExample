package com.sma.data.repository;

import com.sma.data.entity.UserEntity;
import com.sma.data.entity.mapper.UserEntityDataMapper;
import com.sma.data.repository.datasource.IUserDataStore;
import com.sma.data.repository.datasource.UserDataStoreFactory;
import com.sma.data.rest.IApplicationApi;
import com.stdmar.domain.models.UserDomainModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by sma on 12.09.17.
 */
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class UserRepositoryImplTest {

    @Mock
    IApplicationApi testApplicationApi;
    @Mock
    UserDataStoreFactory testUserDataStoreFactory;
    @Mock
    UserEntityDataMapper testUserEntityDataMapper;
    @Mock
    IUserDataStore testUserDataStore;
    @Mock
    UserEntity userEntity;
    @Mock
    UserDomainModel userDomainModel;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private UserRepositoryImpl testUserRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testUserRepository = new UserRepositoryImpl(testUserDataStoreFactory, testUserEntityDataMapper);
    }

    @Test
    public void testReturnType() {
        given(testUserDataStoreFactory.createCloudDataStore()).willReturn(testUserDataStore);
        testUserDataStoreFactory.createCloudDataStore();

        given(testUserDataStoreFactory.createDiscDataStore()).willReturn(testUserDataStore);
        testUserDataStoreFactory.createDiscDataStore();
    }

    @Test
    public void testCloudStoreIsNotNull() {
        given(testUserDataStoreFactory.createCloudDataStore()).willReturn(testUserDataStore);
        testUserDataStore = testUserDataStoreFactory.createCloudDataStore();
        assertNotNull(testUserDataStore);
    }

    @Test
    public void testDiscStoreIsNotNull() {
        given(testUserDataStoreFactory.createDiscDataStore()).willReturn(testUserDataStore);
        testUserDataStore = testUserDataStoreFactory.createDiscDataStore();
        assertNotNull(testUserDataStore);
    }

    @Test
    public void testGetUsers() {
        final List<UserEntity> entityList = new ArrayList<>();
        entityList.add(new UserEntity());

        given(testUserDataStoreFactory.createCloudDataStore()).willReturn(testUserDataStore);
        given(testUserDataStore.userEntityList()).willReturn(Flowable.just(entityList));
        testUserRepository.getUsers();

        verify(testUserDataStoreFactory).createCloudDataStore();
        verify(testUserDataStore).userEntityList();
    }
}