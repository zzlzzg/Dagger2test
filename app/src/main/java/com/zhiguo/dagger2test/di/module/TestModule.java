package com.zhiguo.dagger2test.di.module;

import dagger.Module;

/**
 * Created by TiaoPi on 2017/11/3.
 */

@Module
public abstract class TestModule{

    /**
     * 当Component类需要依赖对象时,他就会根据返回值的类型来在有@Provides注解的方法中选择调用哪个方法
     * @return
     */
    /**
     * TODO  不能使用    必须用在构造函数上才行
     */
//    @Provides //声明Module类中哪些方法是用来提供依赖对象的
//    @Named("Bean1")
//    public Bean1 getBean1(){
//        Bean1 bean1 = new Bean1();
//        bean1.setName("TiaoPi-1");
//        return bean1;
//    }


}
