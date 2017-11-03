package com.zhiguo.dagger2test;


import com.zhiguo.dagger2test.di.app.AppComponent;
import com.zhiguo.dagger2test.di.app.DaggerAppComponent;
import com.zhiguo.dagger2test.http.HttpRetrofit;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by TiaoPi on 2017/11/2.
 */

public class App extends DaggerApplication{

    @Inject
    public HttpRetrofit httpRetrofit;

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent  = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

    public static App getInstance(){
        return app;
    }

}
