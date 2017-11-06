package com.zhiguo.dagger2test.ui.mvp;

import android.os.Bundle;

import com.zhiguo.dagger2test.R;
import com.zhiguo.dagger2test.base.BaseActivity;
import com.zhiguo.dagger2test.utils.ActivityUtils;

import javax.inject.Inject;

public class MVPTestFragmentActivity extends BaseActivity {

    @Inject
    MVPTestFragment mvpTestFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvptest_fragment);

        showBack();

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager()
                ,mvpTestFragment,R.id.contentFrame);

    }

}
