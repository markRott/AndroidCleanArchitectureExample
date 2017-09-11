package com.stdmar.domain.interactors.user;

import com.stdmar.domain.interfaces.IUserRepository;
import com.stdmar.domain.interfaces.IPostExecutionThread;
import com.stdmar.domain.interactors.BaseUseCase;
import com.stdmar.domain.models.UserDomainModel;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 05.09.17.
 */

public class UsersUseCase extends BaseUseCase<List<UserDomainModel>, Void> {

    private IUserRepository repository;

    public UsersUseCase(IPostExecutionThread thread, IUserRepository repository) {
        super(thread);
        this.repository = repository;
    }

    @Override
    public Flowable<List<UserDomainModel>> buildUseCaseObservable(Void unused) {

        return repository.getUsers();
    }
}
