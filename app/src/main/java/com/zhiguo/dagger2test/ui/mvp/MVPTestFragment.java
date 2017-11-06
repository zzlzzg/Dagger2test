package com.zhiguo.dagger2test.ui.mvp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zhiguo.dagger2test.R;
import com.zhiguo.dagger2test.base.BaseFragment;
import com.zhiguo.dagger2test.di.scope.ActivityScope;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import nucleus.factory.RequiresPresenter;

@ActivityScope
@RequiresPresenter(MVPTestFragmentPersenter.class)
public class MVPTestFragment extends BaseFragment<MVPTestFragmentPersenter> {

    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.textView2)
    TextView textView2;
    Unbinder unbinder;

    @Inject
    public MVPTestFragment() {

    }

    MVPTestFragmentPersenter persenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, Bundle savedInstanceState) {

        persenter = getPresenter();

        View view = inflater.inflate(R.layout.fragment_mvp_test, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button7)
    public void onViewClicked() {
        persenter.getJson();
    }

    public void showView (String s){
        textView2.setText(s);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
