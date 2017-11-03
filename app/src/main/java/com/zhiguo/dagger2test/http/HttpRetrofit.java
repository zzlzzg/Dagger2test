package com.zhiguo.dagger2test.http;

import android.content.Context;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by TiaoPi on 2017/11/3.
 */

public class HttpRetrofit {

//    "101010100"

    private static String HTTP_URL = "http://www.weather.com.cn/";

    @Inject
    public HttpRetrofit(Context context){

    }

    public ApiService getApiService(){

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(HTTP_URL)  //服务器地址
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }

}
