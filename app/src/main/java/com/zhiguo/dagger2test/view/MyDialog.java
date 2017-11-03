package com.zhiguo.dagger2test.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import javax.inject.Inject;

/**
 * Created by TiaoPi on 2017/11/3.
 */

public class MyDialog {

    @Inject
    public MyDialog(){

    }

    public  MaterialDialog showDailog(Context context){

        MaterialDialog materialDialog = new MaterialDialog.Builder(context)
                .title("TiaoPi")
                .content("试试")
                .negativeText("取消")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
        return materialDialog;
    }


}
