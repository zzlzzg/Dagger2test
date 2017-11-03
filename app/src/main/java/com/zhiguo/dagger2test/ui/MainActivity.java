package com.zhiguo.dagger2test.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhiguo.dagger2test.R;
import com.zhiguo.dagger2test.base.BaseActivity;
import com.zhiguo.dagger2test.ui.mvp.MVPTestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.button, R.id.button2, R.id.button3})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.button:
                intent.setClass(MainActivity.this,TestActivity.class);
                break;
            case R.id.button2:
                intent.setClass(MainActivity.this, MVPTestActivity.class);
                break;
            case R.id.button3:

                break;
        }
        this.startActivity(intent);
    }
}
