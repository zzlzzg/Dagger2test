package com.zhiguo.dagger2test.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhiguo.dagger2test.R;
import com.zhiguo.dagger2test.base.BaseActivity;
import com.zhiguo.dagger2test.bean.Bean2;
import com.zhiguo.dagger2test.di.scope.ActivityScope;
import com.zhiguo.dagger2test.utils.ToastUtil;
import com.zhiguo.dagger2test.view.MyDialog;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@ActivityScope
public class TestActivity extends BaseActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;

    @Inject
    Bean2 bean2;

    @Inject
    ToastUtil toastUtil;

    @Inject
    MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        showBack();

    }

    @OnClick({R.id.button1, R.id.button4,R.id.button5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                textView1.setText(bean2.getName2());
                break;
            case R.id.button4:
                toastUtil.showToast("123456");
                break;
            case R.id.button5:
                myDialog.showDailog(this);
                break;
        }
    }
}
