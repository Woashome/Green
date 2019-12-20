package com.example.green.ui.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.register.AccquireSmsbean;
import com.example.green.bean.register.ModificationPswbean;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.local_utils.SPUtils;
import com.example.green.model.MineModel;
import com.example.green.model.UserModel;
import com.example.green.ui.activity.homepage.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginPswActivity extends BaseMvpActivity<CommonPresenter, UserModel>
        implements ICommonView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.acquireCode)
    TextView mAcquireCode;
    @BindView(R.id.et_psw)
    EditText mEtPsw;
    @BindView(R.id.et_psw_confirm)
    EditText mEtPswConfirm;
    private CountDownTimer mStart;
    private int TYPE = 6;
    private static final String TAG = "LoginPswActivity";

    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        String phone = SPUtils.getInstance().getValue(SPUtils.KEY_USER_NAME, "");
        mTvPhone.setText(phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
        mEtCode.addTextChangedListener(codeEditInput); // 监听验证码输入状态
    }

    private TextWatcher codeEditInput = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        //一般我们都是在这个里面进行我们文本框的输入的判断，上面两个方法用到的很少
        @Override
        public void afterTextChanged(Editable s) {
            String code = mEtCode.getText().toString().trim();
            Pattern pattern = Pattern.compile("[0-9]{6}");
            Matcher m = pattern.matcher(code);
            if (m.matches()) {
                mEtPsw.requestFocus(); // 获取焦点 光标出现
            }
        }
    };

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
        return R.layout.activity_login_psw;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.ACCQUIRE_CODE:
                AccquireSmsbean accquireSmsbean = (AccquireSmsbean) t[0];
                if (null != accquireSmsbean && accquireSmsbean.getCode().equals("200")) {
                    toastActivity("发送成功");
                } else {
                    toastActivity(accquireSmsbean.getMessage());
                }
                break;
            case ApiConfig.MODIFICATION_PSW:
                ModificationPswbean modificationPswbean = (ModificationPswbean) t[0];
                if (null != modificationPswbean && modificationPswbean.getCode().equals("200")) {
                    toastActivity("修改密码成功 请重新登录");
                    startActivity(new Intent(this, LoginActivity.class));
                    finish();
                } else {
                    toastActivity(modificationPswbean.getMessage());
                }
                break;
        }
    }

    @OnClick({R.id.back, R.id.acquireCode, R.id.bt_confirm})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.acquireCode:
                // 手机号码 正则判断
                String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
                if (!TextUtils.isEmpty(mTvPhone.getText().toString().trim()) &&
                        mTvPhone.getText().toString().trim().matches(telRegex)) {
                    mStart = new CountDownTimer(60000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            mAcquireCode.setText("重新发送" + "(" + millisUntilFinished / 1000 + "s)");
                            mAcquireCode.setClickable(false);
                        }

                        @Override
                        public void onFinish() {
                            mAcquireCode.setClickable(true);
                            mAcquireCode.setText("获取验证码");
                            mAcquireCode.setClickable(true);
                        }
                    }.start();
                    mPresenter.getData(ApiConfig.ACCQUIRE_CODE, mTvPhone.getText().toString().trim(), TYPE, LoadConfig.NORMAL);
                } else {
                    toastActivity("手机号为空");
                }
                break;
            case R.id.bt_confirm:
                String key = SPUtils.getInstance().getValue(SPUtils.KEY_USER_TOKEN, "");
                String phone = mTvPhone.getText().toString().trim();
                String code = mEtCode.getText().toString().trim();
                String psw = mEtPsw.getText().toString().trim();
                String psw_confirm = mEtPswConfirm.getText().toString().trim();
                if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(code) && !TextUtils.isEmpty(psw) && !TextUtils.isEmpty(psw_confirm))
                    mPresenter.getData(ApiConfig.MODIFICATION_PSW, key, code, psw, psw_confirm, phone);
                else toastActivity("请输入完整信息");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mStart != null) {
            mStart.cancel();
        }
    }
}
