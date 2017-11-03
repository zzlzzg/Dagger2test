package com.zhiguo.dagger2test.http;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by TiaoPi on 2017/11/3.
 */

public interface ApiService {

    //data/sk/101010100.html
    @GET("data/sk/{cityId}.html")
    Observable<ResponseBody> getJokes(@Path("cityId") String cityId);

}
