package com.stdmar.fcleanarchprj.di.app.modules;

import com.stdmar.domain.interfaces.IPostExecutionThread;
import com.stdmar.fcleanarchprj.utils.UiThreadImpl;

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
