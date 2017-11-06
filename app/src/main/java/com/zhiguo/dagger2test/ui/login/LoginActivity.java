package com.zhiguo.dagger2test.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhiguo.dagger2test.R;
import com.zhiguo.dagger2test.base.BaseActivity;
import com.zhiguo.dagger2test.utils.ToastUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nucleus.factory.RequiresPresenter;

/**
 * Created by TiaoPi on 2017/11/6.
 */

@RequiresPresenter(LoginPersenter.class)
public class LoginActivity extends BaseActivity<LoginPersenter> {


    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
    @BindView(R.id.login_state_text_view)
    TextView loginStateTextView;

    @Inject
    ToastUtil toastUtil;

    LoginPersenter loginPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        showBack();
        loginProgress.setVisibility(View.GONE);
        loginStateTextView.setVisibility(View.GONE);
        loginPersenter = getPresenter();
    }

    @OnClick(R.id.email_sign_in_button)
    public void onViewClicked() {
        loginProgress.setVisibility(View.VISIBLE);
        loginStateTextView.setVisibility(View.GONE);
        //隐藏键盘
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

        loginPersenter.loginApp(email.getText().toString(), password.getText().toString());
    }

    public void progressDismiss(String s) {
        loginProgress.setVisibility(View.GONE);
        loginStateTextView.setVisibility(View.VISIBLE);
        loginStateTextView.setText(s);
        toastUtil.showToast(s);
    }

}

