package com.zhiguo.dagger2test.di.app;

import android.app.Application;

import com.zhiguo.dagger2test.App;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by TiaoPi on 2017/11/3.
 */

@Component(modules = {
        AppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication>{

//    @Component.Builder
//    abstract class builder extends AndroidInjector.Builder<App> {}

    void inject(App application);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }

}
