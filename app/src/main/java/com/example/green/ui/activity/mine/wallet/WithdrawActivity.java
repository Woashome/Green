package com.example.green.ui.activity.mine.wallet;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.model.MineModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WithdrawActivity extends BaseMvpActivity<CommonPresenter, MineModel>
        implements ICommonView {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jifen)
    TextView mJifen;
    @BindView(R.id.all_jifen)
    TextView mAllJifen;
    @BindView(R.id.et_jifen)
    EditText mEtJifen;
    @BindView(R.id.procedure)
    TextView mProcedure;
    @BindView(R.id.et_chikaren)
    EditText mEtChikaren;
    @BindView(R.id.et_kahao)
    EditText mEtKahao;
    @BindView(R.id.et_kaihuhang)
    EditText mEtKaihuhang;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.acquire_yanzheng)
    TextView mAcquireYanzheng;
    @BindView(R.id.bt_withdraw)
    Button mBtWithdraw;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected MineModel initModel() {
        return new MineModel();
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_withdraw;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.back, R.id.all_jifen, R.id.acquire_yanzheng, R.id.bt_withdraw})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.all_jifen:
                break;
            case R.id.acquire_yanzheng:
                break;
            case R.id.bt_withdraw:
                break;
        }
    }
}
