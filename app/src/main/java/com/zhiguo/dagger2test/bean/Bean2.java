package com.zhiguo.dagger2test.bean;

import javax.inject.Inject;

/**
 * Created by TiaoPi on 2017/11/3.
 */

public class Bean2 {

    @Inject  //构造函数上声明了@Inject注解
    public Bean2(){}

    private String name2;

    public String getName2() {
        return "TiaoPi-2";
    }

}
