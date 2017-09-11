package com.stdmar.domain.interactors.stubclasses;

import com.stdmar.domain.interactors.BaseUseCase;
import com.stdmar.domain.interfaces.IPostExecutionThread;

import io.reactivex.Flowable;

/**
 * Created by sma on 11.09.17.
 */

public class UseCaseTestClass extends BaseUseCase<Object, TestParams> {

    public UseCaseTestClass(IPostExecutionThread thread) {
        super(thread);
    }

    @Override
    public Flowable<Object> buildUseCaseObservable(TestParams params) {

        return Flowable.empty();
    }
}