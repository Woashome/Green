package com.example.green.ui.activity.homepage;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.model.HomePageModel;
import com.example.green.ui.activity.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseMvpActivity<CommonPresenter, HomePageModel>
        implements ICommonView {


    @BindView(R.id.user_phone)
    EditText mUserPhone;
    @BindView(R.id.user_psw)
    EditText mUserPsw;
    @BindView(R.id.forget_psw)
    TextView mForgetPsw;
    @BindView(R.id.ll_register)
    LinearLayout mLlRegister;
    @BindView(R.id.login)
    Button mLogin;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected HomePageModel initModel() {
        return new HomePageModel();
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }


    @OnClick({R.id.forget_psw, R.id.ll_register, R.id.login})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.forget_psw:
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
                break;
            case R.id.ll_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.login:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }
    }
}
