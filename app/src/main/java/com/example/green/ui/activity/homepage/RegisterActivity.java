package com.example.green.ui.activity.homepage;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.local_utils.MyDialog;
import com.example.green.model.HomePageModel;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseMvpActivity<CommonPresenter, HomePageModel>
        implements ICommonView, MyDialog.OnCenterItemClickListener {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
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
    @BindView(R.id.user_invitation_code)
    EditText mUserInvitationCode;

    private MyDialog mMyDialog;

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
        return R.layout.activity_register;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.back, R.id.acquire_code, R.id.bt_register})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.acquire_code: // 获取验证码
                break;
            case R.id.bt_register: // 立即注册
                show();
                break;
        }
    }

    private void show() {
        mMyDialog = new MyDialog(this, R.layout.layout_pop_register, new int[]
                {R.id.bt_login});
        mMyDialog.setOnCenterItemClickListener(this);
        mMyDialog.setCanceledOnTouchOutside(false);// 设置外部点击消失
        mMyDialog.show();
    }

    @Override
    public void OnCenterItemClick(MyDialog dialog, View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                toastActivity("立即登录");
                break;
        }
    }
}
