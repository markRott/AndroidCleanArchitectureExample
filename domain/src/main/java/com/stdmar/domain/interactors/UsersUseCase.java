package com.stdmar.domain.interactors;

import com.stdmar.domain.IRepository;
import com.stdmar.domain.IPostExecutionThread;
import com.stdmar.domain.models.UserDomainModel;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 05.09.17.
 */

public class UsersUseCase extends BaseUseCase<List<UserDomainModel>, Void> {

    private IRepository repository;

    public UsersUseCase(IPostExecutionThread thread, IRepository repository) {

        super(thread);
        this.repository = repository;
    }

    @Override
    Flowable<List<UserDomainModel>> buildUseCaseObservable(Void unused) {

        return repository.getUsers();
    }
}
