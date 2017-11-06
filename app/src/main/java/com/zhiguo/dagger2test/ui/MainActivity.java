package com.zhiguo.dagger2test.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.zhiguo.dagger2test.R;
import com.zhiguo.dagger2test.base.BaseActivity;
import com.zhiguo.dagger2test.ui.login.LoginActivity;
import com.zhiguo.dagger2test.ui.mvp.MVPTestActivity;
import com.zhiguo.dagger2test.ui.mvp.MVPTestFragmentActivity;

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
       final Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.button:
                intent.setClass(MainActivity.this,TestActivity.class);
                this.startActivity(intent);
                break;
            case R.id.button2:
                new MaterialDialog.Builder(this).items(R.array.intent_item)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                                switch (position) {
                                    case 0:
                                        intent.setClass(MainActivity.this, MVPTestActivity.class);
                                        MainActivity.this.startActivity(intent);
                                        break;
                                    case 1:
                                        intent.setClass(MainActivity.this, MVPTestFragmentActivity.class);
                                        MainActivity.this.startActivity(intent);
                                        break;
                                }
                            }
                        }).show();
                break;
            case R.id.button3:
                intent.setClass(MainActivity.this, LoginActivity.class);
                this.startActivity(intent);
                break;
        }

    }
}
