package com.zhiguo.dagger2test.ui.mvp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.zhiguo.dagger2test.R;
import com.zhiguo.dagger2test.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nucleus.factory.RequiresPresenter;

@RequiresPresenter(MVPTestPersenter.class)
public class MVPTestActivity extends BaseActivity<MVPTestPersenter> {

    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.textView)
    TextView textView;

    MVPTestPersenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvptest);
        ButterKnife.bind(this);

        showBack();
        presenter = getPresenter();

    }

    public void showView(String string){
        textView.setText(string);
    }

    @OnClick(R.id.button6)
    public void onViewClicked() {
        presenter.getJson();
    }
}
