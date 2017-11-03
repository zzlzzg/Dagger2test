package com.zhiguo.dagger2test.ui.mvp;

import android.os.Bundle;

import com.zhiguo.dagger2test.App;
import com.zhiguo.dagger2test.base.BasePersenter;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by TiaoPi on 2017/11/3.
 */

public class MVPTestPersenter extends BasePersenter<MVPTestActivity> {

    public static final int GET_JSON = 1;

    @Override
    protected void request() {

    }

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        restartableFirst(GET_JSON, new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return  App.getInstance().httpRetrofit.getApiService().getJokes("101010100")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMap(new Func1<ResponseBody, Observable<String>>() {
                            @Override
                            public Observable<String> call(ResponseBody responseBody) {
                                try {
                                    return Observable.just(responseBody.string().toString());
                                } catch (IOException e) {
                                    return Observable.just("出错了");
                                }
                            }
                        });
            }
        }, new Action2<MVPTestActivity, String>() {
            @Override
            public void call(MVPTestActivity mvpTestActivity, String string) {
                mvpTestActivity.showView(string);
            }
        }, new Action2<MVPTestActivity, Throwable>() {
            @Override
            public void call(MVPTestActivity mvpTestActivity, Throwable throwable) {
                mvpTestActivity.showView(throwable.getMessage());
            }
        });

    }

    public void getJson(){
        start(GET_JSON);
    }

}
