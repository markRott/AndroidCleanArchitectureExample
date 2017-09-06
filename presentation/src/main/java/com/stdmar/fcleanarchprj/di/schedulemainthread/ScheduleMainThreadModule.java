package com.stdmar.fcleanarchprj.di.schedulemainthread;

import com.stdmar.domain.IPostExecutionThread;
import com.stdmar.fcleanarchprj.UiThreadImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 06.09.17.
 */

@Module
public class ScheduleMainThreadModule {

    public ScheduleMainThreadModule() {
    }

    @Provides
    @Singleton
    public IPostExecutionThread providePostExecutionThread() {

        return new UiThreadImpl();
    }

}
