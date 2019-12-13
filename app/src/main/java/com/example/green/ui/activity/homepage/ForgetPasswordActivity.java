package com.example.green.ui.activity.homepage;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.model.HomePageModel;
import com.example.green.model.UserModel;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPasswordActivity extends BaseMvpActivity<CommonPresenter, UserModel>
        implements ICommonView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.step_one)
    ImageView mStepOne;
    @BindView(R.id.step_two)
    ImageView mStepTwo;
    @BindView(R.id.user_phone)
    EditText mUserPhone;
    @BindView(R.id.user_code)
    EditText mUserCode;
    @BindView(R.id.acquire_code)
    TextView mAcquireCode;
    @BindView(R.id.user_psw)
    EditText mUserPsw;
    @BindView(R.id.user_psw_again)
    EditText mUserPswAgain;
    @BindView(R.id.rl_interior)
    RelativeLayout mRl_interior;
    @BindView(R.id.rl_reset)
    RelativeLayout mRl_reset;
    @BindView(R.id.next_step)
    Button mNextStep;
    @BindView(R.id.reset_login)
    Button mReset_Login;

    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected UserModel initModel() {
        return new UserModel();
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget_password;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }


    @OnClick({R.id.back, R.id.acquire_code, R.id.next_step, R.id.reset_login})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.acquire_code: // 获取验证码
                break;
            case R.id.next_step:
                mRl_interior.setVisibility(View.GONE);
                mStepOne.setVisibility(View.GONE);
                mNextStep.setVisibility(View.GONE);
                mStepTwo.setVisibility(View.VISIBLE);
                mRl_reset.setVisibility(View.VISIBLE);
                mReset_Login.setVisibility(View.VISIBLE);
                break;
            case R.id.reset_login:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }
}
