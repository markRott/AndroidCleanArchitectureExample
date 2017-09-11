package com.stdmar.domain.interactors.user;

import com.stdmar.domain.interactors.BaseUseCase;
import com.stdmar.domain.interfaces.IDetailUserRepository;
import com.stdmar.domain.interfaces.IPostExecutionThread;
import com.stdmar.domain.models.UserDomainModel;

import io.reactivex.Flowable;

/**
 * Created by sma on 11.09.17.
 */

public class DetailUserUseCase extends BaseUseCase<UserDomainModel, DetailUserUseCase.Params> {

    private IDetailUserRepository repository;

    public DetailUserUseCase(IPostExecutionThread thread, IDetailUserRepository repository) {
        super(thread);
        this.repository = repository;
    }

    @Override
    public Flowable<UserDomainModel> buildUseCaseObservable(Params params) {

        return repository.getUserById(params.userId);
    }

    public static class Params {

        private int userId;

        private Params(int userId) {
            this.userId = userId;
        }

        public static Params buildParams(final int userId) {
            return new Params(userId);
        }
    }

}
