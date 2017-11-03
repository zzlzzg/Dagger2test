package com.zhiguo.dagger2test.base;

import nucleus.presenter.RxPresenter;

/**
 * Created by TiaoPi on 2017/11/3.
 */

public abstract class BasePersenter<V> extends RxPresenter<V> {

    protected abstract void request();

}
