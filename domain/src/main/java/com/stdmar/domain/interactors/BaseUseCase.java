package com.stdmar.domain.interactors;

import com.stdmar.domain.IPostExecutionThread;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by sma on 05.09.17.
 */

public abstract class BaseUseCase<T, Params> {

    private static final String EMPTY = "";
    private static final String PING_ADDRESS = "www.google.com";

    private CompositeDisposable disposables;
    private IPostExecutionThread postExecutionThread;

    public abstract Flowable<T> buildUseCaseObservable(Params params);

    public BaseUseCase(IPostExecutionThread thread) {
        this.postExecutionThread = thread;
        disposables = new CompositeDisposable();
    }

    public void execute(final DisposableSubscriber<T> disposableSubscriber, final Params params) {
        final Flowable<T> responseFlowable = getResponseFlowable(params);
        addDisposable(responseFlowable.subscribeWith(disposableSubscriber));

//        final Flowable<Boolean> internetState = getInternetState();
//        internetState
//                .subscribeOn(Schedulers.io())
//                .observeOn(postExecutionThread.getScheduler())
//                .subscribe(new LocalSubscriber() {
//                    @Override
//                    public void onNext(Boolean hasInternet) {
//                        if (hasInternet) {
//                            addDisposable(responseFlowable.subscribeWith(disposableSubscriber));
//                        } else {
//                            disposableSubscriber.onError(new NetworkConnectionException());
//                        }
//                    }
//                });
    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    private void addDisposable(Disposable localDisposable) {
        if (localDisposable == null) return;
        disposables.add(localDisposable);
    }

    private Flowable<T> getResponseFlowable(final Params params) {
        return buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.getScheduler());
    }

    private Flowable<Boolean> getInternetState() {
        return Flowable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return pingAddress(PING_ADDRESS);
            }
        });
    }

    private boolean pingAddress(final String url) {
        try {
            final InetAddress address = InetAddress.getByName(url);
            return address != null && !EMPTY.equals(address.getHostAddress());
        } catch (final UnknownHostException e) {
            System.err.println("pingAddress = " + e);
            return false;
        }
    }
}
