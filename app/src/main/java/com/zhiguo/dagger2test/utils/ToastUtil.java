package com.zhiguo.dagger2test.utils;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * Created by TiaoPi on 2017/10/30.
 * 如果要使用第三方的地方
 */

public class ToastUtil {

    private Context mContext;

    /**
     * Context 已经自动注入不需要自己添加
     * @param context
     */
    @Inject
    public ToastUtil(Context context){
        this.mContext = context;
    }

    public void showToast(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }

}
