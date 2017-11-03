package com.zhiguo.dagger2test.bean;

/**
 * Created by TiaoPi on 2017/11/3.
 */

public class Bean1 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "name='" + name + '\'' +
                '}';
    }

}
