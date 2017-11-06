package com.zhiguo.dagger2test.ui.login;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.zhiguo.dagger2test.base.BasePersenter;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by TiaoPi on 2017/11/6.
 */

public class LoginPersenter extends BasePersenter<LoginActivity> {

    private static final int LOGIN_CODE = 4;

    private String name;
    private String password;

    @Override
    protected void request() {

    }

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        restartableFirst(LOGIN_CODE, new Func0<Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call() {
                return Observable.timer(LOGIN_CODE,TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMap(new Func1<Long, Observable<Boolean>>() {
                            @Override
                            public Observable<Boolean> call(Long aLong) {
                                if (name.equals("zhiguo115@163.com") && password.equals("123456"))
                                    return Observable.just(true);
                                else
                                    return Observable.just(false);
                            }
                        });
            }
        }, new Action2<LoginActivity, Boolean>() {
            @Override
            public void call(LoginActivity loginActivity, Boolean b) {
                if (b) {
                    loginActivity.progressDismiss("登录成功");
                }else {
                    loginActivity.progressDismiss("登录失败");
                }
            }
        });

    }

    public void loginApp (@NonNull String name, @NonNull String password){
        this.name = name;
        this.password = password;
       start(LOGIN_CODE);
    }

}
