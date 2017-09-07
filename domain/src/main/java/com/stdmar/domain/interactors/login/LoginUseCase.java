package com.stdmar.domain.interactors.login;

import com.stdmar.domain.ILoginRepository;
import com.stdmar.domain.IPostExecutionThread;
import com.stdmar.domain.interactors.BaseUseCase;
import com.stdmar.domain.models.LoginDomainModel;

import io.reactivex.Flowable;

/**
 * Created by sma on 07.09.17.
 */

public class LoginUseCase extends BaseUseCase<LoginDomainModel, LoginUseCase.Params> {

    private ILoginRepository repository;

    public LoginUseCase(IPostExecutionThread thread, ILoginRepository repo) {
        super(thread);
        this.repository = repo;
    }

    @Override
    public Flowable<LoginDomainModel> buildUseCaseObservable(final Params params) {

        return repository.login(/*params.login, params.password*/);
    }

    public static final class Params {

        private final String login;
        private final String password;

        private Params(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public static Params initParams(final String login, final String password) {
            return new Params(login, password);
        }
    }
}
