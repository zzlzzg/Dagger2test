package com.zhiguo.dagger2test.di.app;

import com.zhiguo.dagger2test.di.module.MVPTestModule;
import com.zhiguo.dagger2test.di.module.MainModule;
import com.zhiguo.dagger2test.di.module.TestModule;
import com.zhiguo.dagger2test.di.scope.ActivityScope;
import com.zhiguo.dagger2test.ui.MainActivity;
import com.zhiguo.dagger2test.ui.TestActivity;
import com.zhiguo.dagger2test.ui.login.LoginActivity;
import com.zhiguo.dagger2test.ui.mvp.MVPTestActivity;
import com.zhiguo.dagger2test.ui.mvp.MVPTestFragmentActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by TiaoPi on 2017/11/3.
 *Activity管理类
 */

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = TestModule.class)
    abstract TestActivity testActivity();


    @ActivityScope
    @ContributesAndroidInjector(modules = MVPTestModule.class)
    abstract MVPTestActivity mvpTestActivity();


    @ActivityScope
    @ContributesAndroidInjector
    abstract MVPTestFragmentActivity mvpTestFragmentActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract LoginActivity loginActivity();

}
