package com.zhiguo.dagger2test.di.app;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by TiaoPi on 2017/11/3.
 */

@Module
public abstract class AppModule {

    @Binds
    abstract Context bindContext(Application application);

}
